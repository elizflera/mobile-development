package com.example.myapplication.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity(tableName = "users_table")
public class User {
    @PrimaryKey
    @NonNull
    private Long uid;
    @ColumnInfo(name = "surname")
    private String surname;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "e-mail")
    private String email;
    @ColumnInfo(name = "password")
    private String password;

    public User(String surname, String name, String email, String password){
        this.uid=UUID.randomUUID().getMostSignificantBits();
        this.name = surname;
        this.surname = name;
        this.email = email;
        this.password = password;
    }

    @NonNull
    public Long getId() { return uid; }

    public void setId(@NonNull Long id) {this.uid = id; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}
