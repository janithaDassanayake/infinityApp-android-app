package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity_Tharik extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tharik);

    }

    public void changeView(View view){
        Fragment fragment;

        if(view == findViewById(R.id.Button_home_main)){
            fragment =new profileContentFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
            Toast.makeText(MainActivity_Tharik.this,"Profile Content",Toast.LENGTH_LONG).show();

        }
        if(view == findViewById(R.id.Button_profile_edit_main)){
            fragment =new profileEditFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
            Toast.makeText(MainActivity_Tharik.this,"Edit Profile",Toast.LENGTH_LONG).show();
        }
        if(view == findViewById(R.id.Button_insert_main)){
            fragment =new insertMovieFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
            Toast.makeText(MainActivity_Tharik.this,"Insert Movies",Toast.LENGTH_LONG).show();
        }
        if(view == findViewById(R.id.Button_movieEdit_Main)){
            fragment =new editMovieFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
            Toast.makeText(MainActivity_Tharik.this,"Edit Movie",Toast.LENGTH_LONG).show();
        }
        if(view == findViewById(R.id.Button_delete_main)){
            fragment =new deleteMovieFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
            Toast.makeText(MainActivity_Tharik.this,"Delete Movies",Toast.LENGTH_LONG).show();
        }
        if(view == findViewById(R.id.Button_list_main)){
            fragment =new listMovies();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
            Toast.makeText(MainActivity_Tharik.this,"List Movies",Toast.LENGTH_LONG).show();
        }

    }
}

