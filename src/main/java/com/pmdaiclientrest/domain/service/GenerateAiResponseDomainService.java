package com.pmdaiclientrest.domain.service;

import com.pmdaiclientrest.domain.exception.AiProviderException;

/**
 * Domain Service - Contains business logic
 *
 * Domain services are used when:
 * - Business logic involves MULTIPLE domain objects
 * - Logic doesn't naturally belong to a single entity
 * - You need to coordinate between different domain models
 *
 * Domain services:
 * - Live in domain layer
 * - Are stateless
 * - Contain pure business logic
 * - Have NO infrastructure dependencies
 * - Work only with domain models
 */
public class GenerateAiResponseDomainService {

    private static final int MAX_PROMPT_LENGTH = 4000;

    /**
     * Business rule: Validate prompt meets requirements
     */
    public void validatePrompt(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            throw new AiProviderException("Prompt cannot be null or empty");
        }

        if (prompt.length() > MAX_PROMPT_LENGTH) {
            throw new AiProviderException(
                String.format("Prompt exceeds maximum length of %d characters", MAX_PROMPT_LENGTH)
            );
        }
    }
}
