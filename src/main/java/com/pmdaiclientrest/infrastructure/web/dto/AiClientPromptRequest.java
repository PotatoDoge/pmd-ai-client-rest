package com.pmdaiclientrest.infrastructure.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Client request containing the prompt to be processed by the AI")
public record AiClientPromptRequest(
        @Schema(
                description = "Prompt text sent to the AI provider",
                example = "Explain hexagonal architecture in simple terms",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String request
) {}

