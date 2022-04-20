package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myapplication.Repository;
import com.example.myapplication.models.User;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelSignUp extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelSignUp(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }



}