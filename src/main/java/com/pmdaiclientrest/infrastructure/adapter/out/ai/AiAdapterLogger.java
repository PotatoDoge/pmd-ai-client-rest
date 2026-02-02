package com.pmdaiclientrest.infrastructure.adapter.out.ai;

/**
 * Logs AI provider requests and responses.
 *
 * @param <REQ> the provider-specific request type
 * @param <RES> the provider-specific response type
 */
public interface AiAdapterLogger<REQ, RES> {

    /**
     * Logs the outgoing request.
     *
     * @param request the provider-specific request
     */
    void logRequest(REQ request);

    /**
     * Logs the incoming response.
     *
     * @param response the provider-specific response
     */
    void logResponse(RES response);
}