package com.pmdaiclientrest.application.usecase;

import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.domain.port.in.GenerateAiResponsePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Application-level use case implementation.
 * <p>
 * Coordinates the request flow but contains
 * no business rules.
 */
@Service
@RequiredArgsConstructor
public class GenerateAiResponseUseCaseImpl
        implements GenerateAiResponseUseCase {

    private final GenerateAiResponsePort generateAiResponsePort;

    @Override
    public AiResponse generate(String prompt) {
        return generateAiResponsePort.generate(prompt);
    }
}