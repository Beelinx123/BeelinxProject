package com.beelinx.Controller;

import com.beelinx.Model.UserEntity;
import com.beelinx.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.List;
import java.util.Map;

public interface UserController {

    ResponseEntity<UserDto> signup(@RequestBody UserEntity user,
                                   @RequestHeader Map<String, String> headers);

    ResponseEntity<List<UserDto>> getUser(@RequestHeader Map<String, String> headers);
}