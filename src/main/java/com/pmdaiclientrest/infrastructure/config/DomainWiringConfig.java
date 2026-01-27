package com.pmdaiclientrest.infrastructure.config;

import com.pmdaiclientrest.domain.port.in.GenerateAiResponsePort;
import com.pmdaiclientrest.domain.port.out.AiClientPort;
import com.pmdaiclientrest.domain.service.GenerateAiResponseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainWiringConfig {

    @Bean
    GenerateAiResponsePort generateAiResponsePort(AiClientPort aiClientPort) {
        return new GenerateAiResponseService(aiClientPort);
    }

}
