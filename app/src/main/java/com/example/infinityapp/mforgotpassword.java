package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mforgotpassword extends AppCompatActivity {

    Button fsend;

    EditText forgotemail;

    String v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mforgotpassword);

        fsend=findViewById(R.id.sendbtn);

        forgotemail=findViewById(R.id.femail);




    }

    @Override
    protected void onResume() {
        super.onResume();



        fsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                v1=forgotemail.getText().toString();

                Intent i=new Intent(mforgotpassword.this,mforgotpassword2.class);

                i.putExtra("msg1",v1);

                startActivity(i);
            }
        });


    }
}
