package project.api;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogScheduler {

    private final CreateLogService createLogService;

    @Scheduled(fixedRate = 10 * 1000)
    public void createLog() {
        createLogService.createLog();
    }
}
