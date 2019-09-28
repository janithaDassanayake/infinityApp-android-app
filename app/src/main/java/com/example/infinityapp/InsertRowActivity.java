package com.example.infinityapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infinityapp.validation.janithValidation;


public class InsertRowActivity extends AppCompatActivity {

   // ConstraintLayout myLayout;
    //AnimationDrawable animationDrawable;

    private TextView mUserName;
    private TextView mUserPhone;
    private TextView mUserEmail;
    private Button insertRowFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_insert_row);

        /*
        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

*/



        insertRowFrom = (Button) findViewById(R.id.insertRowFrom);
        mUserName = (TextView) findViewById(R.id.userNameTxt);
        mUserPhone = (TextView) findViewById(R.id.userPhoneTxt);
        mUserEmail = (TextView) findViewById(R.id.userEmailTxt);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Inser New Row in SQLite");
        }
    }

    public void insertRow(View view) {

        if(!mUserName.getText().toString().isEmpty()) {
            if(new janithValidation().isValidName(mUserName.getText().toString())){

                if(!mUserPhone.getText().toString().isEmpty()) {
                    if(new janithValidation().isValidphoneNo(mUserPhone.getText().toString())){

                        if(!mUserEmail.getText().toString().isEmpty()) {
                            if(new janithValidation().isValidStaff(mUserEmail.getText().toString())){




                            TextView userNameTxtView = findViewById(R.id.userNameTxt);
                            TextView userPhoneTxtView = findViewById(R.id.userPhoneTxt);
                            TextView userEmailTxtView = findViewById(R.id.userEmailTxt);

                            UsersDatabaseAdapter.insertEntry(userNameTxtView.getText().toString().trim(), userPhoneTxtView.getText().toString(), userEmailTxtView.getText().toString());
                            Intent myIntent = new Intent(InsertRowActivity.this, MainActivity.class);
                            InsertRowActivity.this.startActivity(myIntent);


                            }else{
                                Context context=getApplicationContext();
                                LayoutInflater inflater=getLayoutInflater();
                                View customToastroot=inflater.inflate(R.layout.emptyfeild_toast,null);
                                Toast customToast=new Toast(context);

                                customToast.setView(customToastroot);
                                customToast.setDuration(Toast.LENGTH_LONG);
                                customToast.show();
                            }
                        }else{
                            Context context=getApplicationContext();
                            LayoutInflater inflater=getLayoutInflater();
                            View customToastroot=inflater.inflate(R.layout.emptyfeild_toast,null);
                            Toast customToast=new Toast(context);

                            customToast.setView(customToastroot);
                            customToast.setDuration(Toast.LENGTH_LONG);
                            customToast.show();
                        }


                    }else{
                        Context context=getApplicationContext();
                        LayoutInflater inflater=getLayoutInflater();
                        View customToastroot=inflater.inflate(R.layout.phone_no_toast,null);
                        Toast customToast=new Toast(context);

                        customToast.setView(customToastroot);
                        customToast.setDuration(Toast.LENGTH_LONG);
                        customToast.show();
                    }
                }else{
                    Context context=getApplicationContext();
                    LayoutInflater inflater=getLayoutInflater();
                    View customToastroot=inflater.inflate(R.layout.phone_no_toast,null);
                    Toast customToast=new Toast(context);

                    customToast.setView(customToastroot);
                    customToast.setDuration(Toast.LENGTH_LONG);
                    customToast.show();
                }
            }else{
                Context context=getApplicationContext();
                LayoutInflater inflater=getLayoutInflater();
                View customToastroot=inflater.inflate(R.layout.emptyfeild_toast,null);
                Toast customToast=new Toast(context);

                customToast.setView(customToastroot);
                customToast.setDuration(Toast.LENGTH_LONG);
                customToast.show();
            }
        }else{
            Context context=getApplicationContext();
            LayoutInflater inflater=getLayoutInflater();
            View customToastroot=inflater.inflate(R.layout.emptyfeild_toast,null);
            Toast customToast=new Toast(context);

            customToast.setView(customToastroot);
            customToast.setDuration(Toast.LENGTH_LONG);
            customToast.show();
        }


    }





    public void clearAddstaff(View view){
        mUserName.setText("");
        mUserPhone.setText("");
        mUserEmail.setText("");
    }










    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}