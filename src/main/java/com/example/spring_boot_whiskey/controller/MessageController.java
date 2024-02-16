package com.example.spring_boot_whiskey.controller;

import com.example.spring_boot_whiskey.dto.UserDto;
//import com.example.spring_boot_whiskey.rabbitmq.RabbitMqSender;
import feign.Request;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
@RequiredArgsConstructor
public class MessageController {

    //private final RabbitMqSender rabbitMqSender;

    @PostMapping
    public void sendMessage(@RequestBody UserDto userDto){
        //rabbitMqSender.send(userDto);
    }

    @PostMapping("/user")
    public void getUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
    }

}
