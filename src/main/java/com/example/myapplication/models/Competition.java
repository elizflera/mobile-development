package com.example.myapplication.models;

import androidx.annotation.NonNull;
import java.util.UUID;

public class Competition {

    private Long competitionId;
    private String competitionName;
    private String date;

    public Competition(Long competitionId, String competitionName, String date){
        this.competitionId = competitionId;
        this.competitionName = competitionName;
        this.date = date;
    }

    @NonNull
    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(@NonNull Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
