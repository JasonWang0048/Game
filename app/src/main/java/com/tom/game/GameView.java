package com.tom.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {

    private float posX, posY = 400;
    private int bitmap_width;
    private int bitmap_height;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Game", "onDraw: " + getWidth() + ", " + getHeight());
        Paint paint = new Paint();
        Paint paint0 = new Paint();
        paint0.setColor(0);
        canvas.drawLine(600, 0, 0, 800, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chicken);
        bitmap_width = bitmap.getWidth();
        bitmap_height = bitmap.getHeight();
//        canvas.drawBitmap(bitmap, 400, 300, paint);
        for (int i = 0; i < getHeight() - bitmap.getHeight(); i += 50) {
            System.out.print(posX);
            canvas.drawBitmap(bitmap, posX, posY, paint);
        }
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        if (posX > 0 && posX < getWidth() - 100) {
            this.posX = posX;
        }
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        if (posY > 0 && posY < getHeight() - 100) {
            this.posY = posY;
        }
    }

    void moveUp(){
        if (posY > 0) {
            posY -= 50;
        } else {
            posY = getHeight() - bitmap_height;
        }
    }

    void moveDown(){
        if (posY < getHeight() - bitmap_height) {
            posY += 50;
        } else {
            posY = 0;
        }
    }

    void moveLeft(){
        if (posX > 0) {
            posX -= 50;
        } else {
            posX = getWidth() - bitmap_width;
        }
    }

    void moveRight(){
        if (posX < getWidth() - bitmap_width) {
            posX += 50;
        } else {
            posX = 0;
        }
    }
}

