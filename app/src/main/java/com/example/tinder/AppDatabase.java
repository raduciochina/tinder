package com.example.tinder;

import android.content.Context;

import androidx.room.Room;

public class AppDatabase {

    private static AppDatabase appDatabase;
    private DatabaseUser databaseUser;

    private AppDatabase(Context context) {
        databaseUser = Room.databaseBuilder(context, DatabaseUser.class, "user-database").build();
    }

    public static AppDatabase getInstance(Context context) {
        if(appDatabase == null) {
            appDatabase = new AppDatabase(context);
        }
        return appDatabase;
    }

    public DatabaseUser getDatabaseUser() {
        return databaseUser;
    }

}
