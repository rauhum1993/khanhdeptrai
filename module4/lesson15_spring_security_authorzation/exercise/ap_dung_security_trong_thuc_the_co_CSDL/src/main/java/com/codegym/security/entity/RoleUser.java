package com.codegym.security.entity;

import javax.persistence.*;

@Entity
@Table(name = "Authorzation_role_user")
public class RoleUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Role_User_ID", nullable = false)
    private Integer roleUserID;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "Role_ID", nullable = false)
    private Role role;

    public Integer getRoleUserID() {
        return roleUserID;
    }

    public void setRoleUserID(Integer roleUserID) {
        this.roleUserID = roleUserID;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
