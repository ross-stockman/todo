package dev.stockman.todo.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * GlobalCorsConfiguration is a Spring configuration class that sets up
 * Cross-Origin Resource Sharing (CORS) for the application.
 *
 * This configuration is applied across all application endpoints and defines the allowed
 * origins, HTTP methods, headers, and other CORS settings through a CorsFilter bean.
 *
 * The configuration allows for customization of CORS policies, such as specifying
 * allowed domains, methods, headers, and credentials. The default implementation in this class
 * currently allows all origins and applies the configuration to all paths.
 */
@Configuration
public class GlobalCorsConfiguration {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Allow the React frontend domain
        // corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "https://your-react-frontend.com"));
        corsConfiguration.setAllowedOrigins(List.of("*"));

        // Allow specific HTTP methods
        // corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allow specific headers
        // corsConfiguration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "x-request-id"));

        // Allow credentials (e.g. cookies, authorization headers)
        // corsConfiguration.setAllowCredentials(true);

        // Define allowed configurations for specific paths
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Apply CORS to all paths

        return new CorsFilter(source);
    }
}
