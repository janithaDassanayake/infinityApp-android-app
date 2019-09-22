package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Admin_logn extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 3;

     Button signup;

     TextView forgotpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_logn);

        signup = findViewById(R.id.register);
        forgotpassword=findViewById(R.id.forgot);
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 3");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_logn.this, Mregister.class);
                startActivity(intent);
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_logn.this, mforgotpassword.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword){

        if((userName.equals("Admin")) && (userPassword.equals("1234"))){

            Intent intent =new Intent(Admin_logn.this,MainActivity.class);
            startActivity(intent);

        }else if((userName.equals("user")) && (userPassword.equals("1234"))){

            Intent intent =new Intent(Admin_logn.this,HomePage.class);
            startActivity(intent);

        }else if((userName.equals("tharik")) && (userPassword.equals("1234"))){

            Intent intent =new Intent(Admin_logn.this,MainActivity_Tharik.class);
            startActivity(intent);

        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }





}