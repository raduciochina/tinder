package com.example.tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AbonamentActivity extends AppCompatActivity {

    private ListView listViewAbonamente;
    private AbonamentAdapter abonamentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listViewAbonamente = findViewById(R.id.listViewAbonamente);
        abonamentAdapter = new AbonamentAdapter(getLista());

        listViewAbonamente.setAdapter(abonamentAdapter);

    }

    private List<Abonament> getLista(){
        ArrayList<Abonament> lista = new ArrayList<>();

        Abonament abonament1 = new Abonament("Basic", 5f, "Abonamentul standard.");
        Abonament abonament2 = new Abonament("Plus", 30f, "Abonamentul intermediar.");
        Abonament abonament3 = new Abonament("Gold", 60f, "Abonamentul premium.");

        lista.add(abonament1);
        lista.add(abonament2);
        lista.add(abonament3);

        return lista;
    }
}