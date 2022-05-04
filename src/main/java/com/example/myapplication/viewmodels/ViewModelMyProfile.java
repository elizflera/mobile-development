package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myapplication.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelMyProfile extends AndroidViewModel {
    @Inject
    public ViewModelMyProfile(@NonNull Application application) {

        super(application);
    }
}
