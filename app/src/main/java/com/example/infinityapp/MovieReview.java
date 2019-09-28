package com.example.infinityapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MovieReview extends AppCompatActivity {

    MovieReviewDbHeleper myDb;
    EditText editName,editRating,Comment ,reviewid;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_review);

        myDb = new MovieReviewDbHeleper(this);

        editName = (EditText)findViewById(R.id.NameS);
        editRating = (EditText)findViewById(R.id.rating);
        Comment = (EditText)findViewById(R.id.comment);
        reviewid = (EditText)findViewById(R.id.reviewID);



        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);


        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(reviewid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MovieReview.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MovieReview.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(reviewid.getText().toString(),
                                editName.getText().toString(),
                                editRating.getText().toString(),Comment.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MovieReview.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MovieReview.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editRating.getText().toString(),
                                Comment.getText().toString()
                        );
                        if(isInserted == true)
                            Toast.makeText(MovieReview.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MovieReview.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","No Data found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Review ID :"+ res.getString(0)+"\n");
                            buffer.append("Movie name :"+ res.getString(1)+"\n");
                            buffer.append("Rating :"+ res.getString(2)+"\n");
                            buffer.append("Comment :"+ res.getString(3)+"\n\n");

                        }

                        // Show all data
                        showMessage("review List",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}
