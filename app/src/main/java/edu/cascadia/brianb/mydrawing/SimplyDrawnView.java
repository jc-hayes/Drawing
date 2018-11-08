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
    private Paint txtPaint;
    private Paint ovalPaint;
    private float mWidth, mHeight;
    private Paint lnPaint;

    public SimplyDrawnView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        mPaint = new Paint();
        mPath = new Path();
        txtPaint = new Paint();
        ovalPaint = new Paint();
        lnPaint = new Paint();

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
        mPaint.setAlpha(70);
        canvas.drawLine(mWidth, 0, 200, mHeight, mPaint);

        //Draw red line
        mPaint.setAlpha(100);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(16.0f);
        canvas.drawLine(mWidth,mHeight,(mWidth/2),(mHeight/2),mPaint);

        //Draw green lines
        lnPaint.setColor(Color.GREEN);
        lnPaint.setStrokeWidth(35.0f);
        int i = 120;

        for (int n = 5; n > 0; n--) {
            // set transparent pen
            lnPaint.setAlpha(100-(n*10));
            int yCord = ((n-1)*i)+20;
            canvas.drawLine(10,yCord,mWidth,yCord,lnPaint);
        }

        //Draw Text
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(65);
        canvas.drawText("I am a Drawing",10,(mHeight/2),mPaint);

        //Draw Text on a Path
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPath.addCircle((mWidth/2), (mHeight/2), 500, Path.Direction.CW);
        txtPaint.setTextSize(100);
        txtPaint.setAlpha(50);
        canvas.drawTextOnPath("this text is on a circular path, cool", mPath, 0, 0, txtPaint);

        //Draw filled, opaque, and open ovals
        ovalPaint.setColor(Color.BLACK);
        ovalPaint.setStrokeWidth(20.0f);
        ovalPaint.setStyle(Paint.Style.STROKE);
        canvas.drawOval((mWidth/2)-255, (mHeight/2)-255, (mWidth/2)+255, (mHeight/2)+255, ovalPaint);

        ovalPaint.setStyle((Paint.Style.FILL_AND_STROKE));
        ovalPaint.setColor(Color.MAGENTA);
        ovalPaint.setAlpha(50);
        canvas.drawOval((mWidth/2)-250, (mHeight/2)-250, (mWidth/2)+250, (mHeight/2)+250, ovalPaint);

        ovalPaint.setColor(Color.RED);
        ovalPaint.setAlpha(200);
        canvas.drawOval((mWidth/2)-25, (mHeight/2)-25, (mWidth/2)+25, (mHeight/2)+25, ovalPaint);

        //Draw bee bitmap
        Resources res = getResources();
        Bitmap b = BitmapFactory.decodeResource(res,R.drawable.bee);
        canvas.drawBitmap(b,10,10,null);


    }
}
