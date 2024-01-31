package com.example.spring_boot_whiskey.controller;

import com.example.spring_boot_whiskey.dto.UserDto;
import com.example.spring_boot_whiskey.exception.MyException;
import com.example.spring_boot_whiskey.service.UserService;
import feign.Request;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void save(@RequestBody @Valid UserDto userDto) throws MyException {
        userService.save(userDto);
    }

    @DeleteMapping(value = "{id}", produces = "application/json")  // http://localhost:8080/users/56
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
