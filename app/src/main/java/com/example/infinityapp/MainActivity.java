package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    UsersDatabaseAdapter usersDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        // create the instance of Databse

        usersDatabaseAdapter=new UsersDatabaseAdapter(getApplicationContext());
    }

    //open activity to Insert new rows in table
    public void insertRowActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, InsertRowActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    //Open activity to update rows
    public void updateRowView(View view) {
        Intent myIntent = new Intent(MainActivity.this, UpdateRowsActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    //call method to show rows count in Toast
    public void rowCount(View view) {
        UsersDatabaseAdapter.getRowCount();
    }

    //Open activity to delete rows

    public void deleteRowActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, DeleteRowsActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void goTOQRscaner(View view) {
        Intent myIntent = new Intent(MainActivity.this, QRScaner.class);
        MainActivity.this.startActivity(myIntent);
    }

    //Button method to truncate table rows
    public void truncateTable(View view) {
        UsersDatabaseAdapter.truncateTable();
    }


    public void DisplayRow(View view) {
        Intent myIntent = new Intent(MainActivity.this,DisplayActivity.class);
        MainActivity.this.startActivity(myIntent);
    }


    //Open URL in browser
    public void goToUrl (View view) {
        String url = "http://www.google.com";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}