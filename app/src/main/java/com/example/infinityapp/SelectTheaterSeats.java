package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectTheaterSeats extends AppCompatActivity {

    Button seatConfirmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theater_seats);

        seatConfirmBtn = findViewById(R.id.seatConfirmBtn);

    }

    @Override
    protected void onResume() {
        super.onResume();

        seatConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectTheaterSeats.this, BookSummery.class);
                startActivity(intent);
            }
        });
    }
}
