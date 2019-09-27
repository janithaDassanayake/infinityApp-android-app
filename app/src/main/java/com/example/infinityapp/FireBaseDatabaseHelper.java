package com.example.infinityapp;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseDatabaseHelper {
    private FirebaseDatabase mDB;
    private DatabaseReference mRefMovies;

    private List<Movie> movies = new ArrayList<>();

    public FireBaseDatabaseHelper(){
        mDB = FirebaseDatabase.getInstance();
        mRefMovies = mDB.getReference("Movies");

    }

    public interface DataStatus{

        void MovieIsLoaded(List<Movie> movies , List<String> keys);
        void MovieIsInserted();
        void MovieIsUpdate();
        void MovieIsDeleted();


    }

    public void readMovies(final DataStatus dataStatus){
        mRefMovies.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                movies.clear();
                List<String> keys = new ArrayList<>();

                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Movie movie = keyNode.getValue(Movie.class);
                    movies.add(movie);
                }
                dataStatus.MovieIsLoaded(movies,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public String addMovie(Movie movie , final DataStatus dataStatus){

        String key = mRefMovies.push().getKey();

        mRefMovies.child(key).setValue(movie).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.MovieIsInserted();
            }
        });
        return key;
    }
    public void updateMovie(String key , Movie movie , final DataStatus dataStatus){
        mRefMovies.child(key).setValue(movie)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.MovieIsUpdate();
                    }
                });
    }

    public void deleteMovie(String key ,final DataStatus dataStatus){
        mRefMovies.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.MovieIsDeleted();
            }
        });
    }

}
