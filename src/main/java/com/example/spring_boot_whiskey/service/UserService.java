package com.example.spring_boot_whiskey.service;

import com.example.spring_boot_whiskey.dto.UserDto;
import com.example.spring_boot_whiskey.entity.UserEntity;
import com.example.spring_boot_whiskey.enumaration.MultiLang;
import com.example.spring_boot_whiskey.exception.MyException;
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

    public List<UserDto> getAll(String value) {
        System.out.println(value);
        return userMapper.toUserDtos(userRepository.findAll());
    }

    public void save(UserDto userDto) {
        userRepository.save(userMapper.toUserEntity(userDto));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void updateById(Long id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();

        userMapper.toUserDto(userEntity);

        userEntity.setName(userDto.getName());

        userRepository.save(userEntity);
    }

    public List<UserDto> findAllOrderByAge(Integer age) {
        List<UserEntity> userEntities =
                userRepository.findUserEntitiesOrderByAgeGreaterThanOrderByAge(age);
        return userMapper.toUserDtos(userEntities);
    }

}
