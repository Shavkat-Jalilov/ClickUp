package com.example.clickup.Entity.Template;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.UUID;
@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public abstract class AbsUUIDEntity extends AbsMainEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
    @Type(type = "org.hibernate.postgres.Type")
    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.UUID")
    private UUID id;

}
