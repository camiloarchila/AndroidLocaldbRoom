package com.example.localdatabaseroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if(instance == null){
            AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "localdb").build();
        }
        return instance;
    }
}