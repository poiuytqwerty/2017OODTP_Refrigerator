package com.example.jung.a2017termproject;

/**
 * Created by user on 2017-11-27.
 */

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Spinner;

        import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;

        import UserInformationAdditional.StockIngredient;

public class userfirstinput_main extends Activity {

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userfirstinput_main);


        startActivity(new Intent(this, MainActivity.class));
        finish();

    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userfirstinput_main);

       /* Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);*/
        //startActivity(new Intent(this, MainActivity.class));

    }

    public void submit_btn(View v){
      /*try {

            //전역변수 준비



            EditText user_name = (EditText) findViewById(R.id.nameinput);
            Spinner user_type = (Spinner) findViewById(R.id.spinner1);

            String name = user_name.getText().toString();    //이름
            String type = user_type.getSelectedItem().toString();

            FileWriter fw_name  = new FileWriter(getFilesDir() + "user_name.txt", true);
            BufferedWriter bw_name = new BufferedWriter(fw_name);
            bw_name.write(name);
            bw_name.close();

            FileWriter fw_type  = new FileWriter(getFilesDir() + "user_type.txt", true);
            BufferedWriter bw_type = new BufferedWriter(fw_name);
            bw_name.write(type + " ");
            bw_name.close();





       } catch (IOException e) {
            e.printStackTrace();
        }*/
        //띄어쓰기 기준으로 쪼개서


        try {

            //전역변수 준비

            //MyApplication myApplication = new MyApplication();

            Spinner user_type = (Spinner) findViewById(R.id.spinner1);

            String type = user_type.getSelectedItem().toString();

            //Write Usertype as String
            FileWriter fw_type  = new FileWriter(getFilesDir() + "user_type.txt", true);
            BufferedWriter bw_type = new BufferedWriter(fw_type);
            fw_type.write(type + "\n");
            bw_type.close();

/*
            String name = "이윤";
            myApplication.setUserName(name);    //전역변수 이름에 넣는다
            //myApplication.setUserCode(type);    //전역변수 code에 넣는다


*/


        } catch (IOException e) {
            e.printStackTrace();
        }





        finish();
    }


}
