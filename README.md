# AI Provider Gateway – Spring Boot API

This project is a **Spring Boot 4** REST API written in **Java 25** that acts as a generic gateway for interacting with **AI providers**.

The API is intentionally designed to be **provider-agnostic**, allowing it to integrate with different AI runtimes and platforms (local or cloud-based) through a unified interface.  
**Ollama** is currently used as the initial provider for local Large Language Model (LLM) execution, but it is not a hard dependency of the core application.

---

## 🎯 Project Goals

- Provide a unified REST API for AI text generation
- Avoid tight coupling to any specific AI provider
- Support local and remote AI runtimes
- Enable future expansion to other providers without breaking API contracts

---

## 🧱 Tech Stack

- **Java:** 25
- **Spring Boot:** 4.x
- **Build Tool:** Maven or Gradle
- **HTTP Client:** Spring WebClient
- **Initial AI Provider:** Ollama

---

## 🧠 Provider-Agnostic Design

This project follows a clean separation of concerns:

- The **core application** defines *what* the system does (AI text generation)
- **Providers** define *how* text is generated
- Each AI provider is implemented as a replaceable integration layer

This allows the API to support multiple providers such as:
- Ollama (local models)
- OpenAI
- Azure OpenAI
- Anthropic
- Any future AI platform

Switching providers does not require changes to controllers or public API endpoints.