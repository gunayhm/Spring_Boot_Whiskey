package com.example.spring_boot_whiskey.service;

import com.example.spring_boot_whiskey.dto.UserDto;
import com.example.spring_boot_whiskey.mapper.UserMapper;
import com.example.spring_boot_whiskey.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAll() {
        return userMapper.toUserDto(userRepository.findAll());
    }

}
