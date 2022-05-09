package com.example.myapplication.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.viewmodels.ViewModelForgetPassword;
import com.example.myapplication.viewmodels.ViewModelInfo;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentInfo extends Fragment {

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
        View root = inflater.inflate(R.layout.info, container, false);

        ViewModelInfo viewModelInfo = new ViewModelProvider(this)
                .get(ViewModelInfo.class);


        return root;
    }
}
