package com.example.infinityapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Mregister extends AppCompatActivity {

    //ConstraintLayout myLayout;
    //AnimationDrawable animationDrawable;

    private TextView reglogin;

     private Button register;



    private EditText fname,lname,email,phone,password,cpassword;


    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_mregister);

        /*
        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
*/

        setViews();

        fname=(EditText) findViewById(R.id.etfname);
        lname=(EditText)findViewById(R.id.etlname);
        email=(EditText) findViewById(R.id.etemail);
        phone=(EditText) findViewById(R.id.etphone);
        password=(EditText) findViewById(R.id.etpassword);
        cpassword=(EditText) findViewById(R.id.etcpassword);
        reglogin= findViewById(R.id.txtbsignin);
        register= (Button) findViewById(R.id.btnregister);

        firebaseAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    if (validate1()) {
                        final String user_fname = fname.getText().toString().trim();
                        final String user_lname = lname.getText().toString().trim();
                        final String user_email = email.getText().toString().trim();
                        final String user_phone = phone.getText().toString().trim();
                        final String user_password = password.getText().toString().trim();
                        final String User_cpassword = cpassword.getText().toString().trim();

                          validate2();

                        firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    User user = new User(user_fname, user_lname, user_email, user_phone);

                                    FirebaseDatabase.getInstance().getReference("users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user);

                               /* Toast.makeText(Mregister.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Mregister.this,HomePage.class));*/

                                    sendEmail();

                                } else {
                                    Toast.makeText(Mregister.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }


            }
        });

    }

    private void setViews()
    {
       fname=(EditText) findViewById(R.id.etfname);
        lname=(EditText)findViewById(R.id.etlname);
        email=(EditText) findViewById(R.id.etemail);
      phone=(EditText) findViewById(R.id.etphone);
        password=(EditText) findViewById(R.id.etpassword);
        cpassword=(EditText) findViewById(R.id.etcpassword);
        //reglogin= findViewById(R.id.txtbsignin);
        register= (Button) findViewById(R.id.btnregister);
    }

    @Override
    protected void onResume() {
        super.onResume();

        reglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mregister.this, Admin_logn.class);
                startActivity(intent);
            }
        });


    }

    private Boolean validate1()
    {
        Boolean result=false;

        String f_name=fname.getText().toString();
        String l_name=lname.getText().toString();
        String e_mail=email.getText().toString();
        String u_phone=phone.getText().toString();
        String u_password=password.getText().toString();
        String u_cpassword=cpassword.getText().toString();

        if(f_name.isEmpty() || l_name.isEmpty() || e_mail.isEmpty() || u_phone.isEmpty() || u_password.isEmpty() || u_cpassword.isEmpty())
        {
           Context context=getApplicationContext();
            LayoutInflater inflater=getLayoutInflater();
            View customToastroot=inflater.inflate(R.layout.emptyfeild_toast,null);
            Toast customToast=new Toast(context);

            customToast.setView(customToastroot);
            customToast.setDuration(Toast.LENGTH_LONG);
            customToast.show();



        }else{

            result=true;
        }
        return result;


    }

    private void sendEmail()
    {
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
                if(firebaseUser!=null)
                {
                    firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(Mregister.this,"Successfully Registered verification Mail Sent",Toast.LENGTH_SHORT).show();
                                firebaseAuth.signOut();
                                finish();
                                startActivity(new Intent(Mregister.this,Admin_logn.class));

                            }
                            else{

                                Toast.makeText(Mregister.this,"verification email not sent",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
    }

   private void validate2()
    {


        String f_name=fname.getText().toString();
        String l_name=lname.getText().toString();
        String e_mail=email.getText().toString();
        String u_phone=phone.getText().toString();
        String u_password=password.getText().toString();
        String u_cpassword=cpassword.getText().toString();

        if(u_phone.length()!=10)
        {
            phone.setError("Please enter a valid phone number");
            phone.requestFocus();
            return;
        }

        if(u_password.length() < 8)
        {
            password.setError("Password should be at least 8 characters");
            password.requestFocus();
            return;
        }

        if(u_password.equals(u_cpassword)==false) {
            cpassword.setError("passwords does not match");
            cpassword.requestFocus();
            return;
        }

    }




}
