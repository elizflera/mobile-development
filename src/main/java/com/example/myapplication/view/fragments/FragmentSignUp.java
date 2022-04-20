package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.viewmodels.ViewModelSignUp;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentSignUp extends Fragment {
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
        View root = inflater.inflate(R.layout.sign_up, container, false);

        ViewModelSignUp viewModelSignUp = new ViewModelProvider(this)
                .get(ViewModelSignUp.class);

        EditText email = root.findViewById(R.id.email);
        EditText password = root.findViewById(R.id.password);
        Button buttonRegistration = root.findViewById(R.id.registration);
        buttonRegistration.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentSignIn());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });


        return root;
    }
}
