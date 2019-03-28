package com.example.unlarroom.interfaces;

import android.app.Activity;

public interface AuthenticationResource {

    //TODO create a AuthenticationResourceFactory
    boolean isLogged();
    void signIn(Activity activity);
    void signOut(Activity activity);
}
