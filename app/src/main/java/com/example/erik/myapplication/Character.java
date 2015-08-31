package com.example.erik.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Erik on 2015-08-27.
 */
public class Character {

    String name;
    Double distance;
    String description;
    String stance;
    BodyPart Soul;

    public Character()
    {

    }

    private class BodyPart {
        BodyPart parent;
        ArrayList<BodyPart> children;
        private HashMap<Integer,Organ> Organs;
        public BodyPart()
        {

        }


    }

    private class Organ {
    }
}
