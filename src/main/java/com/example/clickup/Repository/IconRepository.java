package com.example.clickup.Repository;

import com.example.clickup.Entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.plugin.util.UIUtil;

import java.util.UUID;

public interface IconRepository extends JpaRepository<Icon, UUID> {

}
