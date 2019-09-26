package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectTheaterSeats extends AppCompatActivity {

    Button seatConfirmBtn;
    TextView seat1, seat2, seat3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theater_seats);

        seat1 = findViewById(R.id.seatNum1);
        seat2 = findViewById(R.id.seatNum2);
        seat3 = findViewById(R.id.seatNum3);




        final TextView movieTitle = findViewById(R.id.movieTitle_selectSeats);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("movieName").toString();
        movieTitle.setText(data);

        seatConfirmBtn = findViewById(R.id.seatConfirmBtn);

        seatConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (EmptyFieldValidation()) {



                    Intent intent = new Intent(SelectTheaterSeats.this, ReservationSummery.class);
                   // intent.putExtra("seatCount", CountSeats());
                    intent.putExtra("seat1", seat1.getText());
                    intent.putExtra("seat2", seat2.getText());
                    intent.putExtra("seat3", seat3.getText());
                    intent.putExtra("movieNameBySeat", movieTitle.getText());
                    startActivity(intent);

                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


    }



    private Boolean EmptyFieldValidation(){

        Boolean result = false;

        String seat_1 = seat1.getText().toString();
        String seat_2 = seat2.getText().toString();
        String seat_3 = seat3.getText().toString();

        if (seat_1.isEmpty() && seat_2.isEmpty() && seat_3.isEmpty()){
            Toast.makeText(SelectTheaterSeats.this, "Please add alteast 1 seat", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }

        return result;
    }

   /* private int CountSeats(){
        int count;
        String seat_1 = seat1.getText().toString();
        String seat_2 = seat2.getText().toString();
        String seat_3 = seat3.getText().toString();

        if (!seat_1.isEmpty() && !seat_2.isEmpty() && !seat_3.isEmpty()){
            count = 3;
        }else if (!seat_1.isEmpty() && !seat_2.isEmpty()){
            count = 2;
        }else if (!seat_2.isEmpty() && !seat_3.isEmpty()){
            count = 2;
        }else if (!seat_1.isEmpty() && !seat_3.isEmpty()){
            count = 2;
        }else if (!seat_1.isEmpty()){
            count = 1;
        }else if (!seat_2.isEmpty() ){
            count = 1;
        }else
            count = 1;

        return count;
    }*/



}
