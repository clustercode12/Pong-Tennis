package com.anpapps.pongtennis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Andres Navarro on 14/02/2016.
 */
public class PopUpCongratulationLevel extends Activity{

    //Objects
    private TextView txtCongratulation, txtLevel;
    private int btLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_congratulation_level);

        //SharedPreferences
        SharedPreferences sharedPreferencesLoadLevelandLife = PopUpCongratulationLevel.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        btLevel = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.btLevel),  btLevel);

        //Display
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        getWindow().setLayout((int) (windowWidth * .8), (int) (windowHeight * .5));

        //Inicializate
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");
        txtCongratulation = (TextView) findViewById(R.id.txtPopUpCongratulationLevelCongratulation);
        txtCongratulation.setTypeface(font);
        txtLevel = (TextView) findViewById(R.id.txtPopUpCongratulationLevelLevel);
        txtLevel.setTypeface(font);
        txtLevel.setText(getString(R.string.levelCongratulation) + "  " + btLevel + "  " + getString(R.string.txtCongratulationPopUpLevelComplete));
    }
}
