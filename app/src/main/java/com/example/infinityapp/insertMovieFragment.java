package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.List;


public class insertMovieFragment extends Fragment {



    private EditText EmId;
    private EditText EmName;
    private EditText EmRunningTime;
    private EditText EmProduction;
    private EditText EmLanguage;
    private  EditText EmType;


    private Button btnInsert;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_insert_movie, container, false);
       // return inflater.inflate(R.layout.fragment_insert_movie, container, false);

        EmId = (EditText) view.findViewById(R.id.editText_movieID_InsertMovie);
        EmName = (EditText) view.findViewById(R.id.editText_movieName_InsertMovie);

        EmRunningTime = (EditText) view.findViewById(R.id.editText_runningTime_insertMovies);
        EmProduction = (EditText) view.findViewById(R.id.editText_production_InsertMovie);
        EmLanguage = (EditText) view.findViewById(R.id.editText_language_insertMovies);
        EmType = (EditText) view.findViewById(R.id.editText_movieType_insertMovies);








        btnInsert = (Button)view.findViewById(R.id.button_InsertMovie_InsertMovie);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Movie movie = new Movie();

                movie.setmId(EmId.getText().toString().trim());
                movie.setmName(EmName.getText().toString().trim());
                movie.setmLanguage(EmLanguage.getText().toString().trim());
                movie.setmProduction(EmProduction.getText().toString().trim());
                movie.setmRunningTime(EmRunningTime.getText().toString().trim());
                movie.setmType(EmType.getText().toString().trim());


               String Insertedkey = new FireBaseDatabaseHelper().addMovie(movie, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void MovieIsLoaded(List<Movie> movies, List<String> keys) {

                    }

                    @Override
                    public void MovieIsInserted() {

                        Toast.makeText(getContext(), "Movie Inserted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void MovieIsUpdate() {

                    }

                    @Override
                    public void MovieIsDeleted() {

                    }
                });

                Intent i = new Intent(getActivity(),InsertMovieImage_tharik.class);

                i.putExtra("insertedKey",Insertedkey);
                startActivity(i);
            }
        });


        return view;
    }


}
