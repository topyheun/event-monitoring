package project.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateLogService {

    public void createLog() {
        log.trace("trace_log");
        log.debug("debug_log");
        log.info("info_log");
        log.warn("warn_log");
        log.error("error_log");
    }
}
