package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.List;


public class editMovieFragment extends Fragment {

    private EditText EmId;
    private EditText EmName;
    private EditText EmRunningTime;
    private EditText EmProduction;
    private EditText EmLanguage;
    private  EditText EmType;


    private String ikey = " ";
    private String imId =" ";
    private String imName=" ";
    private String imRunningTime=" ";
    private String imProduction=" ";
    private String imLanguage=" ";
    private String imType=" ";


    private Button btnEdit;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_edit_movie, container, false);
        //return inflater.inflate(R.layout.fragment_edit_movie, container, false);

        if(getArguments() != null){
            ikey= getArguments().getString("key");

            imId = getArguments().getString("mId");
            imName =getArguments().getString("mName");
            imLanguage =getArguments().getString("mLanguage");
            imRunningTime = getArguments().getString("mRunningTime");
            imProduction = getArguments().getString("mProduction");
            imType = getArguments().getString("mType");
        }




        EmId = (EditText) view.findViewById(R.id.editText_movieID_editMovie);
        EmId.setText(imId);
        EmName = (EditText) view.findViewById(R.id.editText_movieName_editMovie);
        EmName.setText(imName);

        EmRunningTime = (EditText) view.findViewById(R.id.editText_runningTime_editMovies);
        EmRunningTime.setText(imRunningTime);
        EmProduction = (EditText) view.findViewById(R.id.editText_production_editMovie);
        EmProduction.setText(imProduction);
        EmLanguage = (EditText) view.findViewById(R.id.editText_mLanguage_editMovies);
        EmLanguage.setText(imLanguage);
        EmType = (EditText) view.findViewById(R.id.editText_mType_editMovies);
        EmType.setText(imType);


        btnEdit =(Button) view.findViewById(R.id.button_editMovie_editMovie);



        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new Movie();

                movie.setmId(EmId.getText().toString().trim());
                movie.setmName(EmName.getText().toString().trim());
                movie.setmLanguage(EmLanguage.getText().toString().trim());
                movie.setmProduction(EmProduction.getText().toString().trim());
                movie.setmRunningTime(EmRunningTime.getText().toString().trim());
                movie.setmType(EmType.getText().toString().trim());

                new FireBaseDatabaseHelper().updateMovie(ikey, movie, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void MovieIsLoaded(List<Movie> movies, List<String> keys) {

                    }

                    @Override
                    public void MovieIsInserted() {

                    }

                    @Override
                    public void MovieIsUpdate() {
                        Toast.makeText(getContext(), "Updated movie", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void MovieIsDeleted() {

                    }
                });
            }
        });
        return view;
    }


}
