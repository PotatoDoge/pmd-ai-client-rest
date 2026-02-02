package com.pmdaiclientrest.infrastructure.adapter.out.ai.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * DTO representing the complete response from OpenAI's Chat Completion API.
 * Maps the JSON response structure to Java objects.
 */
public record OpenAiChatResponse(
        String id,
        String object,
        Long created,
        String model,
        List<Choice> choices,
        Usage usage
) {
    /**
     * Represents one completion choice returned by OpenAI.
     * OpenAI can return multiple choices if configured.
     */
    public record Choice(
            Integer index,
            Message message,
            @JsonProperty("finish_reason")
            String finishReason
    ) {}

    /**
     * Represents a message in the conversation.
     * Contains the role (e.g., "assistant") and the actual content.
     */
    public record Message(
            String role,
            String content
    ) {}

    /**
     * Token usage information for the request.
     * Useful for cost tracking and monitoring.
     */
    public record Usage(
            @JsonProperty("prompt_tokens")
            Integer promptTokens,
            @JsonProperty("completion_tokens")
            Integer completionTokens,
            @JsonProperty("total_tokens")
            Integer totalTokens
    ) {}
}