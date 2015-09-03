package com.example.erik.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Erik on 2015-07-15.
 */

public class GameBoard extends SurfaceView implements Runnable{
    float offsetX = 0;
    float offsetY = 0;
    //Paint square = new Paint();
    Paint paintOcean = new Paint();
    Rect background = new Rect();

    int width;
    int height;

    ArrayList<Character> characters = new ArrayList<>();

    private float downYValue;

    //surfaceview stuff
    boolean isItOk = false;
    Thread thread = null;
    SurfaceHolder holder;
    public GameBoard(Context context) {
        super(context);

        holder = getHolder();
        background.set(0,0,300,300);
        paintOcean.setColor(Color.RED);
        paintOcean.setStyle(Paint.Style.FILL);
        //square.setARGB(0,0,255,255);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;



    }

    public void addCharacter(Character character)
    {
        characters.add(character);
    }
    public void removeActor(Character character) {
        characters.remove(character);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                float downXValue;
            {
                break;
            }

            case MotionEvent.ACTION_UP: {

            }
            case MotionEvent.ACTION_MOVE: {

                break;

            }

        }
        return true;
    }





    @Override
    public void run() {
        while (isItOk)
        {
            if(!holder.getSurface().isValid())
            {
                continue;
            }
            Canvas canvas = holder.lockCanvas();
            canvas.drawRect(background,paintOcean);
            //canvas.drawRect(background,square);

            for (Character character:characters)
            {

            }
            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause() {
        isItOk = false;
        while (true)
        {
            try{
                thread.join();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }}}}