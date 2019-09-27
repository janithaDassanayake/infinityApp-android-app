package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.infinityapp.R;
import com.example.infinityapp.UsersDatabaseAdapter;

public class DisplayActivity extends AppCompatActivity {

    Cursor res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


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
