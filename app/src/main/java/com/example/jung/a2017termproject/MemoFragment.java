package com.example.jung.a2017termproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoFragment extends Fragment {

    TextView memo1;
    TextView memo2;
    TextView memo3;
    TextView memo4;


    public MemoFragment() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //view return 전이므로 rootView 따로 구현해서 findViewById에서 사용해줘야 한다
        View rootView = inflater.inflate(R.layout.fragment_memo, container, false);

        memo1 = (TextView)rootView.findViewById(R.id.memo1);
        memo2 = (TextView)rootView.findViewById(R.id.memo2);
        memo3 = (TextView)rootView.findViewById(R.id.memo3);
        memo4 = (TextView)rootView.findViewById(R.id.memo4);


        String[] memo_string = new String[30];

        int index = 0;

        try {
            //mystock.txt는 내장메모리 이용
            //getfilesDir의 경우 fragment에서는 getContext()로 접근
            //activity에서는 직접 접근 가능
            BufferedReader br = new BufferedReader(new FileReader(getContext().getFilesDir() + "mymemo.txt"));
            String s = null;

            while ((s = br.readLine()) != null) {//한 줄 읽어서 string 배열에 저장
                memo_string[index] = s;
                index++;
            }


            br.close();

            memo1.setText(memo_string[0]);
            memo2.setText(memo_string[1]);
            memo3.setText(memo_string[2]);
            memo4.setText(memo_string[3]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Inflate the layout for this fragment
        return rootView;
    }
}
