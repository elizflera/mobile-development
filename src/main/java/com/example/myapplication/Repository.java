package com.example.myapplication;
import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private MutableLiveData<String> message;
    private final LocalDataBase dataBase;

    @Inject
    public Repository(Application application) {
        dataBase = LocalDataBase.init(application);
    }

    public void insertUser(User user){
        dataBase.insertUser(user);
    }

}


