package com.pmdaiclientrest.infrastructure.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "AI-generated response returned to the client")
public record AiClientPromptResponse(

        @Schema(
                description = "Generated text response from the AI provider",
                example = "Hexagonal architecture is a way to design software..."
        )
        String response
) {}
