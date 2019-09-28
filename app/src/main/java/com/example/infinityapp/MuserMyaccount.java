package com.example.infinityapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MuserMyaccount extends AppCompatActivity {

    private Button edit;
    private Button signout;


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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

                FirebaseAuth.getInstance().signOut();

                Intent i=new Intent(MuserMyaccount.this,Admin_logn.class);


                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(i);
            }
        });


    }
}
