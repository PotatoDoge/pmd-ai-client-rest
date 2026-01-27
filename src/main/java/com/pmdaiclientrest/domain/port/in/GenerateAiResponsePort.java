package com.pmdaiclientrest.domain.port.in;

/**
 * Domain entry port representing the capability
 * of generating an AI response from a prompt.
 */
public interface GenerateAiResponsePort {
    String generate(String prompt);
}