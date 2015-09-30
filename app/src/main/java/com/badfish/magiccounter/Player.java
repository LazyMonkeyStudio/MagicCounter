package com.badfish.magiccounter;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Will on 9/17/2015.
 */
public class Player
{
    MainActivity activity;
    Button player_obj;
    EditText player_name;
    private Button plus;
    private Button minus;

    int health;
    int infect;
    int commander;

    int posX;
    int posY;
    int width;
    int height;

    public Player(MainActivity activity, int[] posXY)
    {
        this.activity = activity;
        health = 20;
        infect = 0;
        commander = 0;
        posX = posXY[0];
        posY = posXY[1];
        width = 200;
        height = 1;
        createPlayer();
    }

    private void createPlayer()
    {
        player_obj = new Button(activity);
        player_obj.setText("20");

        player_obj.setX(posX);
        player_obj.setY(posY);
        player_obj.setWidth(width);
        player_obj.setHeight(height);
        activity.layout.addView(player_obj);
    }
}
