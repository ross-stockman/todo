package dev.stockman.todo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @GetMapping
    public String getSample() {
        log.info("GET /api/sample");
        throw new IllegalStateException("Sample exception");
    }
}
