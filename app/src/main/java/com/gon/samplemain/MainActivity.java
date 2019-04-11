package com.gon.samplemain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gon.samplemain.lineview.LineViewActivity;
import com.gon.samplemain.picture.PictureActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //각 버튼의 객체 생성
        Button btnNews          = findViewById(R.id.btn_news);
        Button btnLineview      = findViewById(R.id.btn_lineview);
        Button btnPicture       = findViewById(R.id.btn_picture);
        Button btnpicturePane   = findViewById(R.id.btn_picturePane);

        btnLineview.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LineActivity.class) ;
                Intent intent = new Intent(MainActivity.this, LineViewActivity.class) ;
                startActivity(intent) ;
            }
        });

        btnPicture.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PictureActivity.class);
                startActivity(intent);

            }


        });

    }
}
