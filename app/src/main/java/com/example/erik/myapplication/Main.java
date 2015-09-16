package com.example.erik.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;


public class Main extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button searchArea = (Button)findViewById(R.id.searchAreaButton);
        Button towerManager = (Button)findViewById(R.id.manageTowerButton);
        Button inventory = (Button)findViewById(R.id.inventoryButton);
        Button summonGuardian = (Button)findViewById(R.id.summonGuardianButton);
        Button runeBook = (Button)findViewById(R.id.runeBookButton);
        populate();



        searchArea.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        startActivity(new Intent(Main.this,Encounter.class));
                    };
                }
        );

    }

    private void populate() {
        InputStream inputStream = this.getResources().openRawResource(R.raw.human);
        Character character = new Character("Player",inputStream);
        DataHolder.setPlayer(character);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
