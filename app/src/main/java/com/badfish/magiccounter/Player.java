package com.badfish.magiccounter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    String name;
    int health;
    int infect;
    int commander;

    int posX;
    int posY;
    int width;
    int height;

    int plusMinusWidth;
    int plusMinusHeight;

    public Player(MainActivity activity, int[] posXY)
    {
        this.activity = activity;
        name = "DEFAULT";
        health = 20;
        infect = 0;
        commander = 0;
        posX = posXY[0];
        posY = posXY[1];
        width = 75;
        height = 35;
        plusMinusWidth = 35;
        plusMinusHeight = 35;
    }

    public void resetPlayer()
    {
        health = 20;
        infect = 0;
        commander = 0;
        player_obj.setText(String.valueOf(health));
    }

    public void createPlayer()
    {
        player_obj = new Button(activity);
        player_obj.setText(String.valueOf(health));
        player_obj.setTextSize(28);

        player_obj.setX((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, posX, activity.getResources().getDisplayMetrics()));
        player_obj.setY((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, posY, activity.getResources().getDisplayMetrics()));
        //player_obj.setWidth((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, activity.getResources().getDisplayMetrics()));
        //player_obj.setHeight((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, activity.getResources().getDisplayMetrics()));
        player_obj.setBackground(activity.getResources().getDrawable(R.drawable.deselected_color));
        //player_obj.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        OnClick(v);
        //    }
        //});

        TextView player_name = new TextView(activity);
        player_name.setText(name);
        player_name.setTextAppearance(activity, R.style.TextAppearance_AppCompat_Medium);
        player_name.setX(player_obj.getX() /*+ 60*/);
        player_name.setY(player_obj.getY() - 70);

        activity.layout.addView(player_obj, 210, 150);
        activity.layout.addView(player_name, 300, 300);
        createPlus();
        createMinus();
    }

    private void createPlus()
    {
        plus = new Button(activity);
        plus.setText("+");
        //plus.setX(player_obj.getX() + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, activity.getResources().getDisplayMetrics()));
        plus.setX(player_obj.getX() + 105);
        plus.setY(player_obj.getY() + 150);
        //plus.setY(player_obj.getY() + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, activity.getResources().getDisplayMetrics()));
        //plus.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, plusMinusWidth, activity.getResources().getDisplayMetrics()));
        //plus.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, plusMinusHeight, activity.getResources().getDisplayMetrics()));
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickPlus(v);
            }
        });
        plus.setBackground(activity.getResources().getDrawable(R.drawable.plus_button));
        activity.layout.addView(plus, 105, 80);
    }

    private void createMinus()
    {
        minus = new Button(activity);
        minus.setText("-");
        minus.setX(player_obj.getX());
        minus.setY(player_obj.getY() + 150);
        //minus.setY(player_obj.getY() + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, activity.getResources().getDisplayMetrics()));
        //minus.setWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, plusMinusWidth, activity.getResources().getDisplayMetrics()));
        //minus.setHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, plusMinusHeight, activity.getResources().getDisplayMetrics()));
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickMinus(v);
            }
        });

        /*ViewGroup.LayoutParams params = minus.getLayoutParams();
        params.height = 35;
        params.width = 35;
        minus.setLayoutParams(params);*/

        minus.setBackground(activity.getResources().getDrawable(R.drawable.minus_button));
        activity.layout.addView(minus, 105, 80);
    }

    private void OnClick(View v)
    {
        player_obj.setX(player_obj.getX() + 10);
        player_obj.setY(player_obj.getY() + 10);
        //activity.layout.addView(player_obj);
    }

    private void OnClickPlus(View v)
    {
        handleHPs(activity.amount);
    }

    private void OnClickMinus(View v)
    {
        handleHPs(-activity.amount);
    }

    private void handleHPs(int amount)
    {
        if(activity.playerSELECTED)
        {
            health = health + amount;
            player_obj.setText(String.valueOf(health));
        }
        else if(activity.poisonSELECTED)
        {
            infect = infect + amount;
            player_obj.setText(String.valueOf(infect));
        }
        else if(activity.commanderSELECTED)
        {
            commander = commander + amount;
            player_obj.setText(String.valueOf(commander));
        }
    }
}
