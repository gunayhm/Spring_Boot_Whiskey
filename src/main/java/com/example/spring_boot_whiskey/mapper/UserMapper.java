package com.example.spring_boot_whiskey.mapper;

import com.example.spring_boot_whiskey.dto.UserDto;
import com.example.spring_boot_whiskey.entity.UserEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    List<UserDto> toUserDtos(List<UserEntity> userEntity);

    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);

}
