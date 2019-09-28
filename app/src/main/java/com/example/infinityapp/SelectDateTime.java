package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectDateTime extends AppCompatActivity {

    Button nextBtn;
    Button date1, date2, date3, date4, date5, date6;
    Button time1, time2, time3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_select_date_time);

        date1 = findViewById(R.id.date1);
        date2 = findViewById(R.id.date2);
        date3 = findViewById(R.id.date3);
        date4 = findViewById(R.id.date4);
        date5 = findViewById(R.id.date5);
        date6 = findViewById(R.id.date6);

        time1= findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);

        nextBtn = findViewById(R.id.testbtn);

        final TextView textView = (TextView)findViewById(R.id.txt_bundle);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();
        textView.setText(data);


        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SelectDateTime.this, "", Toast.LENGTH_SHORT).show();
            }
        });

        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectDateTime.this, SelectTheaterSeats.class);
                intent.putExtra("movieName", textView.getText());
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}
