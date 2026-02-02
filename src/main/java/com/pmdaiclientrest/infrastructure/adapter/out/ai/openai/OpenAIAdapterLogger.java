package com.pmdaiclientrest.infrastructure.adapter.out.ai.openai;

import com.pmdaiclientrest.infrastructure.adapter.out.ai.AiAdapterLogger;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatRequest;
import com.pmdaiclientrest.infrastructure.adapter.out.ai.dto.OpenAiChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Formats and logs OpenAI requests and responses.
 */
@Component
@Slf4j
public class OpenAIAdapterLogger implements AiAdapterLogger<OpenAiChatRequest, OpenAiChatResponse> {

    @Override
    public void logRequest(OpenAiChatRequest request) {
        String formattedMessages = request.messages().stream()
                .map(msg -> String.format(" \n[%s]: %s", msg.role().toUpperCase(), msg.content()))
                .collect(Collectors.joining("\n"));

        log.info("Sending request to OpenAI: {} \n", formattedMessages);
    }

    @Override
    public void logResponse(OpenAiChatResponse response) {
        String content = extractContent(response);

        log.info("""
                
                        ========== OpenAI Response ==========
                        ID: {}
                        Object: {}
                        Model: {}
                        Created: {}
                        Choices: {}
                        Content:
                        {}
                        Finish Reason: {}
                        Usage:
                          - Prompt Tokens: {}
                          - Completion Tokens: {}
                          - Total Tokens: {}
                        =====================================
                        """,
                response.id(),
                response.object(),
                response.model(),
                response.created(),
                response.choices().size(),
                content,
                response.choices().getFirst().finishReason(),
                response.usage().promptTokens(),
                response.usage().completionTokens(),
                response.usage().totalTokens());
    }

    private String formatMessages(List<OpenAiChatRequest.Message> messages) {
        return messages.stream()
                .map(msg -> String.format(" \n[%s]: %s", msg.role().toUpperCase(), msg.content()))
                .collect(Collectors.joining("\n"));
    }

    private String extractContent(OpenAiChatResponse response) {
        return response.choices().getFirst().message().content();
    }
}