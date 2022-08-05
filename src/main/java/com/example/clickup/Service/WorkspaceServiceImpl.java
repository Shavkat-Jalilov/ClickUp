package com.example.clickup.Service;


import com.example.clickup.DTO.ApiResponse;
import com.example.clickup.DTO.WorkspaceDTO;
import com.example.clickup.Entity.Users;
import com.example.clickup.Entity.Workspace;
import com.example.clickup.Repository.AttachmentRepository;
import com.example.clickup.Repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class WorkspaceServiceImpl implements WorkspaceService{
    @Autowired
    WorkspaceRepository workspaceRepository;
    @Autowired
    AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse addWorkspace(WorkspaceDTO workspaceDTO, Users user) {
        if (workspaceRepository.existsByOwnerIdAndName(user.getId(), workspaceDTO.getName())) return new ApiResponse("Sizda bunday nomli ishxona mavjud", false);
        Workspace workspace = new Workspace(
                workspaceDTO.getName(),
                workspaceDTO.getColor(),
                user,
                workspaceDTO.getAvatarId() == null ? null : attachmentRepository.findById(workspaceDTO.getAvatarId()).orElseThrow(() -> new ResourceNotFoundException("attachment"))
        );
        workspaceRepository.save(workspace);


        return new ApiResponse("Ishxona saqlandi", true);
    }

    @Override
    public ApiResponse editWorkspace(WorkspaceDTO workspaceDTO) {
        return null;
    }


    @Override
    public ApiResponse deleteWorkspace(Long id) {
        return null;
    }




}
