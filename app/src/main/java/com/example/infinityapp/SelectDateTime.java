package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SelectDateTime extends AppCompatActivity {

    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date_time);

        nextBtn = findViewById(R.id.testbtn);

        TextView textView = (TextView)findViewById(R.id.txt_bundle);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();
        textView.setText(data);

    }

    @Override
    protected void onResume() {
        super.onResume();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectDateTime.this, SelectTheaterSeats.class);
                startActivity(intent);
            }
        });
    }
}
