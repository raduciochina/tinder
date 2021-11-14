package com.example.tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btnAbonamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbonamente = findViewById(R.id.btn_Abonament);

        btnAbonamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AbonamentActivity.class);
                startActivity(i);
            }
        });

    }

    public void DislikeBtn(View view) {
    }

    public void LikeBtn(View view) {
    }
}