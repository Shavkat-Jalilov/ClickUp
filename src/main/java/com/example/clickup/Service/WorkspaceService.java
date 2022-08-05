package com.example.clickup.Service;

import com.example.clickup.DTO.ApiResponse;
import com.example.clickup.DTO.WorkspaceDTO;
import com.example.clickup.Entity.Users;

public interface WorkspaceService {
    ApiResponse addWorkspace(WorkspaceDTO workspaceDTO, Users user);

    ApiResponse editWorkspace(WorkspaceDTO workspaceDTO);

    ApiResponse deleteWorkspace(Long id);
}
