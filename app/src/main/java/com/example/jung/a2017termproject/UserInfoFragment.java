package com.example.jung.a2017termproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserInfoFragment extends Fragment {

    Button addbtn1;
    Button addbtn2;
    Button addbtn3;
    Button addbtn4;
    Button addbtn5;
    Button addbtn6;
    Button addbtn7;
    Button addbtn8;


    public UserInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //!!!!!!!!!!!!!!!!!WORKING!!!!!!!!!!!!!!!!!!!!

        //view return 전이므로 rootView 따로 구현해서 findViewById에서 사용해줘야 한다
        View rootView = inflater.inflate(R.layout.fragment_user_info, container, false);

        addbtn1 = (Button)rootView.findViewById(R.id.sample1_button);
        addbtn2 = (Button)rootView.findViewById(R.id.sample2_button);
        addbtn3 = (Button)rootView.findViewById(R.id.sample3_button);
        addbtn4 = (Button)rootView.findViewById(R.id.sample4_button);
        addbtn5 = (Button)rootView.findViewById(R.id.sample5_button);
        addbtn6 = (Button)rootView.findViewById(R.id.sample6_button);
        addbtn7 = (Button)rootView.findViewById(R.id.sample7_button);
        addbtn8 = (Button)rootView.findViewById(R.id.sample8_button);


        String[] myStockDatabase_name = new String[30];
        String[] myStockDatabase_number = new String[30];
        String[] myStockDatabase_expired = new String[30];
        String[] myStockDatabase_category = new String[30];

        int index = 0;

        try{
            //mystock.txt는 내장메모리 이용
            //getfilesDir의 경우 fragment에서는 getContext()로 접근
            //activity에서는 직접 접근 가능
            BufferedReader br = new BufferedReader(new FileReader(getContext().getFilesDir() + "mystock_name.txt"));
            String s = null;

            while((s = br.readLine()) != null){//이름 채워나가는 중
                myStockDatabase_name[index] = s;
                index++;
            }

            br = new BufferedReader(new FileReader(getContext().getFilesDir() + "mystock_count.txt"));
            s = null;
            index = 0;
            while((s = br.readLine()) != null){//이름 채워나가는 중
                myStockDatabase_number[index] = s;
                index++;
            }

            br = new BufferedReader(new FileReader(getContext().getFilesDir() + "mystock_expired.txt"));
            s = null;
            index = 0;
            while((s = br.readLine()) != null){//이름 채워나가는 중
                myStockDatabase_expired[index] = s;
                index++;
            }

            br = new BufferedReader(new FileReader(getContext().getFilesDir() + "mystock_category.txt"));
            s = null;
            index = 0;
            while((s = br.readLine()) != null){//이름 채워나가는 중
                myStockDatabase_category[index] = s;
                index++;
            }

            br.close();

            addbtn1.setText(myStockDatabase_name[0] + "\n" + myStockDatabase_number[0] + "\n" + myStockDatabase_expired[0] + "\n" + myStockDatabase_category[0]);
            addbtn2.setText(myStockDatabase_name[1] + "\n" + myStockDatabase_number[1] + "\n" + myStockDatabase_expired[1] + "\n" + myStockDatabase_category[1]);
            addbtn3.setText(myStockDatabase_name[2] + "\n" + myStockDatabase_number[2] + "\n" + myStockDatabase_expired[2] + "\n" + myStockDatabase_category[2]);
            addbtn4.setText(myStockDatabase_name[3] + "\n" + myStockDatabase_number[3] + "\n" + myStockDatabase_expired[3] + "\n" + myStockDatabase_category[3]);
            addbtn5.setText(myStockDatabase_name[4] + "\n" + myStockDatabase_number[4] + "\n" + myStockDatabase_expired[4] + "\n" + myStockDatabase_category[4]);
            addbtn6.setText(myStockDatabase_name[5] + "\n" + myStockDatabase_number[5] + "\n" + myStockDatabase_expired[5] + "\n" + myStockDatabase_category[5]);
            addbtn7.setText(myStockDatabase_name[6] + "\n" + myStockDatabase_number[6] + "\n" + myStockDatabase_expired[6] + "\n" + myStockDatabase_category[6]);
            addbtn8.setText(myStockDatabase_name[7] + "\n" + myStockDatabase_number[7] + "\n" + myStockDatabase_expired[7] + "\n" + myStockDatabase_category[7]);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


       /* try {
            String s = null;
            int index = 0;
            String[] myStockDatabase = new String[100];
            InputStream inputStream = getResources().openRawResource(R.raw.mystock);
            DataInputStream data = new DataInputStream(inputStream);
            while((s = data.readLine()) != nul
            l){   //deprecated
                myStockDatabase[index] = s;
                index++;
            }

                ingerdient1.setText(myStockDatabase[0]);
                ingredient2.setText(myStockDatabase[1]);


        } catch (IOException e) {
            e.printStackTrace();
        }*/


        //this.setTextV(inflater, container);   //this doesn't work


        // Inflate the layout for this fragment
        return rootView;
    }

}
