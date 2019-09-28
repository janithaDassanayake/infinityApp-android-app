package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.infinityapp.R;
import com.example.infinityapp.UsersDatabaseAdapter;

public class DisplayActivity extends AppCompatActivity {

    /*
    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;*/
    Cursor res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_display);

/*
        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

*/

        UsersDatabaseAdapter myDb= new UsersDatabaseAdapter(this);

        res = myDb.getAllPerson();


    }


    public void ReadNext(View view){


        TextView T0 = (TextView)findViewById(R.id.txtID);
        TextView T1 = (TextView)findViewById(R.id.Txtusername);
        TextView T2 = (TextView)findViewById(R.id.TextPhone);
        TextView T3 = (TextView)findViewById(R.id.TextEmail);


        if(res.moveToNext()){

            T0.setText(res.getString(0));
            T1.setText(res.getString(1));
            T2.setText(res.getString(2));
            T3.setText(res.getString(3));


        }

    }

    public void ReadBack(View view){


        TextView T0 = (TextView)findViewById(R.id.txtID);
        TextView T1 = (TextView)findViewById(R.id.Txtusername);
        TextView T2 = (TextView)findViewById(R.id.TextPhone);
        TextView T3 = (TextView)findViewById(R.id.TextEmail);


        if(res.moveToPrevious()){

            T0.setText(res.getString(0));
            T1.setText(res.getString(1));
            T2.setText(res.getString(2));
            T3.setText(res.getString(3));

        }

    }

}
