package com.pmdaiclientrest.infrastructure.web.controller;

import com.pmdaiclientrest.application.usecase.GenerateAiResponseUseCase;
import com.pmdaiclientrest.infrastructure.web.dto.AiClientPromptRequest;
import com.pmdaiclientrest.infrastructure.web.dto.AiClientPromptResponse;
import com.pmdaiclientrest.infrastructure.web.openapi.AiController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiControllerImpl implements AiController {

    private final GenerateAiResponseUseCase generateAiResponseUseCase;

    @Override
    @PostMapping("/generate")
    public ResponseEntity<AiClientPromptResponse> generate(AiClientPromptRequest request) {
        String response = generateAiResponseUseCase.generate(request.request());
        return ResponseEntity.ok(new AiClientPromptResponse(response));
    }
}