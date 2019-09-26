package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_logn);

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
            finish();
            startActivity(new Intent(Admin_logn.this,HomePage.class));
        }


    }

    public void validate(String userEmail,String userPassword)
    {
        if(userEmail.equals("Admin@infinity.com") && userPassword.equals("1234"))
        {
            Toast.makeText(Admin_logn.this, "Admin login Is Successful", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(Admin_logn.this,MainActivity.class);
            startActivity(intent);

        }else if(userEmail.equals("tharik@infinity.com") && userPassword.equals("1234"))
        {

            Toast.makeText(Admin_logn.this, "Admin tharik Login Is Successful", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(Admin_logn.this,MainActivity_Tharik.class);
            startActivity(intent);

        }
        else {


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






}