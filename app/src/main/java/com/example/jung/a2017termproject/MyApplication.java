package com.example.jung.a2017termproject;

import android.app.Application;

/**
 * Created by JUNG on 2017-12-07.
 */

public class MyApplication extends Application {
    public MainDatabase mainDatabase;
    public String userName;
    public String userCode[];

    @Override
    public void onCreate(){

        mainDatabase = new MainDatabase();
    /*
        userName = null;
        userCode = null;
        */
        super.onCreate();
    }

    public MainDatabase MainDatabase(){
        return mainDatabase;
    }

    public String userName(){
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] userCode(){
        return userCode;
    }
    public void setUserCode(String[] userCode){
        this.userCode = userCode;
    }
}
