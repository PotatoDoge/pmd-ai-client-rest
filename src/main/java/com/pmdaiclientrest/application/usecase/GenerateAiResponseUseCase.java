package com.pmdaiclientrest.application.usecase;

import com.pmdaiclientrest.domain.model.AiResponse;

/**
 * Use case responsible for generating an AI response
 * from a client-provided prompt.
 * <p>
 * This interface defines the application-level contract
 * and is independent of any delivery mechanism or AI provider.
 */
public interface GenerateAiResponseUseCase {

    /**
     * Generates a response based on the given prompt.
     *
     * @param prompt the input text provided by the client
     * @return the generated response text
     */
    AiResponse generate(String prompt);
}
