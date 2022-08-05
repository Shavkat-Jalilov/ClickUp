package com.example.clickup.Entity;

import com.example.clickup.Entity.Template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Space extends AbsUUIDEntity {
    @Column
    private String name;
    @Column
    private String color;
    @OneToOne
    private Workspace workspace;
    @Column
    private String initialLetter;
    @OneToOne
    private Icon icon;
    @OneToOne
    private Attachment avatarId;
    @OneToOne
    private Users ownerId;
    @Column
    private String accessType;
}
