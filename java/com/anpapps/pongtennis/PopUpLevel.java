package com.anpapps.pongtennis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Andres Navarro on 06/02/2016.
 */
public class PopUpLevel extends Activity {

    private Button btStart;
    private TextView txtLevel, txtTypeLevel;
    private ImageView ibtInfo, ivTick, ivGift;

    private int level;
    private int conseguido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_level);

        //Display
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        getWindow().setLayout((int)(windowWidth*.9), (int)(windowHeight*.4));

        //SharedPreferencesLoadBtLevel
        SharedPreferences sharedPreferencesLoadBtLevel = PopUpLevel.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadBtLevel.getInt(getString(R.string.btLevel), 1);
        conseguido = sharedPreferencesLoadBtLevel.getInt(getString(R.string.conseguido), 0);

        //Txt2
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");
        txtLevel = (TextView) findViewById(R.id.txtLevelPopUp);
        txtLevel.setTypeface(font);
        txtLevel.setText(getString(R.string.txtLevelSplashScreen) + " " + level);
        txtTypeLevel = (TextView) findViewById(R.id.txtTypeLevelPopUp);
        txtTypeLevel.setTypeface(font);
        if (level == 2 ||level == 5 || level == 7 || level == 10 || level == 12 || level == 18 || level == 19 || level == 23 || level == 28 || level == 31 || level == 40 || level == 51) {
            txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
        } else if (level == 8 || level == 14 || level == 17 || level == 21 || level == 27 || level == 29 || level == 33 || level == 39 || level == 44 || level == 52) {
            txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
        } else if (level == 15 || level == 25 || level == 35 || level == 45 || level == 55) {
            txtTypeLevel.setText(getString(R.string.txtTypeKingLevel));
        } else if (level == 16 || level == 20 || level == 24 || level == 30 || level == 36 || level == 43 || level == 46 || level == 53) {
            txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
        } else if (level == 37 || level == 38 || level == 41 || level == 47 || level == 48) {
            txtTypeLevel.setText(getString(R.string.txtTypeBombGyroLevel));
        } else if (level == 50 || level == 54) {
            txtTypeLevel.setText(getString(R.string.txtTypeTeleBoomLevel));
        } else {
            txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
        }

        //Buttons
        btStart = (Button) findViewById(R.id.btStartPopUp);
        btStart.setTypeface(font);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 2 ||level == 5 || level == 7 || level == 10 || level == 12 || level == 18 || level == 19 || level == 23 || level == 28 || level == 31 ||level == 40 ||level == 51) {
                    Intent intent = new Intent(PopUpLevel.this, GameBoom.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                } else if (level == 8 || level == 14 || level == 17 || level == 21 || level == 27 || level == 29 || level == 33 || level == 39 || level == 44 || level == 52){
                    Intent intent = new Intent(PopUpLevel.this, GameGyroscope.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                } else if (level == 15 || level == 25 || level == 35 || level == 45 || level == 55){
                    Intent intent = new Intent(PopUpLevel.this, GameKings.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                } else if (level == 16 || level == 20 || level == 24 || level == 30 ||level == 36 || level == 43 || level == 46 || level == 53){
                    Intent intent = new Intent(PopUpLevel.this, GameTeleportation.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                } else if (level == 37 || level == 38 || level == 41 || level == 47 || level == 48){
                    Intent intent = new Intent(PopUpLevel.this, GameBoomGyro.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                } else if (level == 50 || level == 54){
                    Intent intent = new Intent(PopUpLevel.this, GameTeleBoom.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(PopUpLevel.this, GameNormal.class);
                    intent.putExtra("level", level);
                    startActivity(intent);
                }
            }
        });
        ibtInfo = (ImageButton) findViewById(R.id.ibtInfoPopUp);
        ibtInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopUpLevel.this, PopUpInfoLevel.class);
                intent.putExtra("level", level);
                startActivity(intent);
            }
        });
        //ImageViews
        ivTick = (ImageView) findViewById(R.id.ivTick);
        if (level == 1 && conseguido >= 1) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 2 && conseguido >= 2) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 3 && conseguido >= 3) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 4 && conseguido >= 4) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 5 && conseguido >= 5) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 6 && conseguido >= 6) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 7 && conseguido >= 7) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 8 && conseguido >= 8) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 9 && conseguido >= 9) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 10 && conseguido >= 10) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 11 && conseguido >= 11) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 12 && conseguido >= 12) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 13 && conseguido >= 13) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 14 && conseguido >= 14) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 15 && conseguido >= 15) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 16 && conseguido >= 16) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 17 && conseguido >= 17) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 18 && conseguido >= 18) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 19 && conseguido >= 19) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 20 && conseguido >= 20) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 21 && conseguido >= 21) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 22 && conseguido >= 22) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 23 && conseguido >= 23) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 24 && conseguido >= 24) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 25 && conseguido >= 25) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 26 && conseguido >= 26) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 27 && conseguido >= 27) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 28 && conseguido >= 28) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 29 && conseguido >= 29) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 30 && conseguido >= 30) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 31 && conseguido >= 31) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 32 && conseguido >= 32) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 33 && conseguido >= 33) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 34 && conseguido >= 34) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 35 && conseguido >= 35) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 36 && conseguido >= 36) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 37 && conseguido >= 37) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 38 && conseguido >= 38) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 39 && conseguido >= 39) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 40 && conseguido >= 40) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 41 && conseguido >= 41) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 42 && conseguido >= 42) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 43 && conseguido >= 43) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 44 && conseguido >= 44) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 45 && conseguido >= 45) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 46 && conseguido >= 46) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 47 && conseguido >= 47) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 48 && conseguido >= 48) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 49 && conseguido >= 49) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 50 && conseguido >= 50) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 51 && conseguido >= 51) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 52 && conseguido >= 52) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 53 && conseguido >= 53) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 54 && conseguido >= 54) {
            ivTick.setVisibility(View.VISIBLE);
        } else if (level == 55 && conseguido >= 55) {
            ivTick.setVisibility(View.VISIBLE);
        } else {
            ivTick.setVisibility(View.INVISIBLE);
        }

        ivGift = (ImageView) findViewById(R.id.ivGift);
        switch (level) {
            case 1:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 3:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 4:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 6:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 7:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 8:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 9:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 11:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 12:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 13:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 14:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 16:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 18:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 19:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 21:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 22:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 23:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 24:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 26:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 27:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 28:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 29:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 31:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 32:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 33:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 34:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 36:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 38:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 39:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 41:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 42:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 43:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 44:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 46:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 47:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 48:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 49:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 51:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 52:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 53:
                ivGift.setVisibility(View.INVISIBLE);
                break;
            case 54:
                ivGift.setVisibility(View.INVISIBLE);
                break;
        }

        //Replay
        Intent getReplayPopUp = getIntent();
        boolean replay = getReplayPopUp.getBooleanExtra("replay", false);
        if (replay) {
            btStart.setText(R.string.txtReplayPopUp);
        }
    }
}
