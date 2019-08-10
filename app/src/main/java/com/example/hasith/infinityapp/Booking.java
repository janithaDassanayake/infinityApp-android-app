package com.example.hasith.infinityapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Booking extends AppCompatActivity {

    Button date1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

    date1 = findViewById(R.id.day1);







    }

    @Override
    protected void onResume() {
        super.onResume();

        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Booking.this, selectTheater.class);
                startActivity(intent);
            }
        });


    }
}
