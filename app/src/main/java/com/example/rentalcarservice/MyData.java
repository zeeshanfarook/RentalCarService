package com.example.rentalcarservice;

import android.app.Application;

import java.util.ArrayList;

public class MyData extends Application {
    static ArrayList<User> users;
    @Override
    public void onCreate() {
        super.onCreate();
         users = new ArrayList<>();

    }
    public static void addUser(User u)
    {
        users.add(u);

    }
}
