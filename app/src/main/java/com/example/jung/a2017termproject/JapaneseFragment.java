package com.example.jung.a2017termproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JapaneseFragment extends Fragment {
    DatePicker mDate;

    public JapaneseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_japanese, container, false);
    }

}
