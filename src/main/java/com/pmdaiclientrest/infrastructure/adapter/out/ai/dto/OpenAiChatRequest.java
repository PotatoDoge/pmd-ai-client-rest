package com.pmdaiclientrest.infrastructure.adapter.out.ai.dto;

import java.util.List;

public record OpenAiChatRequest(
        String model,
        List<Message> messages
) {
    public record Message(String role, String content) {}
}