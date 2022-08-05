package com.example.clickup.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private String fullName;
    private String email;
    private String password;
    private String color;
    private String initialLetter;
    private UUID attachment;
    private Integer role;
}
