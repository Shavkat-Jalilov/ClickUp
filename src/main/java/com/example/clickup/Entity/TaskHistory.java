package com.example.clickup.Entity;

import com.example.clickup.Entity.Template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskHistory extends AbsUUIDEntity {
    @OneToOne
    private Task task;
    @Column
    private String changeFieldname;
    @Column
    private String before;
    @Column
    private String after;
    @Column
    private String data;
}
