package com.pmdaiclientrest.infrastructure.adapter.in.web.mapper;

import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.infrastructure.adapter.in.web.dto.AiClientPromptResponse;
import org.springframework.stereotype.Component;

@Component
public class AiResponseMapper {

    public AiClientPromptResponse toDto(AiResponse aiResponse) {
        if (aiResponse == null) {
            throw new IllegalArgumentException("AiResponse cannot be null");
        }

        return new AiClientPromptResponse(aiResponse.content());
    }

}
