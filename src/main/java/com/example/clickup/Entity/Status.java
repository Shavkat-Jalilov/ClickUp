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
public class Status extends AbsUUIDEntity {
    @Column
    private String name;
    @OneToOne
    private Space space;
    @ManyToOne
    private Project project;
    @OneToOne
    private Category category;
    @Column
    private String color;
    @Column
    private String type;

}
