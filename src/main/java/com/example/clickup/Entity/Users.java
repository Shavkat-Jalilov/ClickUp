package com.example.clickup.Entity;

import com.example.clickup.Entity.Enums.SystemRole;
import com.example.clickup.Entity.Template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users extends AbsUUIDEntity implements UserDetails {

    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String color;

    @Column
    private String initial_letter;

    @OneToOne
    private Attachment attachment;

    @Enumerated(EnumType.STRING)
    private SystemRole systemRole;

    private String emailCode;

    private boolean enabled;
    private boolean accountnonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;

    public Users(String fullName, String email, String password, String color, String initial_letter, Attachment attachment, SystemRole systemRole, boolean enabled) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.color = color;
        this.initial_letter = initial_letter;
        this.attachment = attachment;
        this.systemRole = systemRole;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountnonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
