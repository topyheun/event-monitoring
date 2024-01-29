package project.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {

    @GetMapping("/log")
    public void log() {
        log.trace("trace_log");
        log.debug("debug_log");
        log.info("info_log");
        log.warn("warn_log");
        log.error("error_log");
    }
}
