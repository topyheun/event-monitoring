package project.notification.dto;

import lombok.Builder;

@Builder
public record UserMessage(
    String text
) {

    public static UserMessage of(String message) {
        return UserMessage.builder()
            .text(message)
            .build();
    }
}
