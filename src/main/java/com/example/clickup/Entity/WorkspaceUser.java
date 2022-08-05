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
public class WorkspaceUser extends AbsUUIDEntity {
    @OneToOne
    private Workspace workspace;
    @OneToOne
    private Users users;
    @OneToOne
    private WorkspaceRole workspaceRole;
    @Column
    private Timestamp dateInvited;
    @Column
    private Timestamp dateJoined;



}
