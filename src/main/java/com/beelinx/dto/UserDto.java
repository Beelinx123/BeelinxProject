package com.beelinx.Dto;

import lombok.Data;
import java.util.Date;

@Data
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
}
