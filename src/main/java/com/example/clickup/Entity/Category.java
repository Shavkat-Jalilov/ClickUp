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
public class Category extends AbsUUIDEntity {
    @Column
    private String name;
    @OneToOne
    private Project project;
    @Column
    private String accesType;
    @Column
    private String archived;
    @Column
    private String color;

}
