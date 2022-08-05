package com.example.clickup.Entity;

import com.example.clickup.Entity.Enums.Huquqlar;
import com.example.clickup.Entity.Enums.SystemRole;
import com.example.clickup.Entity.Template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SystemRoles extends AbsUUIDEntity {
    @Column(nullable = false)
    private String nomi;

    @Column(columnDefinition = "text")
    private String izoh;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<SystemRole> systemRoleList;
}
