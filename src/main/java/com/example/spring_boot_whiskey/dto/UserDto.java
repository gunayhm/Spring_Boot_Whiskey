package com.example.spring_boot_whiskey.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto{

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotNull
    private Integer age;

}
