package com.example.myapplication.models;

import androidx.annotation.NonNull;
import java.util.UUID;

public class User {

    private Long id;
    private String surname;
    private String name;
    private String email;
    private String password;

    public User(String surname, String name, String email, String password){
        this.id=UUID.randomUUID().getMostSignificantBits();
        this.name = surname;
        this.surname = name;
        this.email = email;
        this.password = password;
    }

    @NonNull
    public Long getId() { return id; }

    public void setId(@NonNull Long id) {this.id = id; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
