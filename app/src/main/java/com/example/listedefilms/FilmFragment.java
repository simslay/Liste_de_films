package com.example.listedefilms;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmFragment extends Fragment {
    private View rootView;
    private ListView lvFilm;
    private ArrayAdapter<String> filmNamesAdapter;
    private Context context;
    private String[] films;
    private CallBackInterface callBackInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_film, container, false);

        initUI();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name) + " -> choisir un film");
    }

    public void setCallBackInterface(CallBackInterface callBackInterface) {
        this.callBackInterface = callBackInterface;
    }

    private void initUI() {
        context = getContext();
        films = getResources().getStringArray(R.array.film);
        lvFilm = (ListView) rootView.findViewById(R.id.lv_film);
        filmNamesAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, films);
        lvFilm.setAdapter(filmNamesAdapter);

        lvFilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (callBackInterface != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(CallBackInterface.ACTION_KEY, CallBackInterface.ACTION_VALUE_FILM_SELECTED);
                    bundle.putString(CallBackInterface.KEY_SELECTED_FILM, films[i]);
                    callBackInterface.onActionPerformed(bundle);
                }
            }
        });
    }
}