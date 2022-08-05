package com.example.clickup.Repository;

import com.example.clickup.Entity.Enums.Huquqlar;
import com.example.clickup.Entity.Lavozim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LavozimRepository extends JpaRepository<Lavozim, UUID> {
}
