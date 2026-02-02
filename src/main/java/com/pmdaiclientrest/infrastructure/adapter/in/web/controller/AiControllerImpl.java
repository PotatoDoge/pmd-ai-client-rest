package com.pmdaiclientrest.infrastructure.adapter.in.web.controller;

import com.pmdaiclientrest.application.usecase.GenerateAiResponseUseCase;
import com.pmdaiclientrest.infrastructure.adapter.in.web.dto.AiClientPromptRequest;
import com.pmdaiclientrest.infrastructure.adapter.in.web.dto.AiClientPromptResponse;
import com.pmdaiclientrest.infrastructure.adapter.in.web.mapper.AiResponseMapper;
import com.pmdaiclientrest.infrastructure.adapter.in.web.openapi.AiController;
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
    private final AiResponseMapper mapper;

    @Override
    @PostMapping("/generate")
    public ResponseEntity<AiClientPromptResponse> generate(AiClientPromptRequest request) {
        AiClientPromptResponse response = mapper.toDto(generateAiResponseUseCase.generate(request.request()));
        return ResponseEntity.ok(response);
    }
}