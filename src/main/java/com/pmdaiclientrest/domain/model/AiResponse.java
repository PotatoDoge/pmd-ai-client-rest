package com.pmdaiclientrest.domain.model;

public record AiResponse(
        String content,
        Integer totalTokens,
        String model
) {}
