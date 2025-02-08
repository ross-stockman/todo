package dev.stockman.todo.api.domain;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

/**
 * A filter for managing request tracking through the use of a request ID.
 *
 * This filter is responsible for either extracting an existing request ID from the incoming
 * HTTP request or generating a new one if it is absent. The request ID is added to the response headers
 * and is also made available in logging through SLF4J's {@code MDC}.
 *
 * Functionality:
 * - Reads the request ID from the HTTP request header "x-request-id".
 * - Generates a new UUID-based request ID if none is provided.
 * - Writes the request ID into the HTTP response header "x-request-id".
 * - Stores the request ID in {@code MDC} for traceable logging throughout the request lifecycle.
 * - Cleans up the MDC context after the filter chain execution to prevent cross-request contamination.
 *
 * Use cases:
 * - Enhances traceability for distributed systems by associating logs with a unique request identifier.
 * - Ensures a consistent request ID is provided for every incoming and outgoing request.
 *
 * Related constants:
 * - {@code REQUEST_ID_HEADER}: The name of the HTTP header used for passing the request ID.
 * - {@code REQUEST_ID_LOG_KEY}: The key used to store the request ID in {@code MDC}.
 */
@Component
public class RequestIdFilter implements Filter {

    public static final String REQUEST_ID_HEADER = "x-request-id";
    public static final String REQUEST_ID_LOG_KEY = "requestId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Cast request and response to HTTP types
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // Check for x-request-id header, generate one if missing
        String requestId = httpServletRequest.getHeader(REQUEST_ID_HEADER);
        if (requestId == null || requestId.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }

        // Add x-request-id to response header
        httpServletResponse.setHeader(REQUEST_ID_HEADER, requestId);

        // Add requestId to MDC for logging
        MDC.put(REQUEST_ID_LOG_KEY, requestId);

        try {
            chain.doFilter(request, response);
        } finally {
            // Clear MDC after request processing to avoid issues in async scenarios
            MDC.clear();
        }
    }

}
