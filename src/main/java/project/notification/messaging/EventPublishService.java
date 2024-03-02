package project.notification.messaging;

import java.security.SecureRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventPublishService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final SecureRandom secureRandom = new SecureRandom();

    @Scheduled(fixedRate = 1000)
    public void publishEvents() {
        int eventType = secureRandom.nextInt(10);
        int userId = generateUserId();
        int orderId = generateOrderId();

        switch (eventType) {
            case 0 -> {
                String message = String.format("User [%d] signed up", userId);
                kafkaTemplate.send("business-logs", "user", message);
            }
            case 1 -> {
                String message = String.format("Profile updated by user [%d]", userId);
                kafkaTemplate.send("business-logs", "user", message);
            }
            case 2 -> {
                String message = String.format("Account deleted by user [%d]", userId);
                kafkaTemplate.send("business-logs", "user", message);
            }
            case 3 -> {
                String message = String.format("Password reset requested by user [%d]", userId);
                kafkaTemplate.send("business-logs", "user", message);
            }
            case 4 -> {
                String message = String.format("Review posted by user [%d]", userId);
                kafkaTemplate.send("business-logs", "user", message);
            }
            case 5 -> {
                String message = String.format("Order [%d] created", orderId);
                kafkaTemplate.send("business-logs", "order", message);
            }
            case 6 -> {
                String message = String.format("Order [%d] item added", orderId);
                kafkaTemplate.send("business-logs", "order", message);
            }
            case 7 -> {
                String message = String.format("Order [%d] item removed", orderId);
                kafkaTemplate.send("business-logs", "order", message);
            }
            case 8 -> {
                String message = String.format("Order [%d] cancelled by user [%d]", orderId, userId);
                kafkaTemplate.send("business-logs", "order", message);
            }
            case 9 -> {
                String message = String.format("Order [%d] returned for refund", orderId);
                kafkaTemplate.send("business-logs", "order", message);
            }
        }
    }

    private int generateUserId() {
        return secureRandom.nextInt(9999) + 1;
    }

    private int generateOrderId() {
        return secureRandom.nextInt(9999) + 1;
    }
}
