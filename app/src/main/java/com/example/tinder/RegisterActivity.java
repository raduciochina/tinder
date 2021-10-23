package com.example.tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText editTextNume;
    private EditText editTextParola;
    private EditText editTextEmail;
    private EditText editTextTelefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.register);
        editTextEmail = findViewById(R.id.email);
        editTextNume = findViewById(R.id.name);
        editTextParola = findViewById(R.id.password);
        editTextTelefon = findViewById(R.id.phone);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                User user = new User();
                user.setName(editTextNume.getText().toString());
                user.setEmail(editTextEmail.getText().toString());
                user.setPassword(editTextParola.getText().toString());
                user.setPhone(editTextTelefon.getText().toString());

                User loginUser = new User(editTextEmail.getText().toString(), editTextParola.getText().toString());
                Bundle wrapper = new Bundle();

                wrapper.putSerializable("loginUser", loginUser);

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtras(wrapper);
                startActivity(intent);

                }
                
            }
        });
    }

    boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    private boolean isValid(){
        if(editTextNume.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this, "Please enter your name!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editTextTelefon.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this, "Please enter your phone number!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!(isEmailValid(editTextEmail.getText().toString()))){
            Toast.makeText(RegisterActivity.this, "Please enter your email!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(editTextParola.getText().toString().length()<8 &&!isValidPassword(editTextParola.getText().toString())){
            Toast.makeText(RegisterActivity.this, "Please enter a more complex password!",Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

}