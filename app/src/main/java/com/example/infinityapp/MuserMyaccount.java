package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MuserMyaccount extends AppCompatActivity {

    Button btn;
    Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muser_myaccount);


        btn=findViewById(R.id.edtbtn);
        sign = findViewById(R.id.signout);
    }


    @Override
    protected void onResume() {
        super.onResume();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MuserMyaccount.this,userEditProfile.class);

                startActivity(i);
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MuserMyaccount.this,Admin_logn.class);

                startActivity(i);
            }
        });


    }
}
