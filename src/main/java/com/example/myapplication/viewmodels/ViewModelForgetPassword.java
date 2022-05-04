package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.myapplication.Repository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelForgetPassword extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelForgetPassword(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }

}
