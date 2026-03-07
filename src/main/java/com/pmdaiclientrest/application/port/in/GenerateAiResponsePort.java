package com.pmdaiclientrest.application.port.in;

import com.pmdaiclientrest.domain.model.AiResponse;

/**
 * Input Port - Defines use case interface
 *
 * Input ports:
 * - Define what the application can do
 * - Use domain models in method signatures
 * - Are implemented by application services
 * - Are called by driving adapters (input adapters)
 */
public interface GenerateAiResponsePort {
    AiResponse generate(String prompt);
}
