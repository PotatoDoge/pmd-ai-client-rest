package com.pmdaiclientrest.infrastructure.adapter.in.kafka;

import com.pmdaiclientrest.application.port.in.GenerateAiResponsePort;
import com.pmdaiclientrest.domain.model.AiResponse;
import com.pmdaiclientrest.infrastructure.adapter.in.kafka.mapper.ProposalAiRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProposalAiConsumer {

    // Inject input port (use case interface)
    private final GenerateAiResponsePort generateAiResponsePort;

    // Inject mapper
    private final ProposalAiRequestMapper mapper;

    @KafkaListener(topics = "proposal-ai-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String prompt) {
        log.info("Received message from proposal-ai-topic: {}", prompt);

        try {
            // 1. Convert DTO to domain model (in this case, String prompt is the domain model)
            String domainPrompt = mapper.toDomain(prompt);

            // 2. Call input port (use case)
            AiResponse response = generateAiResponsePort.generate(domainPrompt);

            log.info("Successfully processed message, response: {}", response.content());
        } catch (Exception e) {
            log.error("Error processing Kafka message", e);
            // Handle error (dead letter queue, retry, etc.)
        }
    }
}
