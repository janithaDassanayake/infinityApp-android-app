package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReservationSummery extends AppCompatActivity {

    TextView seat1, seat2, seat3;
    TextView movieName;
    TextView date, time;
    TextView seatCount, price;
    Button paybtn;
    private FirebaseAuth firebaseAuth;
    String d_movieName, d_date, d_price, d_time, d_seatNumber1, d_seatNumber2, d_seatNumber3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summery);

        firebaseAuth = FirebaseAuth.getInstance();

        setupUIViews();

        Bundle bundle = getIntent().getExtras();
        String data1 = bundle.get("movieNameBySeat").toString();
        String seatData1 = bundle.get("seat1").toString();
        String seatData2 = bundle.get("seat2").toString();
        String seatData3 = bundle.get("seat3").toString();

       // int seatCounts = getIntent().getIntExtra("seatCount", 0);
        //int receiveValue = getIntent().getIntExtra("value", 0);

        movieName.setText(data1);
        seat1.setText(seatData1);
        seat2.setText(seatData2);
        seat3.setText(seatData3);
        seatCount.setText(String.valueOf(CountSeats()));
        price.setText(String.valueOf(Price(CountSeats())));
      //  seatCount.setText(seatCounts);

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Validation()){

                    sendBookingData();
                    Toast.makeText(ReservationSummery.this, "Booking Sucessful", Toast.LENGTH_SHORT).show();


                }
                else
                    Toast.makeText(ReservationSummery.this, "Booking Failed", Toast.LENGTH_SHORT).show();
            }
        });





    }


    private Boolean Validation(){
        Boolean result = false;

       // String seat_1 = seat1.getText().toString();
        d_movieName = movieName.getText().toString();
        d_date = date.getText().toString();
        d_time = time.getText().toString();
        d_seatNumber1 = seat1.getText().toString();
        d_seatNumber2 = seat2.getText().toString();
        d_seatNumber3 = seat3.getText().toString();
        d_price = price.getText().toString();

        if (d_movieName.isEmpty() && d_price.isEmpty()){
            Toast.makeText(ReservationSummery.this, "System Error", Toast.LENGTH_SHORT).show();
        }else {
            result = true;
        }


        return result;
    }


    private void setupUIViews(){
        movieName = findViewById(R.id.movieName);
        seat1 = findViewById(R.id.S1);
        seat2 = findViewById(R.id.S2);
        seat3 = findViewById(R.id.S3);
        seatCount = findViewById(R.id.numOfSeat);
        price = findViewById(R.id.price);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        paybtn = findViewById(R.id.payBtn);
    }


    private int CountSeats(){
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
    }

    private int Price(int x){
        int total = 0;

        if (x==1){
            total = 400;
        }else if (x==2){
            total = 400*2;
        }else if (x==3){
            total = 400 * 3;
        }

        return total;
    }


    private void sendBookingData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myref = firebaseDatabase.getReference("Bookings").child(d_seatNumber1);
        BookingDetails bookingDetails = new BookingDetails(d_date, d_movieName, d_price, d_seatNumber1, d_seatNumber2, d_seatNumber3, d_time);
        myref.setValue(bookingDetails);
    }

}
