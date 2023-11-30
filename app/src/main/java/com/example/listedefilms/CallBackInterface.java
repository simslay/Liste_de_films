package com.example.listedefilms;

import android.os.Bundle;

public interface CallBackInterface {
//    String KEY_SELECTED_FILM = "KEY_SELECTED_FILM";
//
//    void onFilmSelected(String film);

    String ACTION_KEY = "action_key";
    int ACTION_VALUE_FILM_SELECTED = 1;
    String KEY_SELECTED_FILM = "KEY_SELECTED_FILM";

    void onActionPerformed(Bundle bundle);
}
