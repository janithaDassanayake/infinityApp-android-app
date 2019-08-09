package com.example.infinityapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton6;
    private ImageButton imageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.EditProfilebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Infinity_edit_profile_activity();
            }
        });

        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Insert_User_activity();

            }
        });


        imageButton2=(ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Delete_user_activity();

            }
        });


        imageButton3=(ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Edit_user_activity();

            }
        });


        imageButton4=(ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_search_user_activity();

            }
        });

        imageButton6=(ImageButton) findViewById(R.id.imageButton5);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_text_user_activity();

            }
        });



        imageButton7=(ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Block_user_activity();

            }
        });




    }

    public void open_Infinity_edit_profile_activity(){

        Intent intent = new Intent(this,Infinity_Edit_profile_Activity.class);
        startActivity(intent);
    }

    public void open_Insert_User_activity(){

        Intent intent=new Intent(this,Insert_Activity.class);
        startActivity(intent);
    }


    public void open_Delete_user_activity(){

        Intent intent=new Intent(this,Delete_user_activity.class);
        startActivity(intent);
    }

    public void open_Edit_user_activity(){

        Intent intent=new Intent(this,Edit_user_activity.class);
        startActivity(intent);
    }

    public void open_search_user_activity(){

        Intent intent=new Intent(this,Search_user_activity.class);
        startActivity(intent);
    }

    public void open_text_user_activity(){

        Intent intent=new Intent(this,Text_user_activity.class);
        startActivity(intent);
    }

    public void open_Block_user_activity(){

        Intent intent=new Intent(this,Block_user_activity.class);
        startActivity(intent);
    }
}
