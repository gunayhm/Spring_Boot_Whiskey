package com.example.spring_boot_whiskey.rabbitmq;

import com.example.spring_boot_whiskey.dto.UserDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqReceiver {

    @RabbitListener(queues = "myQueue")
    public void receive(UserDto userDto){
        System.out.println("Received '"+userDto+"'successfully !!!!");
    }

}
