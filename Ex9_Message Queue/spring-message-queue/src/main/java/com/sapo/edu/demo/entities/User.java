package com.sapo.edu.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
