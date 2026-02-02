package com.pmdaiclientrest.domain.port.in;

import com.pmdaiclientrest.domain.model.AiResponse;

/**
 * Domain entry port representing the capability
 * of generating an AI response from a prompt.
 */
public interface GenerateAiResponsePort {
    AiResponse generate(String prompt);
}