package com.example.tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent i = getIntent();

        String textDataEmail = i.getExtras().getString("textDataEmail", "");
        String textDataPassword = i.getExtras().getString("textDataPassword", "");

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);

        editTextEmail.setText(textDataEmail);
        editTextPassword.setText(textDataPassword);

    }
}