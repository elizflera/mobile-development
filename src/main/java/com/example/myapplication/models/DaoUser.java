package com.example.myapplication.models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoUser {
    @Query("Select * from users_table")
    List<User> getUserList();

    @Query("SELECT * FROM users_table WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users_table WHERE `e-mail` LIKE :email LIMIT 1")
    User findByEmail(String email);

    @Insert
    void insertAllUsers(User... users);

    @Delete
    void delete(User user);
}
