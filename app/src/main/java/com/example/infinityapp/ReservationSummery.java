package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ReservationSummery extends AppCompatActivity {

    TextView seat1, seat2, seat3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summery);

        final TextView textView = findViewById(R.id.movieName);
        seat1 = findViewById(R.id.S1);
        seat2 = findViewById(R.id.S2);
        seat3 = findViewById(R.id.S3);

        Bundle bundle = getIntent().getExtras();
        String data1 = bundle.get("movieNameBySeat").toString();
        String seatData1 = bundle.get("seat1").toString();
        String seatData2 = bundle.get("seat2").toString();
        String seatData3 = bundle.get("seat3").toString();

        textView.setText(data1);
        seat1.setText(seatData1);
        seat2.setText(seatData2);
        seat3.setText(seatData3);
    }
}
