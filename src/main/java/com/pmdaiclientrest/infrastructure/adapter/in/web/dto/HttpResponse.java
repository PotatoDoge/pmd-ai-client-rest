package com.pmdaiclientrest.infrastructure.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.Instant;

/**
 * Standard error response structure.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record HttpResponse(
        String message,
        Instant timestamp
) {
}
