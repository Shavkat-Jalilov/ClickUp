package com.example.clickup.Repository;

import com.example.clickup.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
 boolean existsByEmail(String email);
 Optional<Users> findById(UUID id);
}
