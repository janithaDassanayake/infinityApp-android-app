package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button btn, buybtn ,addreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btn=findViewById(R.id.myaccount);
        buybtn=findViewById(R.id.buyTicketbtn);
        addreview=findViewById(R.id.addreview);
    }


    @Override
    protected void onResume() {
        super.onResume();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(HomePage.this,MuserMyaccount.class);

                startActivity(i);
            }
        });

        addreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(HomePage.this,MovieReview.class);

                startActivity(i);
            }
        });

        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,BuyTicket.class);
                startActivity(intent);
            }
        });
    }
}
