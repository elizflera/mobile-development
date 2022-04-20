package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.models.User;
import com.example.myapplication.viewmodels.ViewModelSignIn;


import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentSignIn extends Fragment {
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
        View root = inflater.inflate(R.layout.sign_in, container, false);

        ViewModelSignIn viewModelSignIn = new ViewModelProvider(this)
                .get(ViewModelSignIn.class);

        EditText surname = root.findViewById(R.id.surname);
        EditText name = root.findViewById(R.id.name);
        EditText email = root.findViewById(R.id.email);
        EditText password = root.findViewById(R.id.password);
        Button buttonEnter = root.findViewById(R.id.enter);
        Button buttonRegistration = root.findViewById(R.id.button_registration);

        buttonEnter.setOnClickListener(view -> {
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new FragmentSignUp());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        CheckBox checkBox = root.findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener((view,isChecked) -> {
            buttonRegistration.setEnabled(isChecked);
        });

        buttonRegistration.setOnClickListener(view -> {
            viewModelSignIn.insertUser(
                    new User(
                            surname.getText().toString(),
                            name.getText().toString(),
                            email.getText().toString(),
                            password.getText().toString()
                    )
            );
        });

        return root;
    }

}
