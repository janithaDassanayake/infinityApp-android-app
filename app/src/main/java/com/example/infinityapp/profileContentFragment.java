package com.example.infinityapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.example.infinityapp.profileContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link com.example.infinityapp.profileContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileContentFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_content, container, false);
    }


}
