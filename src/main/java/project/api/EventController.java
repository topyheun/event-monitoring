package project.api;

import lombok.RequiredArgsConstructor;
import project.api.dto.EventRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/event")
    public void writeEvent(@RequestBody EventRequest eventRequest) {

        eventService.writeEvent(eventRequest);
    }
}
