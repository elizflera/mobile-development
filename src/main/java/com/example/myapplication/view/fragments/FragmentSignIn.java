package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.FragmentChanger;
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
            FragmentChanger.replaceFragment(
                    requireActivity().getSupportFragmentManager(),
                    R.id.container,
                    new FragmentSignUp()
            );

        });

        CheckBox checkBox = root.findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener((view,isChecked) -> {
            buttonRegistration.setEnabled(isChecked);
        });

        buttonRegistration.setOnClickListener(view -> {
            String surnameText = String.valueOf(surname.getText());
            String nameText = String.valueOf(name.getText());
            String emailText = String.valueOf(email.getText());
            String passwordText = String.valueOf(password.getText());

            if (surnameText.equals("")) {
                Toast.makeText(getContext(), "Empty surname!", Toast.LENGTH_LONG).show();
            } else if (nameText.equals("")) {
                Toast.makeText(getContext(), "Empty name!", Toast.LENGTH_LONG).show();
            } else if (emailText.equals("")) {
                Toast.makeText(getContext(), "Empty email!", Toast.LENGTH_LONG).show();
            } else if (passwordText.equals("")) {
                Toast.makeText(getContext(), "Empty password!", Toast.LENGTH_LONG).show();
            } else {
                FragmentChanger.replaceFragment(
                        requireActivity().getSupportFragmentManager(),
                        R.id.container,
                        new FragmentNavigation()
                );
                viewModelSignIn.insertUser(
                        new User(
                                surname.getText().toString(),
                                name.getText().toString(),
                                email.getText().toString(),
                                password.getText().toString()
                        )
                );
            }
        });

        return root;
    }

}
