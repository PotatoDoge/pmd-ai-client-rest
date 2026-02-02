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
│   └── usecase/
├── domain/
│   ├── exception/
│   ├── model/
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
│   │   │       ├── exception/
│   │   │       ├── mapper/
│   │   │       └── openapi/
│   │   └── out/
│   │       └── ai/
│   │           ├── dto/
│   │           ├── mapper/
│   │           ├── openai/
│   │           └── util/
│   └── config/
└── PmdAiClientRestApplication.java
```

## Generate Folder Structure Command

Use this command when setting up a new project with the same architectural structure. Run it from your base package directory (e.g., `src/main/java/com/yourproject/`):

```bash
mkdir -p {application/usecase,domain/{exception,model,port/{in,out},service},infrastructure/{adapter/{in/web/{controller,dto,exception,mapper,openapi},out/ai/{dto,mapper,openai,util}},config}}
```

## Notes

- **Dependency Rule**: Dependencies always point inwards. The Domain layer is the core and has no dependencies on other layers.
- **Ports & Adapters**: 
    - **Inbound Ports**: Interfaces defined in the domain, implemented by application services (use cases).
    - **Outbound Ports**: Interfaces defined in the domain, implemented by infrastructure adapters.
- **Mapping Strategy**: Each layer has its own data models (DTOs in Infrastructure, Domain Models in Domain). Mappers are used in the infrastructure layer to convert between these models, ensuring the domain remains isolated.
- **Validation**:
    - Input validation is handled at the adapter level (e.g., Web DTOs).
    - Business validation is handled within the Domain layer.
- **Error Handling**: A Global Exception Handler in the web adapter translates domain exceptions into appropriate HTTP responses.
