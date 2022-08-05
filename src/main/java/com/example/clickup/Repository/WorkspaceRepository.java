package com.example.clickup.Repository;

import com.example.clickup.Entity.Users;
import com.example.clickup.Entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
    Optional<Workspace> findById(UUID id);
    boolean existsByOwnerIdAndName(UUID ownerId, String name);
}
