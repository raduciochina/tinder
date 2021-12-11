package com.example.tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginReg extends AppCompatActivity {

    private Button btnLogin, btnRegister;
    private IUserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);

        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginReg.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginReg.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                userDAO = AppDatabase.getInstance(getApplicationContext()).getDatabaseUser().userDAO();

                List<User> listaUsersDefault = getDefaultUsers();

                userDAO.insertAll(listaUsersDefault.get(0), listaUsersDefault.get(1));
            }
        });

        thread.start();



    }

    public List<User> getDefaultUsers() {
        User user1 = new User("admin1_tinder@yahoo.com","admin1","admin", "0000");
        User user2 = new User("admin2_tinder@yahoo.com","admin2","admin", "1111");

        List<User> listaDefaultUsers = new ArrayList<>();

        listaDefaultUsers.add(user1);
        listaDefaultUsers.add(user2);

        return listaDefaultUsers;

    }
    private void writeToDb() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    private void readFromDb() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("firebase1", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("firebase2", "Failed to read value.", error.toException());
            }
        });
    }


}