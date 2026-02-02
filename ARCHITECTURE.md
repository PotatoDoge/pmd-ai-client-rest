# Architecture

This project follows a **Hexagonal Architecture** (also known as Ports and Adapters) pattern, organized into three main layers:

- **Application Layer**: Contains use cases and application-specific business logic. Orchestrates the flow of data between the domain and infrastructure layers.
- **Domain Layer**: The core business logic, completely independent of external frameworks. Defines ports (interfaces) for inbound and outbound communication, and contains domain services.
- **Infrastructure Layer**: Contains all external adapters (web controllers, external API clients, configuration). Implements the ports defined in the domain layer.

This separation ensures clean boundaries, testability, and flexibility to change infrastructure components without affecting business logic.

Domain defines behavior and needs.
Infrastructure fulfills the needs.
Application coordinates the flow.

## Folder Structure

```
src/main/java/com/pmdaiclientrest/
├── application/
│   ├── prompt/
│   └── usecase/
├── domain/
│   ├── port/
│   │   ├── in/
│   │   └── out/
│   └── service/
├── infrastructure/
│   ├── adapter/
│   │   ├── in/
│   │   │   └── web/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       └── openapi/
│   │   └── out/
│   │       └── ai/
│   │           └── dto/
│   └── config/
└── PmdAiClientRestApplication.java
```

## Generate Folder Structure Command

Use this command when setting up a new project with the same architectural structure. Run it from your base package directory (e.g., `src/main/java/com/yourproject/`):

```bash
mkdir -p {application/{prompt,usecase},domain/{port/{in,out},service},infrastructure/{adapter/{in/web/{controller,HttpResponse,openapi},out/ai/HttpResponse},config}}
```
