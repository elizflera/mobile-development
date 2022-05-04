package com.example.myapplication;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.models.Competition;
import com.example.myapplication.roomdatabase.dao.DaoCompetition;
import com.example.myapplication.roomdatabase.dao.DaoUser;
import com.example.myapplication.models.User;

import java.util.List;

@Database(
        entities = {User.class, Competition.class},
        version = 1,
        exportSchema = false
)

public abstract class LocalDataBase extends RoomDatabase {
    private static final String DB_NAME = "users_db";
    protected abstract DaoUser daoUser();
    protected abstract DaoCompetition daoCompetition();

    static LocalDataBase init(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                LocalDataBase.class,
                "LocalDataBase"
        )
                .fallbackToDestructiveMigration()
                .build();
    }

    public void insertUser(User user) {
        new Thread(() -> {
            daoUser().insertUser(user);
        }).start();
    }
    public void insertCompetition(Competition modelCard) {
        new Thread(() -> {
            daoCompetition().insertCompetition(modelCard);
        }).start();
    }
    public void insertAllCompetitions(List<Competition> list) {
        new Thread(() -> {
            daoCompetition().deleteAllCompetitions();
            for (Competition card: list ) {
                daoCompetition().insertCompetition(card);
            }
        }).start();
    }
    public LiveData<List<Competition>> getAllCompetitions() {
        return daoCompetition().getAllCompetitions();
    }
}
