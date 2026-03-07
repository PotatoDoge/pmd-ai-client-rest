package com.pmdaiclientrest.application.service;

import com.pmdaiclientrest.application.port.in.GenerateAiResponsePort;
import com.pmdaiclientrest.application.port.out.AiClientPort;
import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.domain.service.GenerateAiResponseDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Application Service - Orchestrates use case
 *
 * Application services:
 * - Implement input ports
 * - Orchestrate workflow between domain and output ports
 * - Delegate business logic to domain layer
 * - Manage transaction boundaries
 * - Handle logging and monitoring
 * - NO business logic here - delegate to domain!
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class GenerateAiResponseService implements GenerateAiResponsePort {

    private final AiClientPort aiClientPort;
    private final GenerateAiResponseDomainService domainService;

    @Override
    public AiResponse generate(String prompt) {
        log.info("Processing AI generation request");

        // Step 1: Validate via domain service
        domainService.validatePrompt(prompt);
        log.info("Prompt validated successfully");

        // Step 2: Call output port to generate response
        AiResponse response = aiClientPort.generateResponse(prompt);
        log.info("AI response generated successfully");

        return response;
    }
}
