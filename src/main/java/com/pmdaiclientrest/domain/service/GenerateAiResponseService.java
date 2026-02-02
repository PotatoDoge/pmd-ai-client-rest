package com.pmdaiclientrest.domain.service;

import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.domain.port.in.GenerateAiResponsePort;
import com.pmdaiclientrest.domain.port.out.AiClientPort;

/**
 * Domain service containing the business logic
 * for generating AI responses.
 */
public class GenerateAiResponseService implements GenerateAiResponsePort {

    private final AiClientPort aiClientPort;

    public GenerateAiResponseService(AiClientPort aiClientPort) {
        this.aiClientPort = aiClientPort;
    }

    @Override
    public AiResponse generate(String prompt) {
        // Domain rules can live here:
        // - validation
        // - prompt enrichment
        // - policy enforcement

        return aiClientPort.generateResponse(prompt);
    }
}