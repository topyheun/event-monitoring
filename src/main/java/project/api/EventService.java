package project.api;

import project.api.dto.EventRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void writeEvent(EventRequest eventRequest) {
        logger.trace("Monitoring : " + eventRequest);
        logger.debug("Monitoring : " + eventRequest);
        logger.info("Monitoring : " + eventRequest);
        logger.warn("Monitoring : " + eventRequest);
        logger.error("Monitoring : " + eventRequest);
    }
}
