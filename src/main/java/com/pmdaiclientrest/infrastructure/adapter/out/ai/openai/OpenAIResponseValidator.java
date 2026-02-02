package com.pmdaiclientrest.infrastructure.adapter.out.ai.openai;

import com.pmdaiclientrest.domain.exception.AiProviderException;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.AiResponseValidator;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatResponse;
import org.springframework.stereotype.Component;

/**
 * Validates OpenAI API responses.
 */
@Component
class OpenAIResponseValidator implements AiResponseValidator<OpenAiChatResponse> {

    @Override
    public void validateResponse(OpenAiChatResponse response) {
        if (response == null) {
            throw new AiProviderException("OpenAI returned null response");
        }

        if (response.choices() == null || response.choices().isEmpty()) {
            throw new AiProviderException("OpenAI response contains no choices");
        }

        if (response.choices().getFirst() == null) {
            throw new AiProviderException("OpenAI response first choice is null");
        }

        if (response.choices().getFirst().message() == null) {
            throw new AiProviderException("OpenAI response message is null");
        }

        if (response.choices().getFirst().message().content() == null) {
            throw new AiProviderException("OpenAI response content is null");
        }
    }
}