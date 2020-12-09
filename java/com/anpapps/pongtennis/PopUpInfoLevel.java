package com.anpapps.pongtennis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Andres Navarro on 08/02/2016.
 */

public class PopUpInfoLevel extends Activity {

    private TextView txtGoal, txtTypeLevel, txtLevel;
    private ImageView ivInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_level);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        getWindow().setLayout((int) (windowWidth * .85), (int) (windowHeight * .6));

        Intent getLevelPopUpInfo = getIntent();
        int level = getLevelPopUpInfo.getIntExtra("level", 1);

        ivInfo = (ImageView) findViewById(R.id.ivInfoLevelPopUp);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");
        txtLevel = (TextView) findViewById(R.id.txtLevelInfoLevelPopUp);
        txtLevel.setTypeface(font);
        txtLevel.setText(getString(R.string.txtLevelSplashScreen) + " " + level);
        txtTypeLevel = (TextView) findViewById(R.id.txtTypeLevelPopUp);
        txtTypeLevel.setTypeface(font);
        txtGoal = (TextView) findViewById(R.id.txtGoalInfoPopUp);
        txtGoal.setTypeface(font);

        switch (level) {
            case 1:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 10 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 2:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 10 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 3:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 4:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 5:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 6:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 7:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 8:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 10 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 9:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 10:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 11:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 12:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 13:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 14:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 15:
                txtTypeLevel.setText(getString(R.string.txtTypeKingLevel));
                ivInfo.setImageResource(R.drawable.crown);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpKing) + " " + getString(R.string.ballGuard));
                break;
            case 16:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 10 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 17:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 18:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 19:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 20:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 21:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 22:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 23:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 24:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 25:
                txtTypeLevel.setText(getString(R.string.txtTypeKingLevel));
                ivInfo.setImageResource(R.drawable.crown);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpKing) + " " + getString(R.string.ballGuardFire));
                break;
            case 26:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 27:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 28:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 29:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 30:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 31:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 32:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 33:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 34:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 35:
                txtTypeLevel.setText(getString(R.string.txtTypeKingLevel));
                ivInfo.setImageResource(R.drawable.crown);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpKing) + " " + getString(R.string.ballGodHades));
                break;
            case 36:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 37:
                txtTypeLevel.setText(getString(R.string.txtTypeBombGyroLevel));
                ivInfo.setImageResource(R.drawable.gyroboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 38:
                txtTypeLevel.setText(getString(R.string.txtTypeBombGyroLevel));
                ivInfo.setImageResource(R.drawable.gyroboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 39:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 40:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 30 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 41:
                txtTypeLevel.setText(getString(R.string.txtTypeBombGyroLevel));
                ivInfo.setImageResource(R.drawable.gyroboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 42:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 30 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 43:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 44:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 45:
                txtTypeLevel.setText(getString(R.string.txtTypeKingLevel));
                ivInfo.setImageResource(R.drawable.crown);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpKing) + " " + getString(R.string.ballGuardWater));
                break;
            case 46:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 47:
                txtTypeLevel.setText(getString(R.string.txtTypeBombGyroLevel));
                ivInfo.setImageResource(R.drawable.gyroboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 48:
                txtTypeLevel.setText(getString(R.string.txtTypeBombGyroLevel));
                ivInfo.setImageResource(R.drawable.gyroboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 49:
                txtTypeLevel.setText(getString(R.string.txtTypeClassicLevel));
                ivInfo.setImageResource(R.drawable.ball_classic_stroke);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 30 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 50:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleBoomLevel));
                ivInfo.setImageResource(R.drawable.teleboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 15 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 51:
                txtTypeLevel.setText(getString(R.string.txtTypeBombLevel));
                txtGoal.setText(getString(R.string.txtGoalLevelInfoPopUp) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 30 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 52:
                txtTypeLevel.setText(getString(R.string.txtTypeGyroscopeLevel));
                ivInfo.setImageResource(R.drawable.gyroscope);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpGyro) + " " + getString(R.string.AND) + " \n" + getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 53:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleportLevel));
                ivInfo.setImageResource(R.drawable.teleport);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUp1) + " 25 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 54:
                txtTypeLevel.setText(getString(R.string.txtTypeTeleBoomLevel));
                ivInfo.setImageResource(R.drawable.teleboom);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpMix) + "\n" + getString(R.string.txtGoalInfoPopUp1) + " 20 " + getString(R.string.txtGoalInfoPopUp2));
                break;
            case 55:
                txtTypeLevel.setText(getString(R.string.txtTypeKingLevel));
                ivInfo.setImageResource(R.drawable.crown);
                txtGoal.setText(getString(R.string.txtGoalInfoPopUpKing) + " " + getString(R.string.ballGodPoseidon));
                break;
        }
    }
}
