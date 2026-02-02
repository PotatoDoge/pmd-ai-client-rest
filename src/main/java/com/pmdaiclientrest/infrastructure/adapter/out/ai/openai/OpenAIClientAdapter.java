package com.pmdaiclientrest.infrastructure.adapter.out.ai.openai;

import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.domain.port.out.AiClientPort;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.PromptValidator;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatRequest;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatResponse;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.mapper.OpenAiResponseMapper;
import com.pmdaiclientrest.infrastructure.config.OpenAiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.pmdaiclientrest.infrastructure.adapter.out.ai.util.PromptContext.buildMessages;

/**
 * Infrastructure adapter that connects the application
 * to an OpenAI provider.
 * <p>
 * This class is responsible for:
 * - Orchestrating the request/response flow
 * - Adapting OpenAI responses to the domain contract
 */
@Component("OpenAI")
@RequiredArgsConstructor
@Slf4j
public class OpenAIClientAdapter implements AiClientPort {

    private final OpenAiProperties properties;
    private final OpenAiResponseMapper mapper;
    private final PromptValidator promptValidator;
    private final OpenAIHttpClient httpClient;
    private final OpenAIResponseValidator responseValidator;
    private final OpenAIAdapterLogger logger;

    @Override
    public AiResponse generateResponse(String prompt) {
        promptValidator.validate(prompt);

        OpenAiChatRequest request = buildRequest(prompt);
        logger.logRequest(request);

        OpenAiChatResponse response = httpClient.sendRequest(request);
        
        responseValidator.validateResponse(response);
        logger.logResponse(response);

        return mapper.toDomain(response);
    }

    private OpenAiChatRequest buildRequest(String prompt) {
        return new OpenAiChatRequest(
                properties.model(),
                buildMessages(prompt));
    }
}
