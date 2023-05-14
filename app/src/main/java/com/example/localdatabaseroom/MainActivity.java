package com.example.localdatabaseroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase localDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "localdb").allowMainThreadQueries().build();

        User fisrtuser = new User("pepito", "perez");
        User seconduser = new User("maria", "magdalena");

        localDatabase.userDao().insertAll(fisrtuser,seconduser);

        List<User> userlist = localDatabase.userDao().getAll();

        for(User user: userlist){
            Log.d("persons", user.firstName + " " + user.lastName);
        }
    }
}