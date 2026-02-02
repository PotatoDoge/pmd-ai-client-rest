package com.pmdaiclientrest.infrastructure.adapter.out.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Validates prompts before sending to AI providers.
 */
@Component
public class PromptValidator {

    @Value("${ai.prompt-max-length}")
    private int promptMaxLength;

    public void validate(String prompt) {
        if (prompt == null || prompt.isBlank()) {
            throw new IllegalArgumentException("Prompt cannot be null or empty");
        }

        if (prompt.length() > promptMaxLength) {
            throw new IllegalArgumentException(
                    String.format("Prompt exceeds maximum length of %d characters", promptMaxLength));
        }
    }
}