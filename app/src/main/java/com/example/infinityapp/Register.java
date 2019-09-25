package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    //private TextView reglogin;

    private Button register;

    private EditText fname,lname,email,phone,password,cpassword;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setViews();

                Intent intent = new Intent(Register.this, MuserMyaccount.class);
                startActivity(intent);


            }
        });


    }

    private void setViews()
    {
        fname=(EditText) findViewById(R.id.etfname);
        lname=(EditText)findViewById(R.id.etlname);
        email=(EditText)findViewById(R.id.etemail);
        phone=(EditText)findViewById(R.id.etphone);
        password=(EditText)findViewById(R.id.etPassword);
        cpassword=(EditText)findViewById(R.id.etcpassword);
      //  reglogin=(TextView) findViewById(R.id.txtbsignin);
        register=(Button) findViewById(R.id.btnregister);
    }


    @Override
    protected void onResume() {
        super.onResume();

      /*  reglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Admin_logn.class);
                startActivity(intent);
            }
        });*/



    }
}
