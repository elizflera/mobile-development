package com.example.myapplication;

import android.os.Handler;

import androidx.lifecycle.LiveData;

import com.example.myapplication.models.Competition;
import com.example.myapplication.models.User;

import java.util.List;


public interface API {
    void insertUser(User user, Handler handler);
    void insertCompetition(Competition competition, Handler handler);
    void getAllCompetitions(Handler handler);
    void getAllCompetitionsInfo(Handler handler);
}
