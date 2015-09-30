package com.badfish.magiccounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;


public class MainActivity extends ActionBarActivity { //test test test
    int[] playerHPs = new int[] {20, 20, 20, 20, 20, 20, 20, 20 };
    int[] commanderHPs = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] poisonDMG = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
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
    Button player1, player2, player3, player4, player5, player6, player7, player8;
    Button p1_minus, p2_minus, p3_minus, p4_minus, p5_minus, p6_minus, p7_minus, p8_minus;
    Button p1_plus, p2_plus, p3_plus, p4_plus, p5_plus, p6_plus, p7_plus, p8_plus;

    //Button[] listOfButtons_temp = new Button[8];
    public AbsoluteLayout layout;
    PlayerManager player_manager;

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

        p1_plus = (Button)findViewById(R.id.p1_plus);
        p2_plus = (Button)findViewById(R.id.p2_plus);
        p3_plus = (Button)findViewById(R.id.p3_plus);
        p4_plus = (Button)findViewById(R.id.p4_plus);
        p5_plus = (Button)findViewById(R.id.p5_plus);
        p6_plus = (Button)findViewById(R.id.p6_plus);
        p7_plus = (Button)findViewById(R.id.p7_plus);
        p8_plus = (Button)findViewById(R.id.p8_plus);
        p1_minus = (Button)findViewById(R.id.p1_minus);
        p2_minus = (Button)findViewById(R.id.p2_minus);
        p3_minus = (Button)findViewById(R.id.p3_minus);
        p4_minus = (Button)findViewById(R.id.p4_minus);
        p5_minus = (Button)findViewById(R.id.p5_minus);
        p6_minus = (Button)findViewById(R.id.p6_minus);
        p7_minus = (Button)findViewById(R.id.p7_minus);
        p8_minus = (Button)findViewById(R.id.p8_minus);

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

        //player_manager = new PlayerManager(this);
        //endtest

        buttonList = new Button[] { player1, player2, player3, player4, player5, player6, player7, player8,
                                    reset, regular, commander, poison,
                                    one, two, three, four, five, six, seven, eight, nine, ten,
                                    p1_plus, p2_plus, p3_plus, p4_plus, p5_plus, p6_plus, p7_plus, p8_plus,
                                    p1_minus, p2_minus, p3_minus, p4_minus, p5_minus, p6_minus, p7_minus, p8_minus };

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

        selectedAmount = null;
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
            case R.id.p1_plus:
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
                break;
        }


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

    public void selectOne(View v)
    {
        amount = 1;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectTwo(View v)
    {
        amount = 2;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectThree(View v)
    {
        amount = 3;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectFour(View v)
    {
        amount = 4;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectFive(View v)
    {
        amount = 5;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectSix(View v)
    {
        amount = 6;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectSeven(View v)
    {
        amount = 7;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectEight(View v)
    {
        amount = 8;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectNine(View v)
    {
        amount = 9;
        selectedAmount = (Button)v;
        redrawButtons();
    }

    public void selectTen(View v)
    {
        amount = 10;
        selectedAmount = (Button)v;
        redrawButtons();
    }
}
