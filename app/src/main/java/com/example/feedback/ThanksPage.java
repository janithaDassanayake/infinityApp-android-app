package com.example.feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThanksPage extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_page);

        b1= findViewById(R.id.edit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bck_to_Main();
            }
        });
    }

    public  void bck_to_Main(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
