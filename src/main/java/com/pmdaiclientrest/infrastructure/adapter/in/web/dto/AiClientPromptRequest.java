package com.pmdaiclientrest.infrastructure.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Client request containing the prompt to be processed by the AI")
public record AiClientPromptRequest(
        @Schema(
                description = "Prompt text sent to the AI provider",
                example = "Explain hexagonal architecture in simple terms",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank
        String request
) {}

