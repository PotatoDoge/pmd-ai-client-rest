package com.pmdaiclientrest.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

// TODO: Reestructurar el response a los fields necesarios
@Schema(description = "AI-generated response returned to the client")
public record AiClientPromptResponse(

        @Schema(
                description = "Generated text response from the AI provider",
                example = "Hexagonal architecture is a way to design software..."
        )
        String response
) {}
