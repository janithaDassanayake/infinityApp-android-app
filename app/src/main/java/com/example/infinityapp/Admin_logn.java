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

/* Malidi Wageesha author*

    IT18194272

    User & Admin logins
 */
public class Admin_logn extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 3;

     private Button signup;

     private TextView forgotpassword;

     private FirebaseAuth firebaseAuth;


    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        setContentView(R.layout.activity_admin_logn);


        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();


        signup = findViewById(R.id.register);
        forgotpassword=findViewById(R.id.forgot);
        Email = (EditText)findViewById(R.id.etlogemail);
        Password = (EditText)findViewById(R.id.etlogpassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 3");

        //A firebase Auth instance is created
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user=firebaseAuth.getCurrentUser();

      if(user!=null)
        {

            startActivity(new Intent(Admin_logn.this,HomePage.class));
            finish();
        }


    }

    public void validate(String userEmail,String userPassword)
    {

        if(validate()) {
            if (userEmail.equals("Admin@infinity.com") && userPassword.equals("1234")) {
                Toast.makeText(Admin_logn.this, "Admin login Is Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Admin_logn.this, MainActivity.class);
                startActivity(intent);

            } else if (userEmail.equals("tharik@infinity.com") && userPassword.equals("1234")) {

                Toast.makeText(Admin_logn.this, "Admin tharik Login Is Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Admin_logn.this, MainActivity_Tharik.class);
                startActivity(intent);

            } else {


                firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Admin_logn.this, "Login Is Successful", Toast.LENGTH_SHORT).show();
                            checkemailverification();
                            //startActivity(new Intent(Admin_logn.this, HomePage.class));
                        } else {
                            Toast.makeText(Admin_logn.this, "Login failed.Invalid credentials", Toast.LENGTH_SHORT).show();
                            counter--;

                            Info.setText("No of attempts remaining: " + String.valueOf(counter));

                            if (counter == 0) {
                                Login.setEnabled(false);
                            }
                        }

                    }
                });
            }
        }
    }

    private void checkemailverification()
    {
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        Boolean emailflag=firebaseUser.isEmailVerified();

        if(emailflag)
        {
            finish();
            startActivity(new Intent(Admin_logn.this, HomePage.class));
        }else{

            Toast.makeText(Admin_logn.this, "Please go and verify link sent to your email", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
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

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate(Email.getText().toString(),Password.getText().toString());
            }
        });
    }

    private Boolean validate()
    {
        Boolean result=false;

        String value_email = Email.getText().toString();
        String value_password=Password.getText().toString();

        if(value_email.isEmpty() || value_password.isEmpty())
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






}