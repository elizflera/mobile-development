package com.example.myapplication.roomdatabase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.myapplication.models.Competition;

import java.util.List;

@Dao
public interface DaoCompetition {
    @Insert
    void insertCompetition(Competition competition);
    @Delete
    void deleteCompetition(Competition competition);
    @Query("DELETE FROM competition_table")
    void deleteAllCompetitions();
    @Transaction
    @Query("SELECT * FROM competition_table")
    LiveData<List<Competition>> getAllCompetitions();
}
