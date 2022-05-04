package com.example.myapplication.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.myapplication.models.User;

import java.util.List;

@Dao
public interface DaoUser {

    @Query("SELECT * FROM users_table")
    List<User> getUserList();

    @Query("SELECT * FROM users_table WHERE id IN (:userIds)")
    List<User> loadAllUsersByIds(int[] userIds);

    @Query("SELECT * FROM users_table WHERE email LIKE :email LIMIT 1")
    User findUserByEmail(String email);

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);
}
