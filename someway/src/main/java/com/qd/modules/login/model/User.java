package com.qd.modules.login.model;

import javax.persistence.*;

/**
 * Created by chenlongbo on 2017/4/13.
 */
@Entity
@Table(schema="ideado",name="HD_USER")
public class User {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    @Column(name = "ACCOUNT")
    public String account;

    @Column(name="PASSWORD")
    public String password;

    @Column(name="NAME")
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
