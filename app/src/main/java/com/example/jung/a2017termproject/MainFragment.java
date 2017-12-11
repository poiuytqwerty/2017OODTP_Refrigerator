package com.example.jung.a2017termproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    TextView userName;

    public MainFragment() {
        // Required empty public constructor
    }

//user_name.txt
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //textViewUserName

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        userName = (TextView) rootView.findViewById(R.id.textViewUserName); //nav Drawer 이름 id
/*
        MyApplication myApplication = new MyApplication() ;
        String username = myApplication.userName().toString();

        userName.setText(username);
*/
        String Name = null;
/*
        MyApplication myApplication = (MyApplication) getContext().getApplicationContext();
        Name = myApplication.userName();
        userName.setText(Name);
        */
/*
            try {

                BufferedReader br = new BufferedReader(new FileReader(getContext().getFilesDir() + "user_name.txt"));      //open user_name.txt
                String s = null;

                while ((s = br.readLine()) != null) { //읽어서
                    Name = s;   //Name에 저장
                }

                userName.setText(Name);//Name을 text로 설정

                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
        // Inflate the layout for this fragment
        return rootView;
    }

}
