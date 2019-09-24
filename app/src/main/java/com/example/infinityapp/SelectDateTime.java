package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SelectDateTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date_time);

        TextView textView = (TextView)findViewById(R.id.txt_bundle);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();
        textView.setText(data);

    }
}
