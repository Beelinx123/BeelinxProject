package com.beelinx.Services.Imp;

import com.beelinx.Model.UserEntity;
import com.beelinx.Repo.jpa.UserRepository;
import com.beelinx.Repo.spec.UserSpecification;
import com.beelinx.Services.UserService;
import com.beelinx.Dto.UserDto;
import com.beelinx.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSpecification userSpecification;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserEntity user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity updatedUser = userRepository.save(user);
        return userMapper.mapToDto(updatedUser);
    }

    @Override
    public List<UserDto> getAllUser() {

        return userRepository.findAll().stream().map(userMapper::mapToDto).toList();
    }
}
