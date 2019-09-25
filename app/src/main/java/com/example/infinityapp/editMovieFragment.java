package com.example.infinityapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;




public class editMovieFragment extends Fragment {

    private EditText EmId;
    private EditText EmName;
    private EditText EmRunningTime;
    private EditText EmProduction;
    private EditText EmLanguage;
    private  EditText EmType;

    private Button btnEdit;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_insert_movie, container, false);
        //return inflater.inflate(R.layout.fragment_edit_movie, container, false);

        EmId = (EditText) view.findViewById(R.id.editText_movieID_editMovie);
        EmName = (EditText) view.findViewById(R.id.editText_movieName_editMovie);

        EmRunningTime = (EditText) view.findViewById(R.id.editText_runningTime_editMovies);
        EmProduction = (EditText) view.findViewById(R.id.editText_production_editMovie);
        EmLanguage = (EditText) view.findViewById(R.id.editText_mLanguage_editMovies);
        EmType = (EditText) view.findViewById(R.id.editText_mType_editMovies);

        btnEdit =(Button) view.findViewById(R.id.button_editMovie_editMovie);





        return view;
    }


}
