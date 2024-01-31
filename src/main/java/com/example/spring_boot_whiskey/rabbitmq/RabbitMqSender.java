package com.example.spring_boot_whiskey.rabbitmq;

import com.example.spring_boot_whiskey.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMqSender {

    private final RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue("myQueue");
    }

    public void send(UserDto userDto) {
        rabbitTemplate.convertAndSend("myQueue", userDto);
        System.out.println("Sent '" + userDto + "' successfully !!!");
    }
}


// docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management
