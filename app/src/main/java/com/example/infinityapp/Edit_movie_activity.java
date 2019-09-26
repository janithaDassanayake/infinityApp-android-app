package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Edit_movie_activity extends AppCompatActivity {

    private EditText EmId;
    private EditText EmName;
    private EditText EmRunningTime;
    private EditText EmProduction;
    private EditText EmLanguage;
    private  EditText EmType;

    private Button btnEdit;
    private Button btndelete;

    private String ikey = " ";
    private String imId =" ";
    private String imName=" ";
    private String imRunningTime=" ";
    private String imProduction=" ";
    private String imLanguage=" ";
    private String imType=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie_activity);

        ikey = getIntent().getStringExtra("key");

        imId = getIntent().getStringExtra("mId");
        imName = getIntent().getStringExtra("mName");
        imRunningTime = getIntent().getStringExtra("mRunningTime");
        imProduction = getIntent().getStringExtra("mProduction");
        imLanguage = getIntent().getStringExtra("mLanguage");
        imType = getIntent().getStringExtra("mType");

        EmId = (EditText) findViewById(R.id.editText_movieID_editMovie);
        EmId.setText(imId);
        EmName = (EditText) findViewById(R.id.editText_movieName_editMovie);
        EmName.setText(imName);

        EmRunningTime = (EditText) findViewById(R.id.editText_runningTime_editMovies);
        EmRunningTime.setText(imRunningTime);
        EmProduction = (EditText) findViewById(R.id.editText_production_editMovie);
        EmProduction.setText(imProduction);
        EmLanguage = (EditText) findViewById(R.id.editText_mLanguage_editMovies);
        EmLanguage.setText(imLanguage);
        EmType = (EditText) findViewById(R.id.editText_mType_editMovies);
        EmType.setText(imType);


        btnEdit =(Button) findViewById(R.id.button_editMovie_editMovie);
        btndelete = (Button) findViewById(R.id.button_DeleteMovie_editMovie2);



        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FireBaseDatabaseHelper().deleteMovie(ikey, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void MovieIsLoaded(List<Movie> movies, List<String> keys) {

                    }

                    @Override
                    public void MovieIsInserted() {

                    }

                    @Override
                    public void MovieIsUpdate() {

                    }

                    @Override
                    public void MovieIsDeleted() {
                        Toast.makeText(Edit_movie_activity.this, "Deleted Movie", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(Edit_movie_activity.this , MainActivity_Tharik.class);
                        Edit_movie_activity.this.startActivity(i);
                    }

                });
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new Movie();

                movie.setmId(EmId.getText().toString().trim());
                movie.setmName(EmName.getText().toString().trim());
                movie.setmLanguage(EmLanguage.getText().toString().trim());
                movie.setmProduction(EmProduction.getText().toString().trim());
                movie.setmRunningTime(EmRunningTime.getText().toString().trim());
                movie.setmType(EmType.getText().toString().trim());

                new FireBaseDatabaseHelper().updateMovie(ikey, movie, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void MovieIsLoaded(List<Movie> movies, List<String> keys) {

                    }

                    @Override
                    public void MovieIsInserted() {

                    }

                    @Override
                    public void MovieIsUpdate() {
                        Toast.makeText(Edit_movie_activity.this, "Updated movie", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(Edit_movie_activity.this , MainActivity_Tharik.class);
                        Edit_movie_activity.this.startActivity(i);
                    }

                    @Override
                    public void MovieIsDeleted() {

                    }
                });
            }
        });
    }
}
