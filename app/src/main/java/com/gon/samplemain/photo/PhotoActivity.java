package com.gon.samplemain.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.gon.samplemain.R;

public class PhotoActivity extends AppCompatActivity {
    ImageButton zoomIn, zoomOut, rotate, bright, dark, gray;

    MyGraphicView gView;

    static float scaleX=1, scaleY=1, angle=0, color=1, satur=1;



    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo_main);

        setTitle("미니포토샵");



        LinearLayout pLayout = (LinearLayout)findViewById(R.id.pic_layout);

        gView = (MyGraphicView) new MyGraphicView(this);

        pLayout.addView(gView);



        clickIcons();



    }



    private void clickIcons() {

        zoomIn = (ImageButton)findViewById(R.id.ibZoomin);

        zoomOut = (ImageButton)findViewById(R.id.ibZoomout);

        rotate = (ImageButton)findViewById(R.id.ibRotate);

        bright = (ImageButton)findViewById(R.id.ibBright);

        dark = (ImageButton)findViewById(R.id.ibDark);

        gray = (ImageButton)findViewById(R.id.ibGray);



        zoomIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                scaleX += 0.2f;

                scaleY += 0.2f;

                gView.invalidate();

            }

        });

        zoomOut.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                scaleX -= 0.2f;

                scaleY -= 0.2f;

                gView.invalidate();

            }

        });

        rotate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                angle += 20;

                gView.invalidate();

            }

        });

        bright.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                color += 0.2f;

                gView.invalidate();

            }

        });

        dark.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                color -= 0.2f;

                gView.invalidate();

            }

        });

        gray.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(satur==0) satur=1;

                else satur=0;

                gView.invalidate();

            }

        });

    }



    private static class MyGraphicView extends View {

        public MyGraphicView(Context context) {

            super(context);

        }



        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);



            Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.icon);

            int picX = (this.getWidth()-pic.getWidth())/2;

            int picY = (this.getHeight()- pic.getHeight())/2;



            int cenX = this.getWidth()/2;

            int cenY = this.getHeight()/2;



            Paint paint = new Paint();

            float[] array = {color, 0, 0, 0, 0,

                    0, color, 0, 0, 0,

                    0, 0, color, 0, 0,

                    0, 0, 0, 1, 0};

            ColorMatrix cm = new ColorMatrix(array);

            if(satur==0) cm.setSaturation(satur);



            paint.setColorFilter(new ColorMatrixColorFilter(cm));



            canvas.scale(scaleX, scaleY, cenX, cenY);

            canvas.rotate(angle, cenX, cenY);

            canvas.drawBitmap(pic, picX, picY, paint);



            pic.recycle();



        }

    }

}



