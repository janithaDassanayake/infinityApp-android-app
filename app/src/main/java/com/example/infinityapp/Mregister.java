package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mregister extends AppCompatActivity {


    TextView reglogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mregister);

        reglogin=findViewById(R.id.rlog);

    }

    @Override
    protected void onResume() {
        super.onResume();

        reglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mregister.this, Admin_logn.class);
                startActivity(intent);
            }
        });

    }

}
