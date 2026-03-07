package com.pmdaiclientrest.application.config;

import com.pmdaiclientrest.domain.service.GenerateAiResponseDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Domain Wiring Configuration
 *
 * Purpose:
 * - Wire domain services as Spring beans
 * - Keep domain layer framework-agnostic
 * - Domain services have NO Spring annotations
 */
@Configuration
public class DomainWiringConfig {

    @Bean
    public GenerateAiResponseDomainService generateAiResponseDomainService() {
        return new GenerateAiResponseDomainService();
    }
}
