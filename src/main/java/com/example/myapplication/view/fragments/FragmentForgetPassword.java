package com.example.myapplication.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import com.example.myapplication.viewmodels.ViewModelForgetPassword;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentForgetPassword extends Fragment {
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
        View root = inflater.inflate(R.layout.change_password, container, false);

        ViewModelForgetPassword viewModelForgetPassword = new ViewModelProvider(this)
                .get(ViewModelForgetPassword.class);

        EditText email = root.findViewById(R.id.change_password_email);

        Button buttonResetPassword = root.findViewById(R.id.reset_password);
        buttonResetPassword.setOnClickListener(view -> {

            String emailText = String.valueOf(email.getText());

            if (emailText.isEmpty()) {
                Toast.makeText(getContext(), "Empty email!", Toast.LENGTH_LONG).show();
            } else if(!checkEmail(emailText)){
                Toast.makeText(getContext(), "Incorrect email!", Toast.LENGTH_LONG).show();
            }
            else{
                FragmentChanger.replaceFragment(
                        requireActivity().getSupportFragmentManager(),
                        R.id.container,
                        new FragmentSignIn()
                );
            }
        });

        Button buttonRegistration = root.findViewById(R.id.button_change_password_registration);
        buttonRegistration.setOnClickListener(view -> {
            FragmentChanger.replaceFragment(
                    requireActivity().getSupportFragmentManager(),
                    R.id.container,
                    new FragmentSignUp()
            );
        });

        return root;
    }

    boolean checkEmail(String emailText) {
        Pattern p = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        Matcher m = p.matcher(emailText);
        return m.matches();
    }
}
