package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AdapterCompetition;
import com.example.myapplication.FragmentChanger;
import com.example.myapplication.R;
import com.example.myapplication.models.Competition;
import com.example.myapplication.viewmodels.ViewModelForgetPassword;
import com.example.myapplication.viewmodels.ViewModelListRecycler;
import com.google.android.material.appbar.AppBarLayout;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentListRecycler extends Fragment {

    private AppCompatActivity appCompatActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState

    ) {
        View root = inflater.inflate(R.layout.list_recycler, container, false);

        ViewModelListRecycler viewModelListRecycler = new ViewModelProvider(this).get(ViewModelListRecycler.class);
        RecyclerView recyclerView = root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        AdapterCompetition adapterCompetition = new AdapterCompetition(this);
        recyclerView.setAdapter(adapterCompetition);

        viewModelListRecycler.getAllCompetitions().observe(getViewLifecycleOwner(), competition -> {
            adapterCompetition.setCompetitionsList(competition);
            adapterCompetition.notifyDataSetChanged();
        });

        return root;
    }
}
