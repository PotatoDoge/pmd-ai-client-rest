package com.pmdaiclientrest.infrastructure.adapter.in.kafka.dto;

import lombok.Data;

/**
 * DTO for Kafka deserialization
 *
 * DTOs:
 * - Are framework-specific (can use Lombok, Jackson annotations)
 * - Are mutable (setters allowed)
 * - Are used only at adapter boundaries
 * - Are NEVER passed to domain layer
 */
@Data
public class ProposalAiRequest {
    private String prompt;
}
