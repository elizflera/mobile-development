package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelNavigation extends AndroidViewModel {

    @Inject
    public ViewModelNavigation(@NonNull Application application) {

        super(application);
    }
}
