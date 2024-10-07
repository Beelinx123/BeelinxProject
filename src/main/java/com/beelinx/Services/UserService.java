package com.beelinx.Services;

import com.beelinx.Model.UserEntity;
import com.beelinx.Dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto registerUser(UserEntity user);

    List<UserDto> getAllUser();

}
