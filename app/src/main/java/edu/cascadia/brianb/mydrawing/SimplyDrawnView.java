package edu.cascadia.brianb.mydrawing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Edited by Brian Bansenauer on 10/18/15.
 */
public class SimplyDrawnView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mWidth, mHeight;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
     }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE); //draw background

        //Draw line
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //Draw red line
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(16.0f);
        canvas.drawLine(mWidth,mHeight,(mWidth/2),(mHeight/2),mPaint);

        //Draw green lines
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(30.0f);
        canvas.drawLine(10,20,mWidth,20,mPaint);
        canvas.drawLine(10,140,mWidth,140,mPaint);
        canvas.drawLine(10,260,mWidth,260,mPaint);
        canvas.drawLine(10,380,mWidth,380,mPaint);
        canvas.drawLine(10,500,mWidth,500,mPaint);
        canvas.drawLine(10,620,mWidth,620,mPaint);

        //Draw Text
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(80);
        canvas.drawText("I am a Drawing",10,(mHeight/2),mPaint);

        //TODO: Draw Text on a Path

        //TODO: Draw filled, opaque, and open ovals

        //Draw bee bitmap
        FrameLayout myCanvas = (FrameLayout) findViewById(R.id.mycanvas);

        Resources res = getResources();
        Bitmap b = BitmapFactory.decodeResource(res,R.drawable.bee);

        canvas.drawBitmap(b,10,10,null);


        //TODO: Add another image to drawable and draw it

    }
}
