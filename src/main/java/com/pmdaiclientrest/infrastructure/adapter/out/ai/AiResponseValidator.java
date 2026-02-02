package com.pmdaiclientrest.infrastructure.adapter.out.ai;

/**
 * Validates AI provider responses.
 *
 * @param <RES> the provider-specific response type
 */
public interface AiResponseValidator<RES> {

    /**
     * Validates the response from an AI provider.
     *
     * @param response the provider-specific response
     * @throws com.pmdaiclientrest.domain.exception.AiProviderException if validation fails
     */
    void validateResponse(RES response);
}