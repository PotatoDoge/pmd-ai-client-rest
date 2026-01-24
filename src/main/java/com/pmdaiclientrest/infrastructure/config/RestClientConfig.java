package com.pmdaiclientrest.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Configuration class responsible for building and wiring
 * the HTTP client infrastructure used to communicate with
 * external AI providers.
 *
 * <p>
 * This configuration follows a layered approach:
 * <ul>
 *     <li>JDK {@link java.net.http.HttpClient} handles low-level HTTP transport</li>
 *     <li>{@link org.springframework.http.client.JdkClientHttpRequestFactory}
 *         adapts the transport for Spring</li>
 *     <li>{@link org.springframework.web.client.RestClient} provides a high-level,
 *         application-friendly HTTP API</li>
 * </ul>
 *
 * <p>
 * All beans defined here belong strictly to the infrastructure layer
 * and must not leak into domain or application layers.
 */
@Configuration
public class RestClientConfig {

    @Bean
    HttpClient aiHttpClient() {
        return HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
    }

    @Bean
    RestClient.Builder restClientBuilder(HttpClient aiHttpClient) {
        return RestClient.builder()
                .requestFactory(new JdkClientHttpRequestFactory(aiHttpClient));
    }

    @Bean
    RestClient aiRestClient(RestClient.Builder restClientBuilder) {
        return restClientBuilder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}