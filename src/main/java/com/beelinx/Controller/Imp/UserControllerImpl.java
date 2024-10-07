package com.beelinx.Controller.Imp;

import com.beelinx.Controller.UserController;
import com.beelinx.Model.UserEntity;
import com.beelinx.Repo.jpa.UserRepository;
import com.beelinx.Services.Imp.UserServiceImpl;
import com.beelinx.Dto.UserDto;
import com.beelinx.Mapper.UserMapper;
import com.beelinx.Utility.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> signup(@RequestBody UserEntity user, @RequestHeader Map<String, String> headers) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<UserDto>> getUser(@RequestHeader Map<String, String> headers) {

        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

}
