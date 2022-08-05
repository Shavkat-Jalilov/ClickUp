package com.example.clickup.Repository;

import com.example.clickup.Entity.Enums.SystemRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SystemRole, Integer> {

}
