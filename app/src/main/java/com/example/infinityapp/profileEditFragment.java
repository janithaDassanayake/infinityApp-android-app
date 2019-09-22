package com.example.infinityapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class profileEditFragment extends Fragment {

    private Button btn;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_profile_edit, container, false);
        btn = (Button)view.findViewById(R.id.button_submit_editProfile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( getActivity(), "Submited", Toast.LENGTH_SHORT).show();
                Intent intentProfileEdit = new Intent(getContext(),MainActivity_Tharik.class);
                startActivity(intentProfileEdit);
            }
        });
       // return inflater.inflate(R.layout.fragment_profile_edit, container, false);
        return view;

    }



}
