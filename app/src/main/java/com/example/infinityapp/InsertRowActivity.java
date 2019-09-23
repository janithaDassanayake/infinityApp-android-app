package com.example.infinityapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infinityapp.validation.janithValidation;


public class InsertRowActivity extends AppCompatActivity {

    private TextView mUserName;
    private TextView mUserPhone;
    private TextView mUserEmail;
    private Button insertRowFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_row);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


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


                        TextView userNameTxtView = findViewById(R.id.userNameTxt);
                        TextView userPhoneTxtView = findViewById(R.id.userPhoneTxt);
                        TextView userEmailTxtView = findViewById(R.id.userEmailTxt);

                        UsersDatabaseAdapter.insertEntry(userNameTxtView.getText().toString().trim(), userPhoneTxtView.getText().toString(), userEmailTxtView.getText().toString());
                        Intent myIntent = new Intent(InsertRowActivity.this, MainActivity.class);
                        InsertRowActivity.this.startActivity(myIntent);


                    }else{
                        Toast.makeText(this, "Please enter valid phone No", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "Please Enter Phone No", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Please enter Correct name", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Please Enter name", Toast.LENGTH_SHORT).show();
        }


    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}