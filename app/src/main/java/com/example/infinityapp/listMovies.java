package com.example.infinityapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infinityapp.FireBaseDatabaseHelper;
import com.example.infinityapp.R;
import com.example.infinityapp.RecyclerViewMovieConfigTharik;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class listMovies extends Fragment {

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_list_movies, container, false);
        //return inflater.inflate(R.layout.fragment_list_movies, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_movies_id);

        new FireBaseDatabaseHelper().readMovies(new FireBaseDatabaseHelper.DataStatus() {
            @Override
            public void MovieIsLoaded(List<Movie> movies, List<String> keys) {
                view.findViewById(R.id.progressBar_listmovies).setVisibility(View.GONE);
                new RecyclerViewMovieConfigTharik().setConfig(recyclerView , getContext(),movies,keys );
            }

            @Override
            public void MovieIsInserted() {

            }

            @Override
            public void MovieIsUpdate() {

            }

            @Override
            public void MovieIsDeleted() {

            }
        });

        return view;
    }


}
