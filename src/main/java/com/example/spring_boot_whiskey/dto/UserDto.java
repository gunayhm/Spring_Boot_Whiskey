package com.example.spring_boot_whiskey.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;

@Data
public class UserDto implements Serializable{

    @NotBlank(message = "Name can not be null")
    private String name;

    @NotNull
    private Integer age;

}
