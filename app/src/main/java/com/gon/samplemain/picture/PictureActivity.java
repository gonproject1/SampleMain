package com.gon.samplemain.picture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gon.samplemain.R;
import com.gon.samplemain.lineview.MyView;

import java.io.InputStream;

public class PictureActivity extends AppCompatActivity {
    ImageView imageView;
    Button gallayButton;    //갤러리오픈
    Button lineButton;      //편집
    Bitmap mapimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_main);

        imageView = (ImageView)findViewById(R.id.image);

        //갤러리 열기
        gallayButton = (Button)findViewById(R.id.open);
        //사진위에 그리는 버튼
        lineButton = (Button)findViewById(R.id.lineview);

        gallayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();


                if(imageView != null){

                    MyView m;
                    m = new MyView(getApplicationContext(),mapimg);
                    setContentView(m);
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    imageView.setImageBitmap(img);
                    //cavas에서 그릴수 있게 변수에 img넣기
                    mapimg = img;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
