package com.pmdaiclientrest.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai.openai")
public record OpenAiProperties(
        String baseUrl,
        String apiKey,
        String model,
        String chatPath
) {}