package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Competition;
import com.example.myapplication.view.fragments.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

public class AdapterCompetition extends RecyclerView.Adapter<AdapterCompetition.CompetitionView> {

    private List<Competition> competitionsList;

    private Fragment fragment;

    public AdapterCompetition(Fragment fragment){
        this.competitionsList = new ArrayList<>();
        this.fragment = fragment;
    }

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

        holder.getCompetitionFragment().setOnClickListener(view ->{

            FragmentChanger.replaceFragment(
                    fragment.getParentFragmentManager(),
                    R.id.container_with_navigation,
                    new FragmentInfo()
            );
        });

    }

    @Override
    public int getItemCount(){return competitionsList.size();}

    class CompetitionView extends RecyclerView.ViewHolder{
        private final TextView competitionName;
        private final TextView competitionDate;
        private final RelativeLayout competitionFragment;

        public CompetitionView(@NonNull View itemView){
            super(itemView);
            competitionName = itemView.findViewById(R.id.competition_name);
            competitionDate = itemView.findViewById(R.id.competition_date);
            competitionFragment = itemView.findViewById(R.id.competition_fragment);
        }
        public RelativeLayout getCompetitionFragment(){return competitionFragment;}
        public TextView getCompetitionName(){return competitionName;}
        public TextView getDate(){return competitionDate;}
    }


}
