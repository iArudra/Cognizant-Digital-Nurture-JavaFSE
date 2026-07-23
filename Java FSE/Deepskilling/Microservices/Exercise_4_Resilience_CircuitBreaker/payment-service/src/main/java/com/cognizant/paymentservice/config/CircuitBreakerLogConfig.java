package com.cognizant.paymentservice.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerLogConfig {

    private static final Logger log = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @PostConstruct
    public void registerListeners() {
        CircuitBreaker paymentBreaker = circuitBreakerRegistry.circuitBreaker("paymentService");
        
        paymentBreaker.getEventPublisher()
                .onStateTransition(event -> log.info("Circuit Breaker State Transition: {}", event.getStateTransition()))
                .onError(event -> log.warn("Circuit Breaker Recorded Error: {}", event.getThrowable().getMessage()))
                .onSuccess(event -> log.info("Circuit Breaker Recorded Success"))
                .onIgnoredError(event -> log.warn("Circuit Breaker Ignored Error: {}", event.getThrowable().getMessage()));
    }
}
