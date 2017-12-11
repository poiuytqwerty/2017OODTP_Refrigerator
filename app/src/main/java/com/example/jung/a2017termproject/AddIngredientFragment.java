package com.example.jung.a2017termproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddIngredientFragment extends Fragment {
    EditText ingredient_name;

    public AddIngredientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_ingredient, container, false);
        //ingredient_name = (EditText) rootView.findViewById(R.id.ingredient_name);
        //String getIngName = ingredient_name.getText().toString();



        // Inflate the layout for this fragment
        return rootView;
    }

}
