package com.pmdaiclientrest.infrastructure.adapter.out.ai.mapper;

import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatResponse;
import org.springframework.stereotype.Component;

/**
 * Maps OpenAI-specific responses to domain models.
 */
@Component
public class OpenAiResponseMapper {

    public AiResponse toDomain(OpenAiChatResponse response) {
        if (response == null || response.choices().isEmpty()) {
            throw new IllegalArgumentException("Invalid OpenAI response");
        }

        return new AiResponse(
                response.choices().getFirst().message().content(),
                response.usage().totalTokens(),
                response.model()
        );
    }
}