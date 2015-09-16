package com.example.erik.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.Switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Erik on 2015-08-27.
 */
public class Character {

    public static int windowHeight = 1280;
    public static int windowWidth = 768;
    private static final String TAG = "Character";


    private String name;
    private Double distance;
    private String description;
    private String stance;
    private Bodypart soul = new Bodypart("Soul");
    HashMap<String,Bodypart> partList = new HashMap<>();
    private Bitmap cardback;
    public Character(String name, InputStream stream)
    {
        partList.put("Soul",soul);
        growBody(stream);
        soul.addTag(Tag.ETHERAL);
        int width = (int)(windowWidth/3.5);
        int height = (int)((windowHeight/3.5));
        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        Bitmap bmp = Bitmap.createBitmap(width, height, conf); // this creates a MUTABLE bitmap
        Canvas canvas = new Canvas(bmp);
        canvas.drawARGB(255, 0, 0, 0);
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 2, height / 2, (width / 2) - width / 10, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, width-1, height-1, paint);
        cardback = bmp;

    }
    public Bitmap getCardBack()
    {return cardback;}

    private void growBody(InputStream stream) {
        Log.v(TAG, "Trying to grow Body!!!!!!!!!!!!!!!!!!!!");
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        try {
            Bodypart bodypart = null;
            Organ organ = null;
            String line = "";
            while ((line = br.readLine()) != null) {
                Log.v(TAG, line);
                List<String> items = Arrays.asList(line.split("\\s*:\\s*"));
                switch(items.get(0))
                {
                    case "Bodypart":
                        bodypart = new Bodypart(items.get(1));
                        partList.put(items.get(1),bodypart);
                        partList.get(items.get(2)).growBodyPart(bodypart);
                        Log.v(TAG, "grew bodypart!!!!!!!!!!!!!!!!!!!!!");
                    break;
                    case "Organ":
                        organ = new Organ(items.get(1), items.get(2));
                        bodypart.addOrgan(organ);
                        Log.v(TAG, "grew organ!!!!!!!!!!!!!!!!!!!!!");
                    break;
                    case "Cover":
                        Organ tempOrgan = new Organ(items.get(1),items.get(2));
                        organ.cover(tempOrgan);
                        organ = tempOrgan;
                        Log.v(TAG, "grew tissue!!!!!!!!!!!!!!!!!!!!!");
                        break;

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Bodypart {

        String name;
        Bodypart parent;
        ArrayList<Material> layers = new ArrayList<>();
        ArrayList<Bodypart> children = new ArrayList<>();
        ArrayList<Tag> tags = new ArrayList<>();
        ArrayList<Organ> organs;
        public Bodypart(String name)
        {
            this.name = name;
        }
        public void growBodyPart(Bodypart bodypart)
        {
            children.add(bodypart);
            bodypart.parent = this;
        }
        public ArrayList<String> listAllConnectedParts() {
            ArrayList<String> list = new ArrayList<>();
            list.add(name);
            for (Bodypart bp : children) {
                list.addAll(bp.listAllConnectedParts());
            }
            return list;
        }
        public void addTag(Tag tag)
        {
            tags.add(tag);
        }
        public void sever()
        {
            tags.add(Tag.SEVERED);
            for (Bodypart bp:children) {bp.sever();}

        }


        public void addOrgan(Organ organ) {
        }
    }

    private class Organ {
        ArrayList<Wound> wounds= new ArrayList<>();
        Organ covering;
        Organ coveredBy;
        String mat;
        public Organ(String name, String mat)
        {}
        public void cover(Organ cover)
        {}
    }
    private class Wound
    {

    }
}
