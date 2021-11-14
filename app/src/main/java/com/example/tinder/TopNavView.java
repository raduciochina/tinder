package com.example.tinder;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TopNavView {

    public static void Navigation(Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.icon_profile:
                        Intent i = new Intent(context, SettingsActivity.class);
                        context.startActivity(i);
                        break;

                    case R.id.icon_match:
                        Intent j = new Intent(context, MatchesActivity.class);
                        context.startActivity(j);
                        break;
                }
                return false;
            }
        });


    }

}
