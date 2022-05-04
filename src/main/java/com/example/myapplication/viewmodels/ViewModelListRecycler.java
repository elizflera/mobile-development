package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Repository;
import com.example.myapplication.models.Competition;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ViewModelListRecycler extends AndroidViewModel {
    private final Repository repository;

    @Inject
    public ViewModelListRecycler(@NonNull Application application, Repository repository) {
        super(application);
        this.repository=repository;
    }
    public LiveData<List<Competition>> getAllCompetitions(){
        return repository.getAllCompetitions();
    }
}
