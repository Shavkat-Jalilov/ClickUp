package com.example.clickup.Entity;

import com.example.clickup.Entity.Template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProjectUser extends AbsUUIDEntity {
    @OneToOne
    private Project project;
    @OneToOne
    private Users users;
}
