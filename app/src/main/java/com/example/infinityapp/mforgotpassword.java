package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class mforgotpassword extends AppCompatActivity {

    Button resetPassword;

    EditText forgotemail;

    String v1;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mforgotpassword);

        resetPassword=findViewById(R.id.sendbtn);

        forgotemail=findViewById(R.id.etresetp);

        firebaseAuth=FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String User_email=forgotemail.getText().toString().trim();

                if(User_email.equals(""))
                {
                    Toast.makeText(mforgotpassword.this,"Please enter your registered emailID",Toast.LENGTH_SHORT).show();
                }
                else{
                    firebaseAuth.sendPasswordResetEmail(User_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful())
                            {
                                Toast.makeText(mforgotpassword.this,"Password reset mail sent",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(mforgotpassword.this,Admin_logn.class));

                            }else{

                                Toast.makeText(mforgotpassword.this,"Error in sending password reset Email",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();





    }
}
