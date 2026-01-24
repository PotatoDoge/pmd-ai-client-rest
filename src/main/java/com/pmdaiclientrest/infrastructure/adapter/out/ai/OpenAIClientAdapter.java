package com.pmdaiclientrest.infrastructure.adapter.out.ai;

import com.pmdaiclientrest.domain.port.out.AiClientPort;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatRequest;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatResponse;
import com.pmdaiclientrest.infrastructure.config.OpenAiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

/**
 * Infrastructure adapter that connects the application
 * to an OpenAI provider.
 * <p>
 * This class is responsible for:
 * - Making HTTP calls
 * - Handling provider-specific request/response formats
 * - Adapting them to the domain contract
 */
@Component("OpenAI")
@RequiredArgsConstructor
@Slf4j
public class OpenAIClientAdapter implements AiClientPort {

    private final RestClient aiRestClient;
    private final OpenAiProperties properties;

    @Override
    public String generateResponse(String prompt) {

        OpenAiChatRequest request = new OpenAiChatRequest(
                properties.model(),
                List.of(new OpenAiChatRequest.Message("user", prompt))
        );

        OpenAiChatResponse response = aiRestClient
                .post()
                .uri(properties.baseUrl() + properties.chatPath())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + properties.apiKey())
                .body(request)
                .retrieve()
                .body(OpenAiChatResponse.class);

        if (response == null || response.choices().isEmpty()) {
            throw new IllegalStateException("OpenAI returned no response");
        }

        return response.choices()
                .getFirst()
                .message()
                .content();
    }
}
