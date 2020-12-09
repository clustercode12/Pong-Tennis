package com.anpapps.pongtennis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PopUpMinigame extends Activity {

    private TextView txtLevelType, txtBest;
    private Button btStart;
    private int gameType = 0;
    private int best = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_minigame);

        //Display
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        getWindow().setLayout((int)(windowWidth*.8), (int)(windowHeight*.4));

        //Inicializate
        Intent getGameType = getIntent();
        gameType = getGameType.getIntExtra("type", gameType);

        SharedPreferences sharedPreferencesLoadLevel = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        if (gameType == 1) {
            best = sharedPreferencesLoadLevel.getInt(getString(R.string.pointsNormal), best);
        } else if (gameType == 2) {
            best = sharedPreferencesLoadLevel.getInt(getString(R.string.pointsBomb), best);
        } else if (gameType == 3) {
            best = sharedPreferencesLoadLevel.getInt(getString(R.string.pointsGyro), best);
        } else if (gameType == 4) {
            best = sharedPreferencesLoadLevel.getInt(getString(R.string.pointsTeleport), best);
        }
        inicializar();
    }
    private void inicializar() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

        txtLevelType = (TextView) findViewById(R.id.txtpopupminigames_leveltype);
        txtLevelType.setTypeface(font);
        txtBest = (TextView) findViewById(R.id.txtpopupminigames_best);
        txtBest.setTypeface(font);
        btStart = (Button) findViewById(R.id.btpopupminigames_play);
        btStart.setTypeface(font);
        txtBest.setText(getString(R.string.best) + ": " + best);

        if (gameType == 1) {
            txtLevelType.setText(getString(R.string.txtTypeClassicLevel));
        } else if (gameType == 2) {
            txtLevelType.setText(getString(R.string.txtTypeBombLevel));
        } else if (gameType == 3) {
            txtLevelType.setText(getString(R.string.txtTypeGyroscopeLevel));
        } else if (gameType == 4) {
            txtLevelType.setText(getString(R.string.txtTypeTeleportLevel));
        }

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameType == 1) {
                    Intent intent = new Intent(PopUpMinigame.this, GameNormal.class);
                    intent.putExtra("minigame", true);
                    startActivity(intent);
                } else if (gameType == 2) {
                    Intent intent = new Intent(PopUpMinigame.this, GameBoom.class);
                    intent.putExtra("minigame", true);
                    startActivity(intent);
                } else if (gameType == 3) {
                    Intent intent = new Intent(PopUpMinigame.this, GameGyroscope.class);
                    intent.putExtra("minigame", true);
                    startActivity(intent);
                } else if (gameType == 4) {
                    Intent intent = new Intent(PopUpMinigame.this, GameTeleportation.class);
                    intent.putExtra("minigame", true);
                    startActivity(intent);
                }
            }
        });
        //Replay
        Intent getReplayPopUp = getIntent();
        boolean replay = getReplayPopUp.getBooleanExtra("replay", false);
        if (replay) {
            btStart.setText(R.string.txtReplayPopUp);
        }
    }
}
