package com.badfish.magiccounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;


public class MainActivity extends ActionBarActivity { //test test test
    //int[] playerHPs = new int[] {20, 20, 20, 20, 20, 20, 20, 20 };
    //int[] commanderHPs = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    //int[] poisonDMG = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    int selectedIndex = 0;
    int amount = 1;

    boolean playerSELECTED = true;
    boolean commanderSELECTED = false;
    boolean poisonSELECTED = false;

    Button selectedButton;
    Button previousButton;

    Button selectedAmount;
    Button previousAmount;

    Button selectedPlayer;

    Button[] buttonList;

    Button regular;
    Button poison;
    Button commander;
    Button reset;

    Button one, two, three, four, five, six, seven, eight, nine, ten;
    EditText player1, player2, player3, player4, player5, player6, player7, player8;
    Button selectedName;

    //Button[] listOfButtons_temp = new Button[8];
    public AbsoluteLayout layout;
    PlayerManager player_manager;

    private enum GAME_STATE
    {
        pause,
        play,
        gameover,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_players);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        onCreate_SetDefaultButtons();
        player_manager = new PlayerManager(this);
        //Player player = new Player(this, new int[] { 25, 50 });
        //player.createPlayer();

        //int count = 0;
        //while (GAME_STATE != GAME_STATE.gameover)
        //{
        //    count += 1;
        //    player1.setText(count);
        //}
    }

    private void findPlayerSetActivityObjects()
    {
        player1 = (EditText)findViewById(R.id.player1_name);
        player2 = (EditText)findViewById(R.id.player2_name);
        player3 = (EditText)findViewById(R.id.player3_name);
        player4 = (EditText)findViewById(R.id.player4_name);
        player5 = (EditText)findViewById(R.id.player5_name);
        player6 = (EditText)findViewById(R.id.player6_name);
        player7 = (EditText)findViewById(R.id.player7_name);
        player8 = (EditText)findViewById(R.id.player8_name);
    }

    private void onCreate_SetDefaultButtons()
    {
        reset = (Button)findViewById(R.id.reset);
        regular = (Button)findViewById(R.id.regular);
        poison = (Button)findViewById(R.id.poison);
        commander = (Button)findViewById(R.id.commander);
        selectedButton = regular;

        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        ten = (Button)findViewById(R.id.ten);
        selectedAmount = one;

        //testing procedurely creating buttons
        //Button test = new Button(this); //new button, this is a widget
        //test.setText("Test");           //sets text, not required
        //test.setX(150);                 //sets x position on screen
        //test.setY(150);                 //sets y position on screen
        //test.setWidth(70);              //sets width of button
        //test.setHeight(35);             //sets height of button
                                        //finds the specific layout to no where to draw the button
        layout = (AbsoluteLayout) findViewById(R.id.absoluteLayout);
        //layout.addView(test);           //adds button to layout

        //endtest

        buttonList = new Button[] {reset, regular, commander, poison,
                                    one, two, three, four, five, six, seven, eight, nine, ten };

        //for(int i = 0; i < buttonList.length; i++)
        for(Button b : buttonList)
        {
            b.setBackground(getResources().getDrawable(R.drawable.deselected_color));
        }

        redrawButtons();
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

    public void OnClick_confirm(View v)
    {
        findPlayerSetActivityObjects();
        player_manager.playerNames[0] = String.valueOf(player1.getText());
        player_manager.playerNames[1] = String.valueOf(player2.getText());
        player_manager.playerNames[2] = String.valueOf(player3.getText());
        player_manager.playerNames[3] = String.valueOf(player4.getText());
        player_manager.playerNames[4] = String.valueOf(player5.getText());
        player_manager.playerNames[5] = String.valueOf(player6.getText());
        player_manager.playerNames[6] = String.valueOf(player7.getText());
        player_manager.playerNames[7] = String.valueOf(player8.getText());
        setContentView(R.layout.activity_main);
        onCreate_SetDefaultButtons();
        player_manager.reLoad();
        selectFirstPlayer();
    }

    private void selectFirstPlayer()
    {
        Random rand = new Random();
        int n = rand.nextInt(8);
        if(player_manager.playerList[n] != null)
        {
            selectedName = player_manager.playerList[n].player_obj;
            selectedName.setBackground(getResources().getDrawable(R.drawable.selected_color));
        }
        else if (player_manager.playerList[0] != null)
            selectFirstPlayer();
    }

    public void resetHPs(View v)
    {
        //playerHPs = new int[] {20, 20, 20, 20, 20, 20, 20, 20, 20, 20 };
        //commanderHPs = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        //poisonDMG = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        //Button[] playerList = new Button[] { player1, player2, player3, player4, player5, player6, player7, player8 };
        //Player[] playerList = player_manager.playerList;

        if(player_manager.playerList != null)
        {
            for (int i = 0; i < player_manager.playerList.length; i++) {
                //playerList[i].setText(String.valueOf(playerHPs[i]));
                if (player_manager.playerList[i] != null)
                //player_manager.playerList[i].player_obj.setText(String.valueOf(playerHPs[i]));
                {
                    //Button player_obj = player_manager.playerList[i].player_obj;
                    Player player = player_manager.playerList[i];
                    player.resetPlayer();
                    //player_obj.setText(player.health);
                }
            }
        }

        playerSELECTED = true;
        poisonSELECTED = false;
        commanderSELECTED = false;

        selectedAmount = one;
        amount = 1;
        selectedButton = regular;

        redrawButtons();
    }

    private void redrawButtons()
    {
        //Button test = (Button)v;

        //test.setBackground(getResources().getDrawable(R.drawable.selected_color));
        if(selectedButton != previousButton)
        {
            if(previousButton != null)
                previousButton.setBackground(getResources().getDrawable(R.drawable.deselected_color));
            if(selectedButton != null)
                selectedButton.setBackground(getResources().getDrawable(R.drawable.selected_color));

            previousButton = selectedButton;
        }

        if(selectedAmount != previousAmount)
        {
            if(previousAmount != null)
                previousAmount.setBackground(getResources().getDrawable(R.drawable.deselected_color));
            if(selectedAmount != null)
                selectedAmount.setBackground(getResources().getDrawable(R.drawable.selected_color));

            previousAmount = selectedAmount;
        }
    }

    public void setSelectedHP(int value)
    {

        //String[] parts = String.valueOf(selectedAmount.getId()).split("_");
        //String currentPlayer = parts[0];

        int ID = selectedPlayer.getId();
        switch(ID)
        {
            /*case R.id.p1_plus:
                selectedIndex = 0;
                selectedPlayer = player1;
                break;

            case R.id.p2_plus:
                selectedIndex = 1;
                selectedPlayer = player2;
                break;

            case R.id.p3_plus:
                selectedIndex = 2;
                selectedPlayer = player3;
                break;

            case R.id.p4_plus:
                selectedIndex = 3;
                selectedPlayer = player4;
                break;

            case R.id.p5_plus:
                selectedIndex = 4;
                selectedPlayer = player5;
                break;

            case R.id.p6_plus:
                selectedIndex = 5;
                selectedPlayer = player6;
                break;

            case R.id.p7_plus:
                selectedIndex = 6;
                selectedPlayer = player7;
                break;

            case R.id.p8_plus:
                selectedIndex = 7;
                selectedPlayer = player8;
                break;

            case R.id.p1_minus:
                selectedIndex = 0;
                selectedPlayer = player1;
                break;

            case R.id.p2_minus:
                selectedIndex = 1;
                selectedPlayer = player2;
                break;

            case R.id.p3_minus:
                selectedIndex = 2;
                selectedPlayer = player3;
                break;

            case R.id.p4_minus:
                selectedIndex = 3;
                selectedPlayer = player4;
                break;

            case R.id.p5_minus:
                selectedIndex = 4;
                selectedPlayer = player5;
                break;

            case R.id.p6_minus:
                selectedIndex = 5;
                selectedPlayer = player6;
                break;

            case R.id.p7_minus:
                selectedIndex = 6;
                selectedPlayer = player7;
                break;

            case R.id.p8_minus:
                selectedIndex = 7;
                selectedPlayer = player8;
                break;*/
        }


        if (selectedPlayer != null)
        {
            if (playerSELECTED) {
                //playerHPs[selectedIndex] += value;
                //selectedPlayer.setText(String.valueOf(playerHPs[selectedIndex]));
            } else if (commanderSELECTED) {
                //commanderHPs[selectedIndex] += value;
                //selectedPlayer.setText(String.valueOf(commanderHPs[selectedIndex]));
            } else if (poisonSELECTED) {
                //poisonDMG[selectedIndex] += value;
                //selectedPlayer.setText(String.valueOf(poisonDMG[selectedIndex]));
            }
        }
    }

    private void switchHPs()
    {
        //Button[] playerList = new Button[] { player1, player2, player3, player4, player5, player6, player7, player8 };

        if(player_manager.playerList != null)
        {
            for(int i = 0; i < player_manager.playerList.length; i++)
            {
                if (player_manager.playerList[i] != null)
                {
                    Player player = player_manager.playerList[i];
                    if (playerSELECTED)
                        player_manager.playerList[i].player_obj.setText(String.valueOf(player.health));

                    if (poisonSELECTED)
                        player_manager.playerList[i].player_obj.setText(String.valueOf(player.infect));

                    if (commanderSELECTED)
                        player_manager.playerList[i].player_obj.setText(String.valueOf(player.commander));
                }
            }
        }
    }

    public void clickReg(View v)
    {
        selectedButton = (Button)v;
        playerSELECTED = true;
        poisonSELECTED = false;
        commanderSELECTED = false;

        switchHPs();
        redrawButtons();
    }

    public void clickPois(View v)
    {
        selectedButton = (Button)v;
        playerSELECTED = false;
        poisonSELECTED = true;
        commanderSELECTED = false;

        switchHPs();
        redrawButtons();
    }

    public void clickCommnd(View v)
    {
        selectedButton = (Button)v;
        playerSELECTED = false;
        poisonSELECTED = false;
        commanderSELECTED = true;

        switchHPs();
        redrawButtons();
    }

    public void selectPlus(View v)
    {
        selectedPlayer = (Button)v;
        setSelectedHP(amount);
    }

    public void selectMinus(View v)
    {
        selectedPlayer = (Button)v;
        setSelectedHP(-amount);
    }

    public void selectAmount(View v)
    {
        Button temp = (Button)v;
        amount = Integer.parseInt(temp.getText().toString());
        selectedAmount = temp;
        redrawButtons();
    }
}
