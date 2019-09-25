package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MuserMyaccount extends AppCompatActivity {

    private Button edit;
    private Button signout;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muser_myaccount);


        edit=findViewById(R.id.btnedit);
        signout = findViewById(R.id.btnsignout);

        firebaseAuth=FirebaseAuth.getInstance();
    }


    @Override
    protected void onResume() {
        super.onResume();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MuserMyaccount.this,userEditProfile.class);

                startActivity(i);
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.signOut();;
                finish();


                Intent i=new Intent(MuserMyaccount.this,Admin_logn.class);

                startActivity(i);
            }
        });


    }
}
