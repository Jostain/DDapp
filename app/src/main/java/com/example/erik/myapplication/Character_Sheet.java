package com.example.erik.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Character_Sheet extends Activity {
    String[] dummyDataWeapon = {"Sword","Shield","Left Foot","Shoulder","head","teeth"};
    TextView information;
    Button description;
    Button injuries ;
    Button equipment;
    Button stance;
    Button attack;
    Button skill;
    int actionPoint = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
        description = (Button)findViewById(R.id.descriptionButton);
        injuries = (Button)findViewById(R.id.injuriesButton);
        equipment = (Button)findViewById(R.id.equipmentButton);
        stance = (Button)findViewById(R.id.stanceButton);
        attack = (Button)findViewById(R.id.attackButton);
        skill = (Button)findViewById(R.id.skillButton);
        information = (TextView)findViewById(R.id.informationView);


        description.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        information.setText("Description!!!");
                    };
                }
        );

        injuries.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        information.setText("Creature is Uninjured");
                    };
                }
        );
        equipment.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        information.setText("Creature have no Equipment");
                    };
                }
        );
        stance.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        information.setText("Stable but aggressive");
                    };
                }
        );
        attack.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v)
                    {
                        Intent i = new Intent(Character_Sheet.this, Attack_Creation.class);
                        Bundle b = new Bundle();
                        b.putInt("AP", actionPoint); //Your id
                        i.putExtras(b); //Put your id to your next Intent
                        startActivityForResult(i, 1);
                    };
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_encounter, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
