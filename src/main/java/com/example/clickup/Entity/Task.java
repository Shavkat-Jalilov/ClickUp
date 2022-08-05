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
public class Task extends AbsUUIDEntity {
    @Column
    private String name;
    @Column
    private String description;
    @OneToOne
    private Status status;
    @OneToOne
    private Category category;
    @OneToOne
    private Priority priority;
    @Column
    private String parentTaskid;
    @Column
    private Timestamp startedDate;
    @Column
    private String StarttimeHas;
    @Column
    private Timestamp dueDate;
    @Column
    private Timestamp dueTimehas;
    @Column
    private Long estimateTime;
    @Column
    private Timestamp activedDate;


}
