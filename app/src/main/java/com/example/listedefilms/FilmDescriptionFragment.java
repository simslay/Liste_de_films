package com.example.listedefilms;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmDescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmDescriptionFragment extends Fragment {
    private View rootView;
    private TextView tvFilmDescription;
    private String filmName;
    private String filmDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_film_description, container, false);

        initUI();

        return rootView;
    }

    private void initUI() {
        tvFilmDescription = (TextView) rootView.findViewById(R.id.tv_film_description);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        filmName = bundle.getString(CallBackInterface.KEY_SELECTED_FILM, "BeetleJuice");
        filmDescription = getString(getStringId(filmName));
    }

    @Override
    public void onResume() {
        super.onResume();
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(filmName);
        tvFilmDescription = rootView.findViewById(R.id.tv_film_description);
        tvFilmDescription.setText(filmDescription);
    }

    private int getStringId(String filmName) {
        if (filmName.equals("BeetleJuice")) {
            return R.string.Beetlejuice;
        } else if (filmName.equals("Chat Noir Chat Blanc")) {
            return R.string.Chat_Noir_Chat_Blanc;
        } else if (filmName.equals("Ghost in the Shell")) {
            return R.string.Ghost_in_the_Shell;
        } else if (filmName.equals("Great Teacher Onizuka")) {
            return R.string.Great_Teacher_Onizuka;
        } else if (filmName.equals("La Cité de la Peur")) {
            return R.string.La_Cité_de_la_peur;
        } else if (filmName.equals("La Montagne Sacrée")) {
            return R.string.La_Montagne_sacrée;
        } else if (filmName.equals("Las Vegas Parano")) {
            return R.string.Las_Vegas_Parano;
        } else {
            return R.string.Beetlejuice;
        }
    }
}