package com.example.spring_boot_whiskey.controller;

import com.example.spring_boot_whiskey.dto.UserDto;
import com.example.spring_boot_whiskey.entity.UserEntity;
import com.example.spring_boot_whiskey.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @ResponseBody + @Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping("getAll") // http://localhost:8080/users/getAll  GET
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public void save(@RequestBody @Valid UserDto userDto){
        userService.save(userDto);
    }

}
