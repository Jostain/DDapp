package com.example.erik.myapplication;

import java.util.ArrayList;

/**
 * Created by Erik on 2015-09-06.
 */
public class DataHolder {
    private static Character player;
    private static ArrayList<Character> Enemy;

    public static Character getPlayer() {
        return player;
    }

    public static void setPlayer(Character player) {
        DataHolder.player = player;
    }

    public static ArrayList<Character> getEnemy() {
        return Enemy;
    }

    public static void setEnemy(ArrayList<Character> enemy) {
        Enemy = enemy;
    }
}
