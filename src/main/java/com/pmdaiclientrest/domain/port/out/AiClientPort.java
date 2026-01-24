package com.pmdaiclientrest.domain.port.out;

/**
 * Domain port that defines the contract for generating
 * AI-based responses from a textual prompt.
 * <p>
 * This interface is provider-agnostic and contains
 * no infrastructure or framework concerns.
 */
public interface AiClientPort {

    /**
     * Generates a response for the given prompt.
     *
     * @param prompt the input text
     * @return the generated response
     */
    String generateResponse(String prompt);
}
