package com.example.myapplication;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.models.DaoUser;
import com.example.myapplication.models.User;

@Database(
        entities = {User.class},
        version = 1,
        exportSchema = false
)
public abstract class LocalDataBase extends RoomDatabase {
    private static final String DB_NAME = "users_db";
    protected abstract DaoUser daoUser();

    static LocalDataBase init(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                LocalDataBase.class,
                "Users_database"
        )
                .fallbackToDestructiveMigration()
                .build();
    }

    public void insertUser(User user) {
        new Thread(() -> {
            daoUser().insertUser(user);
        }).start();
    }
}