package com.gon.samplemain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gon.samplemain.lineview.LineViewActivity;

public class LineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LineViewActivity lva = new LineViewActivity(this);
        setContentView(lva);
    }
}
