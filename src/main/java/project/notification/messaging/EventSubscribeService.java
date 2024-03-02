package project.notification.messaging;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import project.notification.NotificationService;
import project.notification.dto.OrderMessage;
import project.notification.dto.UserMessage;

@Service
@RequiredArgsConstructor
public class EventSubscribeService {

    private final NotificationService notificationService;

    @KafkaListener(topics = "business-logs", groupId = "business-log-event-consumer")
    public void sendEvent(ConsumerRecord<String, String> record) {
        switch (record.key()) {
            case "user" -> sendUserMessage(record.value());
            case "order" -> sendOrderMessage(record.value());
        }
    }

    private void sendUserMessage(String message) {
        UserMessage userMessage = UserMessage.of(message);
        notificationService.sendUserDomainNotification(userMessage);
    }

    private void sendOrderMessage(String message) {
        OrderMessage orderMessage = OrderMessage.of(message);
        notificationService.sendOrderDomainNotification(orderMessage);
    }
}
