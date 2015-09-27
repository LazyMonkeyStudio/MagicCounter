package com.badfish.magiccounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends ActionBarActivity { //test test test
    int[] playerHPs = new int[] {20, 20, 20, 20, 20, 20, 20, 20 };
    int[] commanderHPs = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] poisonDMG = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    int selectedIndex = 0;

    boolean playerSELECTED = true;
    boolean commanderSELECTED = false;
    boolean poisonSELECTED = false;

    Button selectedButton;
    Button previousButton;

    Button selectedPlayer;
    Button previousPlayer;

    Button[] buttonList;

    Button regular;
    Button poison;
    Button commander;
    Button reset;

    Button player1;
    Button player2;
    Button player3;
    Button player4;
    Button player5;
    Button player6;
    Button player7;
    Button player8;

    Button plus1;
    Button plus2;
    Button plus3;
    Button plus4;
    Button plus5;
    Button minus1;
    Button minus2;
    Button minus3;
    Button minus4;
    Button minus5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        onCreate_SetDefaultButtons();
    }

    private void onCreate_SetDefaultButtons()
    {
        player1 = (Button)findViewById(R.id.player1);
        player2 = (Button)findViewById(R.id.player2);
        player3 = (Button)findViewById(R.id.player3);
        player4 = (Button)findViewById(R.id.player4);
        player5 = (Button)findViewById(R.id.player5);
        player6 = (Button)findViewById(R.id.player6);
        player7 = (Button)findViewById(R.id.player7);
        player8 = (Button)findViewById(R.id.player8);

        reset = (Button)findViewById(R.id.reset);
        regular = (Button)findViewById(R.id.regular);
        poison = (Button)findViewById(R.id.poison);
        commander = (Button)findViewById(R.id.commander);
        selectedButton = regular;

        plus1 = (Button)findViewById(R.id.plus1);
        plus2 = (Button)findViewById(R.id.plus2);
        plus3 = (Button)findViewById(R.id.plus3);
        plus4 = (Button)findViewById(R.id.plus4);
        plus5 = (Button)findViewById(R.id.plus5);
        minus1 = (Button)findViewById(R.id.minus1);
        minus2 = (Button)findViewById(R.id.minus2);
        minus3 = (Button)findViewById(R.id.minus3);
        minus4 = (Button)findViewById(R.id.minus4);
        minus5 = (Button)findViewById(R.id.minus5);

        buttonList = new Button[] { player1, player2, player3, player4, player5, player6, player7, player8,
                                    reset, regular, commander, poison,
                                    plus1, plus2, plus3, plus4, plus5,
                                    minus1, minus2, minus3, minus4, minus5};

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

    public void resetHPs(View v)
    {
        playerHPs = new int[] {20, 20, 20, 20, 20, 20, 20, 20, 20, 20 };
        commanderHPs = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        poisonDMG = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        Button[] playerList = new Button[] { player1, player2, player3, player4, player5, player6, player7, player8 };

        for(int i = 0; i < playerList.length; i++)
        {
            playerList[i].setText(String.valueOf(playerHPs[i]));
        }

        playerSELECTED = true;
        poisonSELECTED = false;
        commanderSELECTED = false;

        selectedPlayer = null;
        selectedButton = (Button)findViewById(R.id.regular);

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

        if(selectedPlayer != previousPlayer)
        {
            if(previousPlayer != null)
                previousPlayer.setBackground(getResources().getDrawable(R.drawable.deselected_color));
            if(selectedPlayer != null)
                selectedPlayer.setBackground(getResources().getDrawable(R.drawable.selected_color));

            previousPlayer = selectedPlayer;
        }
    }

    public void selectPlayer1(View v)
    {
        selectedIndex = 0;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer2(View v)
    {
        selectedIndex = 1;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer3(View v)
    {
        selectedIndex = 2;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer4(View v)
    {
        selectedIndex = 3;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer5(View v)
    {
        selectedIndex = 4;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer6(View v)
    {
        selectedIndex = 5;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer7(View v)
    {
        selectedIndex = 6;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void selectPlayer8(View v)
    {
        selectedIndex = 7;
        selectedPlayer = (Button)v;
        redrawButtons();
    }

    public void setSelectedHP(int value)
    {
        if (selectedPlayer != null)
        {
            if (playerSELECTED) {
                playerHPs[selectedIndex] += value;
                selectedPlayer.setText(String.valueOf(playerHPs[selectedIndex]));
            } else if (commanderSELECTED) {
                commanderHPs[selectedIndex] += value;
                selectedPlayer.setText(String.valueOf(commanderHPs[selectedIndex]));
            } else if (poisonSELECTED) {
                poisonDMG[selectedIndex] += value;
                selectedPlayer.setText(String.valueOf(poisonDMG[selectedIndex]));
            }
        }
    }

    private void switchHPs()
    {
        Button[] playerList = new Button[] { player1, player2, player3, player4, player5, player6, player7, player8 };

        for(int i = 0; i < playerList.length; i++)
        {
            if(playerSELECTED)
                playerList[i].setText(String.valueOf(playerHPs[i]));

            if(poisonSELECTED)
                playerList[i].setText(String.valueOf(poisonDMG[i]));

            if(commanderSELECTED)
                playerList[i].setText(String.valueOf(commanderHPs[i]));
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

    public void plus5OnClick(View v)
    {
        setSelectedHP(5);
    }

    public void plus4OnClick(View v)
    {
        setSelectedHP(4);
    }

    public void plus3OnClick(View v)
    {
        setSelectedHP(3);
    }

    public void plus2OnClick(View v)
    {
        setSelectedHP(2);
    }

    public void plus1OnClick(View v)
    {
        setSelectedHP(1);
    }

    public void minus5OnClick(View v)
    {
        setSelectedHP(-5);
    }

    public void minus4OnClick(View v)
    {
        setSelectedHP(-4);
    }

    public void minus3OnClick(View v)
    {
        setSelectedHP(-3);
    }

    public void minus2OnClick(View v)
    {
        setSelectedHP(-2);
    }

    public void minus1OnClick(View v)
    {
        setSelectedHP(-1);
    }
}
