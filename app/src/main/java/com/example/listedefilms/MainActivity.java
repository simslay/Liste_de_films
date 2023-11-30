package com.example.listedefilms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CallBackInterface {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        addFilmFragment();
    }

    @Override
    public void onActionPerformed(Bundle bundle) {
        int actionPerformed = bundle.getInt(CallBackInterface.ACTION_KEY);

        switch (actionPerformed) {
            case CallBackInterface.ACTION_VALUE_FILM_SELECTED: addFilmDescriptionFragment(bundle);
        }
    }

    private void addFilmFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();

        FilmFragment filmFragment = new FilmFragment();

        filmFragment.setCallBackInterface(this);

        fragmentTransaction.add(R.id.fragmentContainer, filmFragment);

        fragmentTransaction.commit();
    }

    private void addFilmDescriptionFragment(Bundle bundle) {
        fragmentTransaction = fragmentManager.beginTransaction();

        FilmDescriptionFragment filmDescriptionFragment = new FilmDescriptionFragment();

        filmDescriptionFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragmentContainer, filmDescriptionFragment);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}