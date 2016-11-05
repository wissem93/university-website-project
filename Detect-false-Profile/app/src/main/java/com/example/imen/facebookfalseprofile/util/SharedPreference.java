package com.example.imen.facebookfalseprofile.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import com.example.imen.facebookfalseprofile.entity.User;

public class SharedPreference {

    public static final String PREFS_NAME = "AOP_PREFS";
    public static final String PREFS_KEY = "AOP_PREFS_String";

    public SharedPreference() {
        super();
    }

    public static void save(Context context, User user) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("MyObject", json);
        editor.commit();
    }

    public static User getValue(Context context) {
        SharedPreferences settings;


        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = settings.getString("MyObject", "kkk");
        User obj = gson.fromJson(json,User.class);
        return obj;
    }


}