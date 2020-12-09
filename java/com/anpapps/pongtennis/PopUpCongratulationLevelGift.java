package com.anpapps.pongtennis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PopUpCongratulationLevelGift extends Activity {

    private TextView txtCongratulation, txtTitle1, txtTitle2;
    private ImageView ivGiftEquip;
    private Button btEquip;

    private int level, character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_congratulation_level_gift);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int windowWidth = displayMetrics.widthPixels;
        int windowHeight = displayMetrics.heightPixels;
        getWindow().setLayout((int) (windowWidth * .8), (int) (windowHeight * .6));

        //SharedPreferencesLoadLevel
        SharedPreferences sharedPreferencesLoadLevel = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadLevel.getInt(getString(R.string.level), level);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

        //Txt
        txtCongratulation = (TextView) findViewById(R.id.txtPopUpCongratulationLevelGiftCongratulation);
        txtCongratulation.setTypeface(font);
        txtTitle1 = (TextView) findViewById(R.id.txtPopUpCongratulationLevelGiftTitle1);
        txtTitle1.setTypeface(font);
        txtTitle2 = (TextView) findViewById(R.id.txtPopUpCongratulationLevelGiftTitle2);
        txtTitle2.setTypeface(font);

        //ImageView
        ivGiftEquip = (ImageView) findViewById(R.id.ivPopUpCongratulationLevelGiftGift);
        if (level == 3) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_classic_green);
        } else if (level == 6) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_classic_pink);
        } else if (level == 11) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_classic_ambar);
        } else if (level == 16) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_guard);
        } else if (level == 18) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_classic_red);
        } else if (level == 21) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_rainbow);
        } else if (level == 26) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_guard_fire);
        } else if (level == 31) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_vampire);
        } else if (level == 36) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_god_hades);
        } else if (level == 38) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_classic_blue);
        } else if (level == 41) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_earth);
        } else if (level == 46) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_guard_water);
        } else if (level == 51) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_ice);
        } else if (level == 56) {
            ivGiftEquip.setBackgroundResource(R.drawable.ball_god_poseidon);
        }

        //Button
        btEquip = (Button) findViewById(R.id.btPopUpCongratulationLevelGiftEquip);
        btEquip.setTypeface(font);
        btEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level == 3) {
                    character = 2;
                } else if (level == 6) {
                    character = 3;
                } else if (level == 11) {
                    character = 4;
                } else if (level == 16) {
                    character = 5;
                } else if (level == 18) {
                    character = 6;
                } else if (level == 21) {
                    character = 7;
                } else if (level == 26) {
                    character = 8;
                } else if (level == 31) {
                    character = 9;
                } else if (level == 36) {
                    character = 10;
                } else if (level == 38) {
                    character = 11;
                } else if (level == 41) {
                    character = 12;
                } else if (level == 46) {
                    character = 13;
                } else if (level == 51) {
                    character = 14;
                } else if (level == 56) {
                    character = 15;
                }
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                PopUpCongratulationLevelGift.this.finish();
            }
        });

    }
}
