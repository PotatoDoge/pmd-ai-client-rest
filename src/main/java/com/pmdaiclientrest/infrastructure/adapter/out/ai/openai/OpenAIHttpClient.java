package com.pmdaiclientrest.infrastructure.adapter.out.ai.openai;

import com.pmdaiclientrest.domain.exception.AiProviderException;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.AiHttpClient;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatRequest;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatResponse;
import com.pmdaiclientrest.infrastructure.config.OpenAiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

/**
 * HTTP client responsible for making OpenAI API calls.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OpenAIHttpClient implements AiHttpClient<OpenAiChatRequest, OpenAiChatResponse> {

    private final RestClient aiRestClient;
    private final OpenAiProperties properties;

    /**
     * Sends a chat request to OpenAI API.
     *
     * @param request the chat request
     * @return the response from OpenAI
     * @throws AiProviderException if the API call fails
     */
    @Override
    public OpenAiChatResponse sendRequest(OpenAiChatRequest request) {
        try {
            return aiRestClient
                    .post()
                    .uri(properties.baseUrl() + properties.chatPath())
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + properties.apiKey())
                    .body(request)
                    .retrieve()
                    .onStatus(status -> status.value() == 429, (req, res) -> {
                        throw new AiProviderException("Rate limit exceeded");
                    })
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        throw new AiProviderException("Client error: " + res.getStatusText());
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, res) -> {
                        throw new AiProviderException("OpenAI server error");
                    })
                    .body(OpenAiChatResponse.class);
        }
        catch (AiProviderException e) {
            log.error("Error calling OpenAI API", e);
            throw e;
        }
        catch (RestClientException e) {
            log.error("REST client error calling OpenAI API", e);
            throw new AiProviderException("Failed to communicate with OpenAI API", e);
        }
    }
}