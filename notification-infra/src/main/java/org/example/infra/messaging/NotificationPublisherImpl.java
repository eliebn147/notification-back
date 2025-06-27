package org.example.infra.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.core.messaging.NotificationPublisher;
import org.example.domain.entities.Notification;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;

@Component
public class NotificationPublisherImpl implements NotificationPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final String exchangeName;
    private final String routingKey;

    public NotificationPublisherImpl(RabbitTemplate rabbitTemplate,
                                     ObjectMapper objectMapper,
                                     @Value("${rabbitmq.exchange}") String exchangeName,
                                     @Value("${rabbitmq.routingKey}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public void publish(Notification notification) {
        try {
            String json = objectMapper.writeValueAsString(notification);

            Message message = MessageBuilder.withBody(json.getBytes())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)  // set content-type application/json
                    .build();

            rabbitTemplate.send(exchangeName, routingKey, message);

            System.out.println("Published to RabbitMQ: " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}