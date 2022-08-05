package com.example.clickup.Entity;

import com.example.clickup.Entity.Task;
import com.example.clickup.Entity.Template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class CheckList extends AbsUUIDEntity {
    @Column
    private String name;
    @OneToOne
    private Task task;

}
