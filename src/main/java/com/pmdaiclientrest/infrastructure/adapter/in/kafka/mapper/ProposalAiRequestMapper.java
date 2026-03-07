package com.pmdaiclientrest.infrastructure.adapter.in.kafka.mapper;

import com.pmdaiclientrest.infrastructure.adapter.in.kafka.dto.ProposalAiRequest;
import org.springframework.stereotype.Component;

/**
 * Mapper - Converts DTO to Domain Model
 *
 * Mappers:
 * - Live in infrastructure layer
 * - Convert between DTOs and domain models
 * - Are stateless
 * - Handle null checks
 */
@Component
public class ProposalAiRequestMapper {

    public String toDomain(ProposalAiRequest request) {
        if (request == null) {
            return null;
        }
        return request.getPrompt();
    }

    public String toDomain(String rawPrompt) {
        return rawPrompt;
    }
}
