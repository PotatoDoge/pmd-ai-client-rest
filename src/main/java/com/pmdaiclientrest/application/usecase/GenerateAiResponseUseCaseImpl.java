package com.pmdaiclientrest.application.usecase;

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

    private final GenerateAiResponsePort domainPort;

    @Override
    public String generate(String prompt) {
        return domainPort.generate(prompt);
    }
}