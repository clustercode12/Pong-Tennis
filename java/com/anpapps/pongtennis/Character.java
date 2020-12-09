package com.anpapps.pongtennis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Character extends AppCompatActivity {

    //Elements
    private ImageView[] ivWorld1;
    private ImageView[] ivWorld2;
    private ImageView[] ivWorld3;
    private TextView[] txtWorld1;
    private TextView[] txtWorld2;
    private TextView[] txtWorld3;
    private LinearLayout[] llay;
    private TextView txtWorld1Separator, txtWorld2Separator, txtWorld3Separator;
    private TextView txtWorld1Point, txtWorld2Point, txtWorld3Point;
    private TextView txtTypeWorld1, txtTypeWorld2, txtTypeWorld3;

    //Radio group
    private static RadioButton[] rbWorld1;
    private static RadioButton[] rbWorld2;
    private static RadioButton[] rbWorld3;
    private static RadioGroup rgWorld1;
    private static RadioGroup rgWorld2;
    private static RadioGroup rgWorld3;

    //Other
    private int level = 1;
    private int character = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.classShop));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //SharedPreferencesLoadLevel
        SharedPreferences sharedPreferencesLoadLevel = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadLevel.getInt(getString(R.string.level), level);
        character = sharedPreferencesLoadLevel.getInt(getString(R.string.character), character);

        //Inicializate

        //World 1
        rgWorld1 = (RadioGroup) findViewById(R.id.rgWorld1);

        ivWorld1 = new ImageView[5];
        ivWorld1[0] = (ImageView) findViewById(R.id.ivBallClassic);
        ivWorld1[1] = (ImageView) findViewById(R.id.ivBallClassicGreen);
        ivWorld1[2] = (ImageView) findViewById(R.id.ivBallClassicPink);
        ivWorld1[3] = (ImageView) findViewById(R.id.ivBallClassicAmbar);
        ivWorld1[4] = (ImageView) findViewById(R.id.ivBallGuard);

        rbWorld1 = new RadioButton[5];
        rbWorld1[0] = (RadioButton) findViewById(R.id.rbBallClassic);
        rbWorld1[1] = (RadioButton) findViewById(R.id.rbBallClassicGreen);
        rbWorld1[2] = (RadioButton) findViewById(R.id.rbBallClassicPink);
        rbWorld1[3] = (RadioButton) findViewById(R.id.rbBallClassicAmbar);
        rbWorld1[4] = (RadioButton) findViewById(R.id.rbBallGuard);

        txtWorld1 = new TextView[5];
        txtWorld1[0] = (TextView) findViewById(R.id.txtBallClassic);
        txtWorld1[0].setTypeface(font);
        txtWorld1[1] = (TextView) findViewById(R.id.txtBallClassicGreen);
        txtWorld1[1].setTypeface(font);
        txtWorld1[2] = (TextView) findViewById(R.id.txtBallClassicPink);
        txtWorld1[2].setTypeface(font);
        txtWorld1[3] = (TextView) findViewById(R.id.txtBallClassicAmbar);
        txtWorld1[3].setTypeface(font);
        txtWorld1[4] = (TextView) findViewById(R.id.txtBallGuard);
        txtWorld1[4].setTypeface(font);

        //World 2
        rgWorld2 = (RadioGroup) findViewById(R.id.rgWorld2);

        ivWorld2 = new ImageView[5];
        ivWorld2[0] = (ImageView) findViewById(R.id.ivBallClassicRed);
        ivWorld2[1] = (ImageView) findViewById(R.id.ivBallRainbow);
        ivWorld2[2] = (ImageView) findViewById(R.id.ivBallGuardFire);
        ivWorld2[3] = (ImageView) findViewById(R.id.ivBallVampire);
        ivWorld2[4] = (ImageView) findViewById(R.id.ivBallGodHades);

        rbWorld2 = new RadioButton[5];
        rbWorld2[0] = (RadioButton) findViewById(R.id.rbBallClassicRed);
        rbWorld2[1] = (RadioButton) findViewById(R.id.rbBallRainbow);
        rbWorld2[2] = (RadioButton) findViewById(R.id.rbBallGuardFire);
        rbWorld2[3] = (RadioButton) findViewById(R.id.rbBallVampire);
        rbWorld2[4] = (RadioButton) findViewById(R.id.rbBallGodHades);

        txtWorld2 = new TextView[5];
        txtWorld2[0] = (TextView) findViewById(R.id.txtBallClassicRed);
        txtWorld2[0].setTypeface(font);
        txtWorld2[1] = (TextView) findViewById(R.id.txtBallRainbow);
        txtWorld2[1].setTypeface(font);
        txtWorld2[2] = (TextView) findViewById(R.id.txtBallGuardFire);
        txtWorld2[2].setTypeface(font);
        txtWorld2[3] = (TextView) findViewById(R.id.txtBallVampire);
        txtWorld2[3].setTypeface(font);
        txtWorld2[4] = (TextView) findViewById(R.id.txtBallGodHades);
        txtWorld2[4].setTypeface(font);

        //World 3
        rgWorld3 = (RadioGroup) findViewById(R.id.rgWorld3);

        ivWorld3 = new ImageView[5];
        ivWorld3[0] = (ImageView) findViewById(R.id.ivBallClassicBlue);
        ivWorld3[1] = (ImageView) findViewById(R.id.ivBallWorld);
        ivWorld3[2] = (ImageView) findViewById(R.id.ivBallGuardWater);
        ivWorld3[3] = (ImageView) findViewById(R.id.ivBallIce);
        ivWorld3[4] = (ImageView) findViewById(R.id.ivBallGodPoseidon);

        rbWorld3 = new RadioButton[5];
        rbWorld3[0] = (RadioButton) findViewById(R.id.rbBallClassicBlue);
        rbWorld3[1] = (RadioButton) findViewById(R.id.rbBallWorld);
        rbWorld3[2] = (RadioButton) findViewById(R.id.rbBallGuardWater);
        rbWorld3[3] = (RadioButton) findViewById(R.id.rbBallIce);
        rbWorld3[4] = (RadioButton) findViewById(R.id.rbBallGodPoseidon);

        txtWorld3 = new TextView[5];
        txtWorld3[0] = (TextView) findViewById(R.id.txtBallClassicBlue);
        txtWorld3[0].setTypeface(font);
        txtWorld3[1] = (TextView) findViewById(R.id.txtBallWorld);
        txtWorld3[1].setTypeface(font);
        txtWorld3[2] = (TextView) findViewById(R.id.txtBallGuardWater);
        txtWorld3[2].setTypeface(font);
        txtWorld3[3] = (TextView) findViewById(R.id.txtBallIce);
        txtWorld3[3].setTypeface(font);
        txtWorld3[4] = (TextView) findViewById(R.id.txtBallGodPoseidon);
        txtWorld3[4].setTypeface(font);


        //Linear Layout
        llay = new LinearLayout[15];
        llay[0] = (LinearLayout) findViewById(R.id.llayBallClassic);
        llay[1] = (LinearLayout) findViewById(R.id.llayBallClassicGreen);
        llay[2] = (LinearLayout) findViewById(R.id.llayBallClassicPink);
        llay[3] = (LinearLayout) findViewById(R.id.llayBallClassicAmbar);
        llay[4] = (LinearLayout) findViewById(R.id.llayBallGuard);
        llay[5] = (LinearLayout) findViewById(R.id.llayBallClassicRed);
        llay[6] = (LinearLayout) findViewById(R.id.llayBallRainbow);
        llay[7] = (LinearLayout) findViewById(R.id.llayBallGuardFire);
        llay[8] = (LinearLayout) findViewById(R.id.llayBallVampire);
        llay[9] = (LinearLayout) findViewById(R.id.llayBallGodHades);
        llay[10] = (LinearLayout) findViewById(R.id.llayBallClassicBlue);
        llay[11] = (LinearLayout) findViewById(R.id.llayBallWorld);
        llay[12] = (LinearLayout) findViewById(R.id.llayBallGuardWater);
        llay[13] = (LinearLayout) findViewById(R.id.llayBallIce);
        llay[14] = (LinearLayout) findViewById(R.id.llayBallGodPoseidon);

        //Separators

        //txtWorld Separators
        txtWorld1Separator = (TextView) findViewById(R.id.txtWorld1Separator);
        txtWorld1Separator.setTypeface(font);
        txtWorld2Separator = (TextView) findViewById(R.id.txtWorld2Separator);
        txtWorld2Separator.setTypeface(font);
        txtWorld3Separator = (TextView) findViewById(R.id.txtWorld3Separator);
        txtWorld3Separator.setTypeface(font);

        //txtWorld Point
        txtWorld1Point = (TextView) findViewById(R.id.txtWorld1Separator2);
        txtWorld1Point.setTypeface(font);
        txtWorld2Point = (TextView) findViewById(R.id.txtWorld2Separator2);
        txtWorld2Point.setTypeface(font);
        txtWorld3Point = (TextView) findViewById(R.id.txtWorld3Separator2);
        txtWorld3Point.setTypeface(font);

        //txtType World
        txtTypeWorld1 = (TextView) findViewById(R.id.txtWorld1Separator3);
        txtTypeWorld1.setTypeface(font);
        txtTypeWorld2 = (TextView) findViewById(R.id.txtWorld2Separator3);
        txtTypeWorld2.setTypeface(font);
        txtTypeWorld3 = (TextView) findViewById(R.id.txtWorld3Separator3);
        txtTypeWorld3.setTypeface(font);

        //Edit when is acquired
        if (character == 1) {
            rbWorld1[0].setChecked(true);
        } else if (character == 2 && level > 2) {
            rbWorld1[1].setChecked(true);
        } else if (character == 3 && level > 5) {
            rbWorld1[2].setChecked(true);
        } else if (character == 4 && level > 10) {
            rbWorld1[3].setChecked(true);
        } else if (character == 5 && level > 15) {
            rbWorld1[4].setChecked(true);
        } else if (character == 6 && level > 17) {
            rbWorld2[0].setChecked(true);
        } else if (character == 7 && level > 20) {
            rbWorld2[1].setChecked(true);
        } else if (character == 8 && level > 25) {
            rbWorld2[2].setChecked(true);
        } else if (character == 9 && level > 30) {
            rbWorld2[3].setChecked(true);
        } else if (character == 10 && level > 35) {
            rbWorld2[4].setChecked(true);
        } else if (character == 11 && level > 37) {
            rbWorld3[0].setChecked(true);
        } else if (character == 12 && level > 40) {
            rbWorld3[1].setChecked(true);
        } else if (character == 13 && level > 45) {
            rbWorld3[2].setChecked(true);
        } else if (character == 14 && level > 50) {
            rbWorld3[3].setChecked(true);
        } else if (character == 15 && level > 55) {
            rbWorld3[4].setChecked(true);
        }

        //Classic Ball
        llay[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbWorld1[0].setChecked(true);
                character = 1;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld2.check(0);
                rgWorld3.check(0);
            }
        });

        //Other Balls
        if (level < 3) {
            ivWorld1[1].setImageResource(R.drawable.ball_lock);
            rbWorld1[1].setEnabled(false);
            rbWorld1[1].setVisibility(View.INVISIBLE);
            llay[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 2);
                    startActivity(intent);
                }
            });

            rbWorld1[0].setChecked(true);
        } else {
            llay[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld1[1].setChecked(true);
                    character = 2;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld2.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 6) {
            ivWorld1[2].setImageResource(R.drawable.ball_lock);
            llay[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 3);
                    startActivity(intent);
                }
            });
            rbWorld1[2].setEnabled(false);
            rbWorld1[2].setVisibility(View.INVISIBLE);
        } else {
            llay[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld1[2].setChecked(true);
                    character = 3;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld2.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 11) {
            ivWorld1[3].setImageResource(R.drawable.ball_lock);
            llay[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 4);
                    startActivity(intent);
                }
            });
            rbWorld1[3].setEnabled(false);
            rbWorld1[3].setVisibility(View.INVISIBLE);
        } else {
            llay[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld1[3].setChecked(true);
                    character = 4;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld2.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 16) {
            ivWorld1[4].setImageResource(R.drawable.ball_lock);
            llay[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 5);
                    startActivity(intent);
                }
            });
            rbWorld1[4].setEnabled(false);
            rbWorld1[4].setVisibility(View.INVISIBLE);
        } else {
            llay[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld1[4].setChecked(true);
                    character = 5;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld2.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 18) {
            ivWorld2[0].setImageResource(R.drawable.ball_lock);
            llay[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 6);
                    startActivity(intent);
                }
            });
            rbWorld2[0].setEnabled(false);
            rbWorld2[0].setVisibility(View.INVISIBLE);
        } else {
            llay[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld2[0].setChecked(true);
                    character = 6;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 21) {
            ivWorld2[1].setImageResource(R.drawable.ball_lock);
            llay[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 7);
                    startActivity(intent);
                }
            });
            rbWorld2[1].setEnabled(false);
            rbWorld2[1].setVisibility(View.INVISIBLE);
        } else {
            llay[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld2[1].setChecked(true);
                    character = 7;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 26) {
            ivWorld2[2].setImageResource(R.drawable.ball_lock);
            llay[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 8);
                    startActivity(intent);
                }
            });
            rbWorld2[2].setEnabled(false);
            rbWorld2[2].setVisibility(View.INVISIBLE);
        } else {
            llay[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld2[2].setChecked(true);
                    character = 8;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 31) {
            ivWorld2[3].setImageResource(R.drawable.ball_lock);
            llay[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 9);
                    startActivity(intent);
                }
            });
            rbWorld2[3].setEnabled(false);
            rbWorld2[3].setVisibility(View.INVISIBLE);
        } else {
            llay[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld2[3].setChecked(true);
                    character = 9;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 36) {
            ivWorld2[4].setImageResource(R.drawable.ball_lock);
            llay[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 10);
                    startActivity(intent);
                }
            });
            rbWorld2[4].setEnabled(false);
            rbWorld2[4].setVisibility(View.INVISIBLE);
        } else {
            llay[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld2[4].setChecked(true);
                    character = 10;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld3.check(0);
                }
            });
        }
        if (level < 38) {
            ivWorld3[0].setImageResource(R.drawable.ball_lock);
            llay[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 11);
                    startActivity(intent);
                }
            });
            rbWorld3[0].setEnabled(false);
            rbWorld3[0].setVisibility(View.INVISIBLE);
        } else {
            llay[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld3[0].setChecked(true);
                    character = 11;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld2.check(0);
                }
            });
        }
        if (level < 41) {
            ivWorld3[1].setImageResource(R.drawable.ball_lock);
            llay[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 12);
                    startActivity(intent);
                }
            });
            rbWorld3[1].setEnabled(false);
            rbWorld3[1].setVisibility(View.INVISIBLE);
        } else {
            llay[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld3[1].setChecked(true);
                    character = 12;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld2.check(0);
                }
            });
        }
        if (level < 46) {
            ivWorld3[2].setImageResource(R.drawable.ball_lock);
            llay[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 13);
                    startActivity(intent);
                }
            });
            rbWorld3[2].setEnabled(false);
            rbWorld3[2].setVisibility(View.INVISIBLE);
        } else {
            llay[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld3[2].setChecked(true);
                    character = 13;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld2.check(0);
                }
            });
        }
        if (level < 51) {
            ivWorld3[3].setImageResource(R.drawable.ball_lock);
            llay[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 14);
                    startActivity(intent);
                }
            });
            rbWorld3[3].setEnabled(false);
            rbWorld3[3].setVisibility(View.INVISIBLE);
        } else {
            llay[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld3[3].setChecked(true);
                    character = 14;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld2.check(0);
                }
            });
        }
        if (level < 56) {
            ivWorld3[4].setImageResource(R.drawable.ball_lock);
            llay[14].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Character.this, PopUpInfoCharacter.class);
                    intent.putExtra("character", 15);
                    startActivity(intent);
                }
            });
            rbWorld3[4].setEnabled(false);
            rbWorld3[4].setVisibility(View.INVISIBLE);
        } else {
            llay[14].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rbWorld3[4].setChecked(true);
                    character = 15;
                    SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                    editor.remove(getString(R.string.character));
                    editor.putInt(getString(R.string.character), character);
                    editor.commit();
                    rgWorld1.check(0);
                    rgWorld2.check(0);
                }
            });
        }

        //rbWorld1 OnClickListener
        rbWorld1[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 1;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld2.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld1[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 2;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld2.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld1[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 3;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld2.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld1[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 4;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld2.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld1[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 5;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld2.check(0);
                rgWorld3.check(0);
            }
        });

        //rbWorld1 OnClickListener
        rbWorld2[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 6;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld2[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 7;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld2[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 8;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld2[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 9;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld2[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 10;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld3.check(0);
            }
        });
        rbWorld3[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 11;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld2.check(0);
            }
        });
        rbWorld3[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 12;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld2.check(0);
            }
        });
        rbWorld3[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 13;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld2.check(0);
            }
        });
        rbWorld3[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 14;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld2.check(0);
            }
        });
        rbWorld3[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = 15;
                SharedPreferences sharedPreferencesSaveCharacter = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveCharacter.edit();
                editor.remove(getString(R.string.character));
                editor.putInt(getString(R.string.character), character);
                editor.commit();
                rgWorld1.check(0);
                rgWorld2.check(0);
            }
        });
    }
}