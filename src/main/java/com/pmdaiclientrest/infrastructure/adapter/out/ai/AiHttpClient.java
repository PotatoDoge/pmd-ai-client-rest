package com.pmdaiclientrest.infrastructure.adapter.out.ai;

/**
 * Generic HTTP client for AI provider communication.
 *
 * @param <REQ> the provider-specific request type
 * @param <RES> the provider-specific response type
 */
public interface AiHttpClient<REQ, RES> {

    /**
     * Sends a request to the AI provider.
     *
     * @param request the provider-specific request
     * @return the provider-specific response
     */
    RES sendRequest(REQ request);
}