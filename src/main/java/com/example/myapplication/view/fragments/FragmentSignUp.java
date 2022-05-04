package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.FragmentChanger;
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

        TextView forget_password = root.findViewById(R.id.forget_password);
        forget_password.setOnClickListener(view -> {
            FragmentChanger.replaceFragment(
                    requireActivity().getSupportFragmentManager(),
                    R.id.container,
                    new FragmentForgetPassword()
            );
        });



        Button buttonRegistration = root.findViewById(R.id.registration);
        buttonRegistration.setOnClickListener(view -> {
            FragmentChanger.replaceFragment(
                    requireActivity().getSupportFragmentManager(),
                    R.id.container,
                    new FragmentSignIn()
            );
        });
        EditText email = root.findViewById(R.id.email);
        EditText password = root.findViewById(R.id.password);

        Button buttonEnter = root.findViewById(R.id.button_enter);
        buttonEnter.setOnClickListener(view -> {

            String emailText = String.valueOf(email.getText());
            String passwordText = String.valueOf(password.getText());

            if (emailText.equals("")) {
                Toast.makeText(getContext(), "Empty email!", Toast.LENGTH_LONG).show();
            } else if (passwordText.equals("")) {
                Toast.makeText(getContext(), "Empty password!", Toast.LENGTH_LONG).show();
            } else {
                FragmentChanger.replaceFragment(
                        requireActivity().getSupportFragmentManager(),
                        R.id.container,
                        new FragmentNavigation());
            }
        });


        return root;
    }
}
