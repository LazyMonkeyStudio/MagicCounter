package com.badfish.magiccounter;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.View;
import android.widget.Button;

/**
 * Created by Will on 9/30/2015.
 */
public class PlayerManager
{
    //intialize variables
    MainActivity activity;
    int[] pos;
    int[] size;
    Button createPlayer;

    //Player variables
    int maxPlayers;
    int playerCount;
    Player[] playerList;
    int[] playerStartSpawnPos;

    public PlayerManager(MainActivity activity)
    {
        //set intialized variables on manager construction
        this.activity = activity;
        pos = new int[] { 215, 460 };
        size = new int[] { 400, 35 };
        intializeButton();

        maxPlayers = 8;
        playerCount = 0;
        playerList = new Player[maxPlayers];
        playerStartSpawnPos = new int[] { 100, 100 };

    }

    private void OnClick(View v)
    {
        if(playerCount < 8)
        {
            Player player = new Player(activity, spawnPosition());
            playerList[playerCount] = player;
            playerCount++;
        }
    }

    private void intializeButton()
    {
        createPlayer = new Button(activity);
        createPlayer.setText("New Player");
        createPlayer.setX(pos[0]);
        createPlayer.setY(pos[1]);
        createPlayer.setWidth(size[0]);
        createPlayer.setHeight(size[1]);

        createPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });

        activity.layout.addView(createPlayer);
    }

    private int[] spawnPosition()
    {
        int spawnMargin = 50;

        if(playerList[0] != null)
        {
            Player previousPlayer = playerList[playerCount-1];
            int[] spawnPos = new int[] { previousPlayer.posX + previousPlayer.width + spawnMargin, previousPlayer.posY };
            return  spawnPos;
        }

        return  playerStartSpawnPos;
    }
}
