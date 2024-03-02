package project.notification.dto;

import lombok.Builder;

@Builder
public record OrderMessage(
    String text
) {

    public static OrderMessage of(String message) {
        return OrderMessage.builder()
            .text(message)
            .build();
    }
}
