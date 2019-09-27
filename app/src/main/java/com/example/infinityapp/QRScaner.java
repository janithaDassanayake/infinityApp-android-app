package com.example.infinityapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.infinityapp.Model.TicketList;
import com.example.infinityapp.QRadapter.QRAdapter;
import com.example.infinityapp.QRdatabase.QRDBhelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class QRScaner extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;


    RecyclerView recyclerView;
    ArrayList<TicketList> arrayList;

    QRDBhelper bhelper;

    QRAdapter qrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscaner);



        myLayout=(ConstraintLayout)findViewById(R.id.myLayout);
        animationDrawable=(AnimationDrawable)myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bhelper=new QRDBhelper(this);

        arrayList=bhelper.getALLinformation();

        if(arrayList.size()>0){

            qrAdapter=new QRAdapter(arrayList,this);
            recyclerView.setAdapter(qrAdapter);


        }else {

            Toast.makeText(getApplicationContext(),"no data Found",Toast.LENGTH_LONG).show();

        }

        new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                final int position = viewHolder.getAdapterPosition();
                TicketList ticketList=arrayList.get(position);

                //remove the data
                bhelper.deleteRowTicket(ticketList.getId());
                arrayList.remove(position);
                qrAdapter.notifyItemRemoved(position);
                qrAdapter.notifyItemRangeChanged(position,arrayList.size());


            }
        }).attachToRecyclerView(recyclerView);

        final IntentIntegrator intentIntegrator=new IntentIntegrator(this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setCameraId(0);

        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //camara will open
                intentIntegrator.initiateScan();


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result!=null){

            if(result.getContents()==null){

                Toast.makeText(getApplicationContext(),"no result found",Toast.LENGTH_LONG).show();
            }else{

                boolean isInseted=bhelper.insertQRDate(result.getFormatName(),result.getContents());

                if(isInseted){

                    arrayList.clear();
                    arrayList=bhelper.getALLinformation();
                    qrAdapter=new QRAdapter(arrayList,this);
                    recyclerView.setAdapter(qrAdapter);
                    qrAdapter.notifyDataSetChanged();

                }

            }
        }

        else {

            super.onActivityResult(requestCode,resultCode,data);

        }
    }
}
