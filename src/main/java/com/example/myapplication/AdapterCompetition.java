package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Competition;

import java.util.ArrayList;
import java.util.List;

public class AdapterCompetition extends RecyclerView.Adapter<AdapterCompetition.CompetitionView> {

    private List<Competition> competitionsList;

    public AdapterCompetition(){this.competitionsList = new ArrayList<>();}

    public void setCompetitionsList(List<Competition> competitionsList) {this.competitionsList = competitionsList;}

    @NonNull
    @Override
    public CompetitionView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.competition_fragment, parent, false);
        return new CompetitionView(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CompetitionView holder, int position) {
        Competition competition = competitionsList.get(position);
        holder.getCompetitionName().setText(competition.getCompetitionName());
        holder.getDate().setText(competition.getDate());
    }

    @Override
    public int getItemCount(){return competitionsList.size();}

    class CompetitionView extends RecyclerView.ViewHolder{
        private final TextView competitionName;
        private final TextView competitionDate;

        public CompetitionView(@NonNull View itemView){
            super(itemView);
            competitionName = itemView.findViewById(R.id.competition_name);
            competitionDate = itemView.findViewById(R.id.competition_date);
        }
        public TextView getCompetitionName(){return competitionName;}
        public TextView getDate(){return competitionDate;}
    }
}
