package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class mforgotpassword2 extends AppCompatActivity {

    String v1;

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mforgotpassword2);

        t1=findViewById(R.id.disemail);


        Intent i=getIntent();

        v1=i.getStringExtra("msg1");

        t1.setText(v1);
    }


}
