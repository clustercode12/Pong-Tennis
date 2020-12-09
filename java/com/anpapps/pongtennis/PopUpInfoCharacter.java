package com.anpapps.pongtennis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Andres Navarro on 26/02/2016.
 */
public class PopUpInfoCharacter extends Activity {

    private TextView txtBallType, txtLevelUnlock;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_character);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        getWindow().setLayout((int) (windowWidth * .95), (int) (windowHeight * .6));

        //Inicilizate
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/main_font.ttf");
        txtBallType = (TextView) findViewById(R.id.txtBallType);
        txtBallType.setTypeface(font);
        txtLevelUnlock = (TextView) findViewById(R.id.txtLevelUnlock);
        txtLevelUnlock.setTypeface(font);

        Intent getCharacter = getIntent();
        int character = getCharacter.getIntExtra("character", 2);
        switch (character) {
            case 2:
                txtBallType.setText(getString(R.string.ballTypeBallClassic) + "\n" + getString(R.string.ballTypeGreen));
                break;
            case 3:
                txtBallType.setText(getString(R.string.ballTypeBallClassic) + "\n" + getString(R.string.ballTypePink));
                break;
            case 4:
                txtBallType.setText(getString(R.string.ballTypeBallClassic) + "\n" + getString(R.string.ballTypeAmbar));
                break;
            case 5:
                txtBallType.setText(getString(R.string.ballGuard));
                break;
            case 6:
                txtBallType.setText(getString(R.string.ballTypeBallClassic) + "\n" + getString(R.string.ballTypeRed));
                break;
            case 7:
                txtBallType.setText(getString(R.string.ballTypeRainbow) + "\n" + getString(R.string.ballTypeRainbow2));
                break;
            case 8:
                txtBallType.setText(getString(R.string.ballTypeGuardOf) + "\n" + getString(R.string.ballTypeFire));
                break;
            case 9:
                txtBallType.setText(getString(R.string.ballTypeVampire) + "\n" + getString(R.string.ballTypeVampire2));
                break;
            case 10:
                txtBallType.setText(getString(R.string.ballTypeGodHades));
                break;
            case 11:
                txtBallType.setText(getString(R.string.ballTypeBallClassic) + "\n" + getString(R.string.ballTypeBlue));
                break;
            case 12:
                txtBallType.setText(getString(R.string.ballWorld));
                break;
            case 13:
                txtBallType.setText(getString(R.string.ballTypeGuardOf) + "\n" + getString(R.string.ballTypeWater));
                break;
            case 14:
                txtBallType.setText(getString(R.string.ballIce));
                break;
            case 15:
                txtBallType.setText(getString(R.string.ballGodPoseidon));
                break;

        }
    }
}
