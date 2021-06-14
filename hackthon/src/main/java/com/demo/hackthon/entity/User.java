package com.demo.hackthon.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.List;

import static com.demo.hackthon.utils.Constants.*;
import static com.demo.hackthon.utils.Constants.DES_LENGTH_512;

@Entity
@Table
public class User{
    private static final String USER_KEY = "UserKey";
    private static final String USER_NAME = "UserName";
    private static final String USER_PASS = "UserPass";
    @Id
    @GeneratedValue(generator = IDGEN_UUID_GENERATOR)
    @GenericGenerator(name = IDGEN_UUID_GENERATOR, strategy = IDGEN_STRATEGY)
    @Column(name = USER_KEY, length = KEY_LENGTH_40, updatable = false)
    private String userKey;

    @Column(name = USER_NAME, length = NAME_LENGTH_40)
    private String userName;
    @Column(name = USER_PASS)
    private String userPass;

    public User() {
    }

    public User(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


}
