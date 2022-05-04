package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.FragmentChanger;
import com.example.myapplication.R;
import com.example.myapplication.viewmodels.ViewModelForgetPassword;
import com.example.myapplication.viewmodels.ViewModelNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentNavigation extends Fragment {
    private Fragment home;
    private Fragment user;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        home = new FragmentListRecycler();
        user = new FragmentMyProfile();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.navigation, container, false);
        ViewModelNavigation viewModelNavigation = new ViewModelProvider(this)
                .get(ViewModelNavigation.class);

        BottomNavigationView bottomNavigationView = root.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            switch (itemId){
                case R.id.ic_home:
                    FragmentChanger.replaceFragment(
                            getChildFragmentManager(),
                            R.id.container_with_navigation,
                            home
                    );
                    break;
                case R.id.ic_user:
                    FragmentChanger.replaceFragment(
                            getChildFragmentManager(),
                            R.id.container_with_navigation,
                            user
                    );
                    break;
            }
            return true;

        });


        return root;
    }
}
