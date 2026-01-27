package com.pmdaiclientrest.infrastructure.adapter.in.web.openapi;

import com.pmdaiclientrest.infrastructure.adapter.in.web.dto.AiClientPromptRequest;
import com.pmdaiclientrest.infrastructure.adapter.in.web.dto.AiClientPromptResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AiController {

    @Operation(
            summary = "Generate AI response",
            description = "Generates text based on the provided prompt using a configured AI provider"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "AI response generated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "502", description = "AI provider error"),
            @ApiResponse(responseCode = "500", description = "Unexpected server error")
    })
    ResponseEntity<AiClientPromptResponse> generate(
            @RequestBody AiClientPromptRequest request
    );
}