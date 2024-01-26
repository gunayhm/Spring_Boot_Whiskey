package com.example.spring_boot_whiskey.controller;

import com.example.spring_boot_whiskey.dto.UserDto;
import com.example.spring_boot_whiskey.entity.UserEntity;
import com.example.spring_boot_whiskey.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

    @PutMapping("{id}")
    public void updateById( @RequestBody @Valid UserDto userDto, @PathVariable("id") Long id){
        userService.updateById(id, userDto);
    }

    @GetMapping("/orderByAge/{age}")
    public List<UserDto> findAllOrderByAge(@PathVariable Integer age){
        return userService.findAllOrderByAge(age);
    }

}
