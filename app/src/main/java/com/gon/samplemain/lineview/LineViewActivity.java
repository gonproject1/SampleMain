package com.gon.samplemain.lineview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class LineViewActivity extends AppCompatActivity {

    MyView m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //@@ 임시주석
        //m = new MyView(this);
        setContentView(m);

    }

}