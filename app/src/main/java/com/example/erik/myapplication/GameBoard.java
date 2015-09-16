package com.example.erik.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Erik on 2015-07-15.
 */

public class GameBoard extends View{
    ArrayList<Character> characters = new ArrayList<>();
    int width;
    int height;
    Character enemyOne;
    Character enemyTwo;
    Character enemyThree;
    int cardWidth;
    int cardHeight;
    int cardSpacing;
    Context context;

    public GameBoard(Context context) {
        super(context);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        this.context = context;
        InputStream inputStream = this.getResources().openRawResource(R.raw.human);
        enemyOne = new Character("One",inputStream);
        enemyTwo = new Character("Two",inputStream);
        enemyThree = new Character("Three",inputStream);
        cardWidth = (int)(width/3.5);
        cardHeight = (int)(height/3.5);
        cardSpacing = (int)((width-(width/3.5)-(width/3.5)-(width/3.5)))/4;

    }

    public void addCharacter(Character character)
    {
        characters.add(character);
    }
    public void removeActor(Character character) {
        characters.remove(character);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int cardWidth = (int)(width/3.5);
        int cardHeight = (int)(height/3.5);
        int cardSpacing = (int)((width-(width/3.5)-(width/3.5)-(width/3.5)))/4;

        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.DKGRAY);
        Paint cardColor = new Paint();

        Rect rect = new Rect();
        rect.set(0, 0, width, height);
        Rect card = new Rect();


        canvas.drawARGB(255, 0, 0, 0);
        canvas.drawRect(rect, paint);
        cardColor.setColor(Color.WHITE);
        card.set(cardSpacing, cardSpacing, cardWidth + cardSpacing, cardHeight + cardSpacing * 2);
        canvas.drawRect(card, cardColor);


        cardColor.setColor(Color.WHITE);
        card.set(cardWidth + cardSpacing * 2, cardSpacing, cardWidth * 2 + cardSpacing * 2, cardHeight + cardSpacing * 2);
        canvas.drawRect(card, cardColor);


        cardColor.setColor(Color.WHITE);
        card.set(cardWidth * 2 + (cardSpacing * 3), cardSpacing, (cardWidth * 3) + cardSpacing * 3, cardHeight + cardSpacing * 2);
        canvas.drawRect(card, cardColor);
        //
        cardColor.setColor(Color.WHITE);
        card.set(cardSpacing, cardHeight + cardSpacing * 8, cardWidth + cardSpacing, cardHeight + cardHeight + cardSpacing * 4);
        canvas.drawRect(card, cardColor);

        cardColor.setColor(Color.WHITE);
        card.set(cardWidth + cardSpacing * 2, cardHeight + cardSpacing * 8, (cardWidth + cardSpacing) * 3, height-cardSpacing*3);
        canvas.drawRect(card, cardColor);

        canvas.drawBitmap(enemyOne.getCardBack(), cardSpacing, cardSpacing, new Paint());
        canvas.drawBitmap(enemyTwo.getCardBack(), cardWidth + cardSpacing * 2, cardSpacing, new Paint());
        canvas.drawBitmap(enemyThree.getCardBack(), cardWidth*2 + (cardSpacing * 3), cardSpacing, new Paint());
        canvas.drawBitmap(DataHolder.getPlayer().getCardBack(),cardSpacing,cardHeight + cardSpacing * 8,new Paint());



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

            {
                float x = event.getX();
                float y = event.getY();
                if(y>cardSpacing && y<(cardHeight+cardSpacing*2) && x>cardSpacing && x < cardWidth + cardSpacing)
                {
                    Intent i = new Intent(context, Character_Sheet.class);
                    context.startActivity(i);
                }
                else if(y>cardSpacing && y<(cardHeight+cardSpacing*2) && x > cardWidth + cardSpacing * 2 && x<cardWidth * 2 + cardSpacing * 2)
                {
                    Intent i = new Intent(context, Character_Sheet.class);
                    context.startActivity(i);
                }
                else if(y>cardSpacing && y<(cardHeight+cardSpacing*2) && x > cardWidth * 2 + (cardSpacing * 3) && x<(cardWidth * 3) + cardSpacing * 3)
                {
                    Intent i = new Intent(context, Character_Sheet.class);
                    context.startActivity(i);
                }
                else if(y>(cardHeight + cardSpacing * 8) && y < cardHeight + cardHeight + cardSpacing * 9 && x > cardSpacing && x < (cardWidth + cardSpacing))
                {
                    Intent i = new Intent(context, Character_Sheet.class);
                    context.startActivity(i);
                }
                break;
            }

            case MotionEvent.ACTION_UP: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {

                break;

            }

        }
        return true;
    }





  }