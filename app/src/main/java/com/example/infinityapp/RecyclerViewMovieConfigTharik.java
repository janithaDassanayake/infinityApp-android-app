package com.example.infinityapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class RecyclerViewMovieConfigTharik extends AppCompatActivity {
    private Context context;

    private MovieAdapter movieAdapter;

    public void setConfig(RecyclerView recyclerView, Context context ,List<Movie> movies , List<String> keys ){
        this.context = context;
        movieAdapter = new MovieAdapter(movies , keys);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(movieAdapter);
    }

    class MovieItemView extends RecyclerView.ViewHolder{
        private TextView mId;
        private TextView mName;
      //  private TextView mCategory;
        private TextView mRunningTime;
        private TextView mProduction;
        private TextView mType;
        private TextView mLanguage;

        private String key;

        public MovieItemView(ViewGroup parent){
            super(LayoutInflater.from(context).inflate(R.layout.movie_list_each_movie_display,parent , false));

            mId = (TextView) itemView.findViewById(R.id.textView_mId_tharik);
            mName = (TextView) itemView.findViewById(R.id.textView_m_name_tharik);
            mLanguage = (TextView) itemView.findViewById(R.id.textView_m_language_tharik);
            mRunningTime = (TextView) itemView.findViewById(R.id.textView_m_runningTime_tharik);
            mProduction = (TextView) itemView.findViewById(R.id.textView_m_production_tharik);
            mType = (TextView) itemView.findViewById(R.id.textView_m_type_tharik);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    Intent intent = new Intent(context,Edit_movie_activity.class);
                    intent.putExtra("key",key);

                    intent.putExtra("mId",mId.getText().toString().trim());
                    intent.putExtra("mName",mName.getText().toString().trim());

                    intent.putExtra("mLanguage",mLanguage.getText().toString().trim());
                    intent.putExtra("mRunningTime",mRunningTime.getText().toString().trim());
                    intent.putExtra("mProduction",mProduction.getText().toString().trim());
                    intent.putExtra("mType",mType.getText().toString().trim());


                    context.startActivity(intent);

                }
            });

        }
        public void bind(Movie movie , String key){
            mId.setText(movie.getmId());
            mName.setText(movie.getmName());
            mLanguage.setText(movie.getmLanguage());
            mRunningTime.setText(movie.getmRunningTime());
            mProduction.setText(movie.getmProduction());
            mType.setText(movie.getmType());
            //mCategory.setText(movie.getmCategory());

            this.key = key;

        }

    }

    class MovieAdapter extends RecyclerView.Adapter<MovieItemView>{
        private List<Movie> movies;
        private List<String> keys;

        public MovieAdapter(List<Movie> movies, List<String> keys) {
            this.movies = movies;
            this.keys = keys;
        }

        @NonNull
        @Override
        public MovieItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MovieItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MovieItemView holder, int position) {
                holder.bind(movies.get(position),keys.get(position));
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }
    }
}
