package com.badfish.magiccounter;

import android.view.View;
import android.widget.Button;

/**
 * Created by Will on 9/17/2015.
 */
public class Player
{
    private Button player_obj;

    public Player()
    { }

    //create button and text field for each player
    public Player(View v)
    {
        player_obj = (Button)v;
    }


}
