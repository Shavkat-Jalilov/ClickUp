package com.example.clickup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkspaceDTO {
    private UUID xodimId;
    private String name;
    private String color;
    private Long ownerId;
    private String initialLetter;
    private UUID avatarId;
}
