package com.example.myapplication;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.models.Competition;
import com.example.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    private final API api;

    @Inject
    public Repository(Application application) {

        api = new NetworkMock();
    }

    public void insertUser(User user){
        api.insertUser(user, new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        });

    }
    public LiveData<List<Competition>> getAllCompetitions() {
        MutableLiveData<List<Competition>> mutableLiveData = new MutableLiveData<>();
        api.getAllCompetitions(new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                List<Competition> competitions = (List<Competition>) message.obj;
                mutableLiveData.postValue(competitions);
            }
        });
        return mutableLiveData;
    }
}


