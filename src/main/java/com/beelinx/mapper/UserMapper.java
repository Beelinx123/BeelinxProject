package com.beelinx.Mapper;

import com.beelinx.Dto.UserDto;
import com.beelinx.Model.UserEntity;
//import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public UserDto mapToDto(UserEntity source){
        return source == null ? null : this.modelMapper.map(source, UserDto.class);
    }
    public UserEntity mapToEntity(UserDto source){
        return source == null ? null : this.modelMapper.map(source, UserEntity.class);
    }
}
