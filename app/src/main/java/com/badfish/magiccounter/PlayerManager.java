package com.badfish.magiccounter;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Will on 9/30/2015.
 */
public class PlayerManager
{
    //intialize variables
    MainActivity activity;
    int[] pos;
    //int[] size;
    Button createPlayer;

    //Player variables
    int maxPlayers;
    int playerCount;
    Player[] playerList;
    int[] playerStartSpawnPos;
    int currentRow;
    int currentColumn;

    String[] playerNames;

    public PlayerManager(Activity activity)
    {
        this.activity = (MainActivity)activity;
        //set intialized variables on manager construction
        pos = new int[] { 250, 1350 };
        //size = new int[] { 400, 35 };
        intializeButton();

        playerNames = new String[8];
    }

    private void OnClick(View v)
    {
        /*if(playerCount < 8)
        {
            Player player = new Player(activity, spawnPosition());
            playerList[playerCount] = player;
            playerCount++;
        }*/
        activity.setContentView(R.layout.activity_player_set);
        EditText player1 = (EditText)activity.findViewById(R.id.player1_name);
        player1.setText(playerNames[0]);
        EditText player2 = (EditText)activity.findViewById(R.id.player2_name);
        player2.setText(playerNames[1]);
        EditText player3 = (EditText)activity.findViewById(R.id.player3_name);
        player3.setText(playerNames[2]);
        EditText player4 = (EditText)activity.findViewById(R.id.player4_name);
        player4.setText(playerNames[3]);
        EditText player5 = (EditText)activity.findViewById(R.id.player5_name);
        player5.setText(playerNames[4]);
        EditText player6 = (EditText)activity.findViewById(R.id.player6_name);
        player6.setText(playerNames[5]);
        EditText player7 = (EditText)activity.findViewById(R.id.player7_name);
        player7.setText(playerNames[6]);
        EditText player8 = (EditText)activity.findViewById(R.id.player8_name);
        player8.setText(playerNames[7]);
    }

    private void intializeButton()
    {
        createPlayer = new Button(activity);
        createPlayer.setText("New Players");
        createPlayer.setX(pos[0]);
        createPlayer.setY(pos[1]);
        //createPlayer.setWidth(size[0]);
        //createPlayer.setHeight(size[1]);
        createPlayer.setBackground(activity.getResources().getDrawable(R.drawable.deselected_color));
        createPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });

        activity.layout.addView(createPlayer, 350, 120);
    }

    public void reLoad()
    {
        this.activity = (MainActivity)activity;
        //set intialized variables on manager construction
        pos = new int[] { 250, 1350 };
        //size = new int[] { 400, 35 };
        intializeButton();

        maxPlayers = 8;
        playerCount = 0;
        playerList = new Player[maxPlayers];
        playerStartSpawnPos = new int[] { 25, 50 };
        currentRow = 0;
        currentColumn = 1;

        createEachPlayer();
    }

    private void createEachPlayer()
    {
        for(String currName: playerNames)
        {
            if (!currName.isEmpty())
            {
                Player player = new Player(activity, spawnPosition());
                player.name = currName;
                player.createPlayer();
                playerList[playerCount] = player;
                playerCount++;
            }
        }
    }

    private int[] spawnPosition() {
        if (playerList[3] != null)
        {
            int tom = 0;
            playerList[3].player_obj.getX();
            playerList[3].player_obj.getY();

        }
            int spawnMarginX = 0;
        int spawnMarginY = 0;
        if (playerList[0] != null) {
            spawnMarginX = 95;
            if (playerList[1] == null)
                spawnMarginY = 0;
            else
                spawnMarginY = 110;
        }

        if (currentColumn == 1)
            spawnMarginX = 0;

        //if(playerList[0] != null)
        //{
        //Player previousPlayer = playerList[playerCount-1];

        //player 1 at pos 50x50
        //player 2 at pos 100x50
        //player 3 at pos 50x100
        //player 4 at pos 100x100
        //player 5 at pos 50x150
        //player 6 at pos 100x150
        //player 7 at pos 50x200
        //player 8 at pos 100x200
        //each button is 50 wide and 50 high

        //rowCount = playerList.length/playersPerRow; //amount of players divided by players per row
        //columnCount = playerList.length/playersPerColumn;
        //spawnPos = new int[] { previousPlayer.posX + previousPlayer.width + spawnMarginX, previousPlayer.posY * rowCount + spawnMarginY };

        int[] spawnPos = new int[]{(playerStartSpawnPos[0] * currentColumn) + spawnMarginX, (playerStartSpawnPos[1] + (spawnMarginY * currentRow))};
        if (currentColumn == 2) {
            currentColumn = 1;
            currentRow++;
        } else {
            currentColumn = 2;
        }
        return spawnPos;
        //25x50
        //90x50
        //25x175
        //90x175
        //25x300
        //90x300
        //25x425
        //90x425
    }
}
