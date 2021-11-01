package com.example.tinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private final int activityRequestCode = 100;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);


        Bundle wrapper = getIntent().getExtras();
        if(wrapper!=null){
            User user = (User) wrapper.getSerializable("loginUser");
            editTextEmail = findViewById(R.id.email);
            editTextPassword = findViewById(R.id.password);
            editTextPassword.setText(user.getPassword());
            editTextEmail.setText(user.getEmail());
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }


}