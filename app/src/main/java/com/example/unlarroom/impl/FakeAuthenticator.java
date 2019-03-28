package com.example.unlarroom.impl;

import android.app.Activity;
import android.content.Intent;

import com.example.unlarroom.MainActivity;
import com.example.unlarroom.activity.Main2Activity;
import com.example.unlarroom.interfaces.AuthenticationResource;

public class FakeAuthenticator implements AuthenticationResource {

    private static boolean isFakeLogged;

    static {
        isFakeLogged = false;
    }

    @Override
    public boolean isLogged() {
        return isFakeLogged;
    }

    @Override
    public void signIn(Activity activity) {
        isFakeLogged = true;
        Intent intent = new Intent(activity, Main2Activity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    public void signOut(Activity activity) {
        isFakeLogged = false;
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

}
