package io.github.alinebuchino.msavaliadorcredito.application.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emissao-cartoes}")
    private String emissaoCartoesFila;

    private Queue queueEmissaoCartoes(){

        return new Queue(emissaoCartoesFila, true);
    }
}
