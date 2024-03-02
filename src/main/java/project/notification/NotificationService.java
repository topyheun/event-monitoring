package project.notification;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static project.common.Const.SLACK_WEBHOOK_URL_ORDER_DOMAIN;
import static project.common.Const.SLACK_WEBHOOK_URL_USER_DOMAIN;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import project.notification.dto.OrderMessage;
import project.notification.dto.UserMessage;

@Service
public class NotificationService {

    RestClient restClient = RestClient.create();
    private final Logger logger = LoggerFactory.getLogger("Kafka-Log-Logger");

    public void sendUserDomainNotification(UserMessage userMessage) {
        restClient.post()
            .uri(SLACK_WEBHOOK_URL_USER_DOMAIN)
            .contentType(APPLICATION_JSON)
            .body(userMessage)
            .retrieve();
        logger.info(userMessage.text());
    }

    public void sendOrderDomainNotification(OrderMessage orderMessage) {
        restClient.post()
            .uri(SLACK_WEBHOOK_URL_ORDER_DOMAIN)
            .contentType(APPLICATION_JSON)
            .body(orderMessage)
            .retrieve();
        logger.info(orderMessage.text());
    }
}