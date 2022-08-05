package com.example.clickup.Entity.Template;

import com.example.clickup.Entity.Users;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class AbsMainEntity {
    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp yaratilganvaqt;
    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp yangilanganvaqt;

    @JoinColumn
    @CreatedBy
    @ManyToOne
    private Users kimyaratgan;


    @JoinColumn
    @LastModifiedBy
    @ManyToOne
    private Users kimyangilangan;
}
