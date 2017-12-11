package com.example.jung.a2017termproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingBasketFragment extends Fragment {

    Button addbtn1;
    Button addbtn2;
    Button addbtn3;
    Button addbtn4;
    Button addbtn5;
    Button addbtn6;
    Button addbtn7;
    Button addbtn8;
    Button addbtn9;
    Button addbtn10;



    public ShoppingBasketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_shopping_basket, container, false);

        addbtn1 = (Button)rootView.findViewById(R.id.shoppingimageButton1);
        addbtn2 = (Button)rootView.findViewById(R.id.shoppingimageButton2);
        addbtn3 = (Button)rootView.findViewById(R.id.shoppingimageButton3);
        addbtn4 = (Button)rootView.findViewById(R.id.shoppingimageButton4);
        addbtn5 = (Button)rootView.findViewById(R.id.shoppingimageButton5);
        addbtn6 = (Button)rootView.findViewById(R.id.shoppingimageButton6);
        addbtn7 = (Button)rootView.findViewById(R.id.shoppingimageButton7);
        addbtn8 = (Button)rootView.findViewById(R.id.shoppingimageButton8);
        addbtn9 = (Button)rootView.findViewById(R.id.shoppingimageButton9);
        addbtn10 = (Button)rootView.findViewById(R.id.shoppingimageButton10);


        String[] myShoppingDatabase_name = new String[30];
        String[] myShoppingDatabase_number = new String[30];


        int index = 0;

        try{
            //mystock.txt는 내장메모리 이용
            //getfilesDir의 경우 fragment에서는 getContext()로 접근
            //activity에서는 직접 접근 가능
            BufferedReader br = new BufferedReader(new FileReader(getContext().getFilesDir() + "myshopping_name.txt"));
            String s = null;

            while((s = br.readLine()) != null){//이름 채워나가는 중
                myShoppingDatabase_name[index] = s;
                index++;
            }

            br = new BufferedReader(new FileReader(getContext().getFilesDir() + "myshopping_count.txt"));
            s = null;
            index = 0;
            while((s = br.readLine()) != null){//이름 채워나가는 중
                myShoppingDatabase_number[index] = s;
                index++;
            }


            br.close();

            addbtn1.setText(myShoppingDatabase_name[0] + "\n" + myShoppingDatabase_number[0]);
            addbtn2.setText(myShoppingDatabase_name[1] + "\n" + myShoppingDatabase_number[1]);
            addbtn3.setText(myShoppingDatabase_name[2] + "\n" + myShoppingDatabase_number[2]);
            addbtn4.setText(myShoppingDatabase_name[3] + "\n" + myShoppingDatabase_number[3]);
            addbtn5.setText(myShoppingDatabase_name[4] + "\n" + myShoppingDatabase_number[4]);
            addbtn6.setText(myShoppingDatabase_name[5] + "\n" + myShoppingDatabase_number[5]);
            addbtn7.setText(myShoppingDatabase_name[6] + "\n" + myShoppingDatabase_number[6]);
            addbtn8.setText(myShoppingDatabase_name[7] + "\n" + myShoppingDatabase_number[7]);
            addbtn9.setText(myShoppingDatabase_name[8] + "\n" + myShoppingDatabase_number[8]);
            addbtn10.setText(myShoppingDatabase_name[9] + "\n" + myShoppingDatabase_number[9]);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Inflate the layout for this fragment
        return rootView;
    }

}
