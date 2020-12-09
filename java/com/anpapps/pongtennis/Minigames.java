package com.anpapps.pongtennis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Minigames extends AppCompatActivity {

    private LinearLayout[] lyGames;
    private LinearLayout lyGetMoreCoins;
    private TextView[] txtGames;
    private int points, type, oldPoints = 0;
    private boolean repeat = false;

    private int coin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigames);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lyminigames);
        final MainAnimation animation_layout = new MainAnimation(this);
        layout.addView(animation_layout, 0);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.classMinigames));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //SharedPreferencesLoadLevel
        SharedPreferences sharedPreferencesLoadLevel = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        coin = sharedPreferencesLoadLevel.getInt(getString(R.string.coin), coin);

        //Inicializate

        Intent getGameType = getIntent();
        type = getGameType.getIntExtra("type", 0);
        repeat = getGameType.getBooleanExtra("repeat", false);
        points = getGameType.getIntExtra("points", 0);
        if (type == 1 && points > 0 && points > oldPoints) {
            SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
            editor.remove(getString(R.string.pointsNormal));
            editor.putInt(getString(R.string.pointsNormal), points);
            editor.commit();
        } else if (type == 2 && points > 0 && points > oldPoints) {
            SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
            editor.remove(getString(R.string.pointsBomb));
            editor.putInt(getString(R.string.pointsBomb), points);
            editor.commit();
        } else if (type == 3 && points > 0 && points > oldPoints) {
            SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
            editor.remove(getString(R.string.pointsGyro));
            editor.putInt(getString(R.string.pointsGyro), points);
            editor.commit();
        } else if (type == 4 && points > 0 && points > oldPoints) {
            SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
            editor.remove(getString(R.string.pointsTeleport));
            editor.putInt(getString(R.string.pointsTeleport), points);
            editor.commit();
        }
        inicializar();

        //LinearLayout Listener
        lyListener();
    }

    private void inicializar() {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

        lyGames = new LinearLayout[4];
        lyGames[0] = (LinearLayout) findViewById(R.id.lyminigames_normalgame);
        lyGames[1] = (LinearLayout) findViewById(R.id.lyminigames_bombgame);
        lyGames[2] = (LinearLayout) findViewById(R.id.lyminigames_gyrogame);
        lyGames[3] = (LinearLayout) findViewById(R.id.lyminigames_teleportgame);

        txtGames = new TextView[4];
        txtGames[0] = (TextView) findViewById(R.id.txtminigames_normalgame);
        txtGames[0].setTypeface(font);
        txtGames[1] = (TextView) findViewById(R.id.txtminigames_bombgame);
        txtGames[1].setTypeface(font);
        txtGames[2] = (TextView) findViewById(R.id.txtminigames_gyrogame);
        txtGames[2].setTypeface(font);
        txtGames[3] = (TextView) findViewById(R.id.txtminigames_teleportgame);
        txtGames[3].setTypeface(font);
    }

    private void lyListener() {
        lyGames[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Minigames.this, PopUpMinigame.class);
                intent.putExtra("type", 1);
                startActivity(intent);
            }
        });
        lyGames[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Minigames.this, PopUpMinigame.class);
                intent.putExtra("type", 2);
                startActivity(intent);
            }
        });
        lyGames[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Minigames.this, PopUpMinigame.class);
                intent.putExtra("type", 3);
                startActivity(intent);
            }
        });
        lyGames[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Minigames.this, PopUpMinigame.class);
                intent.putExtra("type", 4);
                startActivity(intent);
            }
        });
        //Replay
        Intent getPopUpTrue = getIntent();
        final boolean replay = getPopUpTrue.getBooleanExtra("repeat", false);
        final int type = getPopUpTrue.getIntExtra("type", 1);
        if (replay) {
            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(Minigames.this, PopUpMinigame.class);
                        intent.putExtra("replay", true);
                        intent.putExtra("type", type);
                        startActivity(intent);
                    }
                }
            };
            timerThread.start();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Minigames.this, Main.class);
        startActivity(intent);
    }
}
