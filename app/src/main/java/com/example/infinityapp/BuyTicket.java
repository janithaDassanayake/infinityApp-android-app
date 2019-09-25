package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuyTicket extends AppCompatActivity {

    Button buyTicketBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

    buyTicketBut = findViewById(R.id.buybtn);

    }

    @Override
    protected void onResume() {
        super.onResume();

        buyTicketBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BuyTicket.this, SelectMovie.class);
                startActivity(intent);
            }
        });
    }
}
