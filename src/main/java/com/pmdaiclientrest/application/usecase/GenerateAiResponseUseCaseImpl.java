package com.pmdaiclientrest.application.usecase;

import com.pmdaiclientrest.domain.port.out.AiClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Application-level implementation of the GenerateAiResponseUseCase.
 *
 * This class coordinates the interaction between the application
 * and the domain port responsible for generating AI responses.
 */
@Service
@RequiredArgsConstructor
public class GenerateAiResponseUseCaseImpl implements GenerateAiResponseUseCase {

    private final AiClientPort aiClientPort;

    @Override
    public String generate(String prompt) {
        // Future business rules or validations can live here

        // Add context

        return aiClientPort.generateResponse(prompt);
    }
}