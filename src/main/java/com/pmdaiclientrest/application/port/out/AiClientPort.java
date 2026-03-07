package com.pmdaiclientrest.application.port.out;

import com.pmdaiclientrest.domain.model.AiResponse;

/**
 * Output Port - Defines dependency interface
 *
 * Output ports:
 * - Define what the application needs from external systems
 * - Use domain models in method signatures
 * - Are implemented by driven adapters (output adapters)
 * - Are called by application services
 */
public interface AiClientPort {

    /**
     * Generates a response for the given prompt.
     *
     * @param prompt the input text
     * @return the generated response
     */
    AiResponse generateResponse(String prompt);
}
