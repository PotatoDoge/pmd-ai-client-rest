package com.pmdaiclientrest.application.prompt;

public final class PromptContext {

    private PromptContext() { }

    public static String systemContext() {

        // TODO: define role, language, context, rules, etc

        return """
        You are a senior assistant.
        Answer concisely and clearly.
        """;
    }
}
