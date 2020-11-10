package com.codegym.security.entity;

import javax.persistence.*;

@Entity
@Table(name = "Role_table")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Role_ID")
    private Integer roleId;

    @Column(name = "Role_name")
    private String role_name;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
