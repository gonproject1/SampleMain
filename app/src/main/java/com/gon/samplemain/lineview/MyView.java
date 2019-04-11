package com.gon.samplemain.lineview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MyView extends View {


    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    //private int paintColor = 0xFF120000;
    private int paintColor = 0xFFa68b1f;
    private Canvas drawCanvas;
    private Bitmap canvasBitmap;
    private Bitmap canImg;

    public MyView(Context context, Bitmap img){

        super(context);
        canImg = img;
        setupDrawing();
    }

    private void setupDrawing(){

        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(50);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged( w, h, oldw, oldh);
        //canvasBitmap = Bitmap.createBitmap( w, h, Bitmap.Config.ARGB_8888);
        canvasBitmap = Bitmap.createBitmap(canImg).copy(Bitmap.Config.ARGB_8888,true);
        drawCanvas = new Canvas(canvasBitmap);
    }

    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawPath.lineTo(touchX, touchY);
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();

                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }


}