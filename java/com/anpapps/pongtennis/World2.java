package com.anpapps.pongtennis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class World2 extends AppCompatActivity {

    //Items
    private Button[] btLevel;
    private ImageView[] ivPasos;
    private int level = 1, btLevelInt;
    private int conseguido;

    //llayWorld2To3
    private LinearLayout llayWorld2To3;
    private ImageView ivWorld2To3;
    private TextView txtWorld2To3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_2);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lyWorld2);
        MainAnimation animation_layout = new MainAnimation(this);
        layout.addView(animation_layout, 0);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.classWorld2));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //SharePreferences
        SharedPreferences sharedPreferencesLoadLevelandLife = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.level), level);
        btLevelInt = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.btLevel), btLevelInt);
        //Conseguido
        conseguido = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.conseguido), 0);

        //Buttons
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");
        btLevel = new Button[20];
        btLevel[0] = (Button) findViewById(R.id.bt16);
        btLevel[0].setTypeface(font);
        btLevel[1] = (Button) findViewById(R.id.bt17);
        btLevel[1].setTypeface(font);
        btLevel[2] = (Button) findViewById(R.id.bt18);
        btLevel[2].setTypeface(font);
        btLevel[3] = (Button) findViewById(R.id.bt19);
        btLevel[3].setTypeface(font);
        btLevel[4] = (Button) findViewById(R.id.bt20);
        btLevel[4].setTypeface(font);
        btLevel[5] = (Button) findViewById(R.id.bt21);
        btLevel[5].setTypeface(font);
        btLevel[6] = (Button) findViewById(R.id.bt22);
        btLevel[6].setTypeface(font);
        btLevel[7] = (Button) findViewById(R.id.bt23);
        btLevel[7].setTypeface(font);
        btLevel[8] = (Button) findViewById(R.id.bt24);
        btLevel[8].setTypeface(font);
        btLevel[9] = (Button) findViewById(R.id.bt25);
        btLevel[9].setTypeface(font);
        btLevel[10] = (Button) findViewById(R.id.bt26);
        btLevel[10].setTypeface(font);
        btLevel[11] = (Button) findViewById(R.id.bt27);
        btLevel[11].setTypeface(font);
        btLevel[12] = (Button) findViewById(R.id.bt28);
        btLevel[12].setTypeface(font);
        btLevel[13] = (Button) findViewById(R.id.bt29);
        btLevel[13].setTypeface(font);
        btLevel[14] = (Button) findViewById(R.id.bt30);
        btLevel[14].setTypeface(font);
        btLevel[15] = (Button) findViewById(R.id.bt31);
        btLevel[15].setTypeface(font);
        btLevel[16] = (Button) findViewById(R.id.bt32);
        btLevel[16].setTypeface(font);
        btLevel[17] = (Button) findViewById(R.id.bt33);
        btLevel[17].setTypeface(font);
        btLevel[18] = (Button) findViewById(R.id.bt34);
        btLevel[18].setTypeface(font);
        btLevel[19] = (Button) findViewById(R.id.bt35);
        btLevel[19].setTypeface(font);

        //Pasos
        ivPasos = new ImageView[85];
        ivPasos[0] = (ImageView) findViewById(R.id.imageView14);
        ivPasos[1] = (ImageView) findViewById(R.id.imageView15);
        ivPasos[2] = (ImageView) findViewById(R.id.imageView16);
        ivPasos[3] = (ImageView) findViewById(R.id.imageView17);
        ivPasos[4] = (ImageView) findViewById(R.id.imageView18);
        ivPasos[5] = (ImageView) findViewById(R.id.imageView19);
        ivPasos[6] = (ImageView) findViewById(R.id.imageView20);
        ivPasos[7] = (ImageView) findViewById(R.id.imageView21);
        ivPasos[8] = (ImageView) findViewById(R.id.imageView22);
        ivPasos[9] = (ImageView) findViewById(R.id.imageView23);
        ivPasos[10] = (ImageView) findViewById(R.id.imageView24);
        ivPasos[11] = (ImageView) findViewById(R.id.imageView25);
        ivPasos[12] = (ImageView) findViewById(R.id.imageView26);
        ivPasos[13] = (ImageView) findViewById(R.id.imageView27);
        ivPasos[14] = (ImageView) findViewById(R.id.imageView28);
        ivPasos[15] = (ImageView) findViewById(R.id.imageView29);
        ivPasos[16] = (ImageView) findViewById(R.id.imageView30);
        ivPasos[17] = (ImageView) findViewById(R.id.imageView31);
        ivPasos[18] = (ImageView) findViewById(R.id.imageView32);
        ivPasos[19] = (ImageView) findViewById(R.id.imageView33);
        ivPasos[20] = (ImageView) findViewById(R.id.imageView34);
        ivPasos[21] = (ImageView) findViewById(R.id.imageView35);
        ivPasos[22] = (ImageView) findViewById(R.id.imageView36);
        ivPasos[23] = (ImageView) findViewById(R.id.imageView37);
        ivPasos[24] = (ImageView) findViewById(R.id.imageView38);
        ivPasos[25] = (ImageView) findViewById(R.id.imageView39);
        ivPasos[26] = (ImageView) findViewById(R.id.imageView40);
        ivPasos[27] = (ImageView) findViewById(R.id.imageView41);
        ivPasos[28] = (ImageView) findViewById(R.id.imageView42);
        ivPasos[29] = (ImageView) findViewById(R.id.imageView43);
        ivPasos[30] = (ImageView) findViewById(R.id.imageView44);
        ivPasos[31] = (ImageView) findViewById(R.id.imageView45);
        ivPasos[32] = (ImageView) findViewById(R.id.imageView46);
        ivPasos[33] = (ImageView) findViewById(R.id.imageView47);
        ivPasos[34] = (ImageView) findViewById(R.id.imageView48);
        ivPasos[35] = (ImageView) findViewById(R.id.imageView49);
        ivPasos[36] = (ImageView) findViewById(R.id.imageView50);
        ivPasos[37] = (ImageView) findViewById(R.id.imageView51);
        ivPasos[38] = (ImageView) findViewById(R.id.imageView52);
        ivPasos[39] = (ImageView) findViewById(R.id.imageView53);
        ivPasos[40] = (ImageView) findViewById(R.id.imageView54);
        ivPasos[41] = (ImageView) findViewById(R.id.imageView55);
        ivPasos[42] = (ImageView) findViewById(R.id.imageView56);
        ivPasos[43] = (ImageView) findViewById(R.id.imageView57);
        ivPasos[44] = (ImageView) findViewById(R.id.imageView58);
        ivPasos[45] = (ImageView) findViewById(R.id.imageView59);
        ivPasos[46] = (ImageView) findViewById(R.id.imageView60);
        ivPasos[47] = (ImageView) findViewById(R.id.imageView61);
        ivPasos[48] = (ImageView) findViewById(R.id.imageView62);
        ivPasos[49] = (ImageView) findViewById(R.id.imageView63);
        ivPasos[50] = (ImageView) findViewById(R.id.imageView64);
        ivPasos[51] = (ImageView) findViewById(R.id.imageView65);
        ivPasos[52] = (ImageView) findViewById(R.id.imageView66);
        ivPasos[53] = (ImageView) findViewById(R.id.imageView67);
        ivPasos[54] = (ImageView) findViewById(R.id.imageView68);
        ivPasos[55] = (ImageView) findViewById(R.id.imageView69);
        ivPasos[56] = (ImageView) findViewById(R.id.imageView70);
        ivPasos[57] = (ImageView) findViewById(R.id.imageView71);
        ivPasos[58] = (ImageView) findViewById(R.id.imageView72);
        ivPasos[59] = (ImageView) findViewById(R.id.imageView73);
        ivPasos[60] = (ImageView) findViewById(R.id.imageView74);
        ivPasos[61] = (ImageView) findViewById(R.id.imageView75);
        ivPasos[62] = (ImageView) findViewById(R.id.imageView76);
        ivPasos[63] = (ImageView) findViewById(R.id.imageView77);
        ivPasos[64] = (ImageView) findViewById(R.id.imageView78);
        ivPasos[65] = (ImageView) findViewById(R.id.imageView79);
        ivPasos[66] = (ImageView) findViewById(R.id.imageView80);
        ivPasos[67] = (ImageView) findViewById(R.id.imageView81);
        ivPasos[68] = (ImageView) findViewById(R.id.imageView82);
        ivPasos[69] = (ImageView) findViewById(R.id.imageView83);
        ivPasos[70] = (ImageView) findViewById(R.id.imageView84);
        ivPasos[71] = (ImageView) findViewById(R.id.imageView85);
        ivPasos[72] = (ImageView) findViewById(R.id.imageView86);
        ivPasos[73] = (ImageView) findViewById(R.id.imageView87);
        ivPasos[74] = (ImageView) findViewById(R.id.imageView88);
        ivPasos[75] = (ImageView) findViewById(R.id.imageView89);
        ivPasos[76] = (ImageView) findViewById(R.id.imageView90);
        ivPasos[77] = (ImageView) findViewById(R.id.imageView91);
        ivPasos[78] = (ImageView) findViewById(R.id.imageView92);
        ivPasos[79] = (ImageView) findViewById(R.id.imageView93);
        ivPasos[80] = (ImageView) findViewById(R.id.imageView94);
        ivPasos[81] = (ImageView) findViewById(R.id.imageView95);
        ivPasos[82] = (ImageView) findViewById(R.id.imageView98);
        ivPasos[83] = (ImageView) findViewById(R.id.imageView99);
        ivPasos[84] = (ImageView) findViewById(R.id.imageView100);

        //llayWorld2To3
        llayWorld2To3 = (LinearLayout) findViewById(R.id.llayWorld2To3);
        ivWorld2To3 = (ImageView) findViewById(R.id.ivWorld2To3);
        txtWorld2To3 = (TextView) findViewById(R.id.txtWorld2To3);
        txtWorld2To3.setTypeface(font);

        //Intents and Set Graphics
        //Congratulation
        Intent getCongratulationTrue = getIntent();
        boolean congratulation = getCongratulationTrue.getBooleanExtra("congratulation", false);
        if (congratulation) {
            if (level == 16 && btLevelInt == 16) {
                conseguido = 16;
                level = 17;
            } else if (level == 17 && btLevelInt == 17) {
                conseguido = 17;
                level = 18;
            } else if (level == 18 && btLevelInt == 18) {
                conseguido = 18;
                level = 19;
            } else if (level == 19 && btLevelInt == 19) {
                conseguido = 19;
                level = 20;
            } else if (level == 20 && btLevelInt == 20) {
                conseguido = 20;
                level = 21;
            } else if (level == 21 && btLevelInt == 21) {
                conseguido = 21;
                level = 22;
            } else if (level == 22 && btLevelInt == 22) {
                conseguido = 22;
                level = 23;
            } else if (level == 23 && btLevelInt == 23) {
                conseguido = 23;
                level = 24;
            } else if (level == 24 && btLevelInt == 24) {
                conseguido = 24;
                level = 25;
            } else if (level == 25 && btLevelInt == 25) {
                conseguido = 25;
                level = 26;
            } else if (level == 26 && btLevelInt == 26) {
                conseguido = 26;
                level = 27;
            } else if (level == 27 && btLevelInt == 27) {
                conseguido = 27;
                level = 28;
            } else if (level == 28 && btLevelInt == 28) {
                conseguido = 28;
                level = 29;
            } else if (level == 29 && btLevelInt == 29) {
                conseguido = 29;
                level = 30;
            } else if (level == 30 && btLevelInt == 30) {
                conseguido = 30;
                level = 31;
            } else if (level == 31 && btLevelInt == 31) {
                conseguido = 31;
                level = 32;
            } else if (level == 32 && btLevelInt == 32) {
                conseguido = 32;
                level = 33;
            } else if (level == 33 && btLevelInt == 33) {
                conseguido = 33;
                level = 34;
            } else if (level == 34 && btLevelInt == 34) {
                conseguido = 34;
                level = 35;
            } else if (level == 35 && btLevelInt == 35) {
                conseguido = 35;
                level = 36;
            }
            SharedPreferences sharedPreferencesSaveLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesSaveLevel.edit();
            editor.remove(getString(R.string.level));
            editor.remove(getString(R.string.conseguido));
            editor.putInt(getString(R.string.level), level);
            editor.putInt(getString(R.string.conseguido), conseguido);
            editor.commit();
            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(World2.this, PopUpCongratulationLevel.class);
                        startActivity(intent);
                    }
                }
            };
            timerThread.start();
        }

        //Buttons
        if (level < 16) {
            btLevel[0].setBackgroundResource(R.drawable.lock);
            btLevel[0].setText("");
            ivPasos[0].setImageResource(R.drawable.pasos_nigga);
            ivPasos[1].setImageResource(R.drawable.pasos_nigga);
            ivPasos[2].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 16);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 17) {
            btLevel[1].setBackgroundResource(R.drawable.lock);
            btLevel[1].setText("");
            ivPasos[3].setImageResource(R.drawable.pasos_nigga);
            ivPasos[4].setImageResource(R.drawable.pasos_nigga);
            ivPasos[5].setImageResource(R.drawable.pasos_nigga);
            ivPasos[6].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 17);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 18) {
            btLevel[2].setBackgroundResource(R.drawable.lock);
            btLevel[2].setText("");
            ivPasos[7].setImageResource(R.drawable.pasos_nigga);
            ivPasos[8].setImageResource(R.drawable.pasos_nigga);
            ivPasos[9].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 18);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 19) {
            btLevel[3].setBackgroundResource(R.drawable.lock);
            btLevel[3].setText("");
            ivPasos[10].setImageResource(R.drawable.pasos_nigga);
            ivPasos[11].setImageResource(R.drawable.pasos_nigga);
            ivPasos[20].setImageResource(R.drawable.pasos_nigga);
            ivPasos[21].setImageResource(R.drawable.pasos_nigga);
            ivPasos[22].setImageResource(R.drawable.pasos_nigga);
            ivPasos[23].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 19);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 20) {
            btLevel[4].setBackgroundResource(R.drawable.lock);
            btLevel[4].setText("");
            ivPasos[17].setImageResource(R.drawable.pasos_nigga);
            ivPasos[18].setImageResource(R.drawable.pasos_nigga);
            ivPasos[19].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 20);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 21) {
            btLevel[5].setBackgroundResource(R.drawable.lock);
            btLevel[5].setText("");
            ivPasos[14].setImageResource(R.drawable.pasos_nigga);
            ivPasos[15].setImageResource(R.drawable.pasos_nigga);
            ivPasos[16].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 21);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 22) {
            btLevel[6].setBackgroundResource(R.drawable.lock);
            btLevel[6].setText("");
            ivPasos[12].setImageResource(R.drawable.pasos_nigga);
            ivPasos[13].setImageResource(R.drawable.pasos_nigga);
            ivPasos[24].setImageResource(R.drawable.pasos_nigga);
            ivPasos[25].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 22);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 23) {
            btLevel[7].setBackgroundResource(R.drawable.lock);
            btLevel[7].setText("");
            ivPasos[26].setImageResource(R.drawable.pasos_nigga);
            ivPasos[27].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 23);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 24) {
            btLevel[8].setBackgroundResource(R.drawable.lock);
            btLevel[8].setText("");
            ivPasos[28].setImageResource(R.drawable.pasos_nigga);
            ivPasos[29].setImageResource(R.drawable.pasos_nigga);
            ivPasos[30].setImageResource(R.drawable.pasos_nigga);
            ivPasos[31].setImageResource(R.drawable.pasos_nigga);
            ivPasos[32].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 24);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 25) {
            btLevel[9].setBackgroundResource(R.drawable.lock);
            btLevel[9].setText("");
            ivPasos[33].setImageResource(R.drawable.pasos_nigga);
            ivPasos[34].setImageResource(R.drawable.pasos_nigga);
            ivPasos[35].setImageResource(R.drawable.pasos_nigga);
            ivPasos[45].setImageResource(R.drawable.pasos_nigga);
            ivPasos[46].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 25);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 26) {
            btLevel[10].setBackgroundResource(R.drawable.lock);
            btLevel[10].setText("");
            ivPasos[43].setImageResource(R.drawable.pasos_nigga);
            ivPasos[44].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 26);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 27) {
            btLevel[11].setBackgroundResource(R.drawable.lock);
            btLevel[11].setText("");
            ivPasos[40].setImageResource(R.drawable.pasos_nigga);
            ivPasos[41].setImageResource(R.drawable.pasos_nigga);
            ivPasos[42].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 27);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 28) {
            btLevel[12].setBackgroundResource(R.drawable.lock);
            btLevel[12].setText("");
            ivPasos[36].setImageResource(R.drawable.pasos_nigga);
            ivPasos[37].setImageResource(R.drawable.pasos_nigga);
            ivPasos[38].setImageResource(R.drawable.pasos_nigga);
            ivPasos[39].setImageResource(R.drawable.pasos_nigga);
            ivPasos[47].setImageResource(R.drawable.pasos_nigga);
            ivPasos[48].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 28);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 29) {
            btLevel[13].setBackgroundResource(R.drawable.lock);
            btLevel[13].setText("");
            ivPasos[49].setImageResource(R.drawable.pasos_nigga);
            ivPasos[50].setImageResource(R.drawable.pasos_nigga);
            ivPasos[51].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 29);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 30) {
            btLevel[14].setBackgroundResource(R.drawable.lock);
            btLevel[14].setText("");
            ivPasos[52].setImageResource(R.drawable.pasos_nigga);
            ivPasos[53].setImageResource(R.drawable.pasos_nigga);
            ivPasos[54].setImageResource(R.drawable.pasos_nigga);
            ivPasos[55].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[14].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 30);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 31) {
            btLevel[15].setBackgroundResource(R.drawable.lock);
            btLevel[15].setText("");
            ivPasos[56].setImageResource(R.drawable.pasos_nigga);
            ivPasos[57].setImageResource(R.drawable.pasos_nigga);
            ivPasos[58].setImageResource(R.drawable.pasos_nigga);
            ivPasos[68].setImageResource(R.drawable.pasos_nigga);
            ivPasos[69].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[15].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 31);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 32) {
            btLevel[16].setBackgroundResource(R.drawable.lock);
            btLevel[16].setText("");
            ivPasos[64].setImageResource(R.drawable.pasos_nigga);
            ivPasos[65].setImageResource(R.drawable.pasos_nigga);
            ivPasos[66].setImageResource(R.drawable.pasos_nigga);
            ivPasos[67].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[16].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 32);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 33) {
            btLevel[17].setBackgroundResource(R.drawable.lock);
            btLevel[17].setText("");
            ivPasos[61].setImageResource(R.drawable.pasos_nigga);
            ivPasos[62].setImageResource(R.drawable.pasos_nigga);
            ivPasos[63].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[17].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 33);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 34) {
            btLevel[18].setBackgroundResource(R.drawable.lock);
            btLevel[18].setText("");
            ivPasos[59].setImageResource(R.drawable.pasos_nigga);
            ivPasos[60].setImageResource(R.drawable.pasos_nigga);
            ivPasos[70].setImageResource(R.drawable.pasos_nigga);
            ivPasos[71].setImageResource(R.drawable.pasos_nigga);
            ivPasos[72].setImageResource(R.drawable.pasos_nigga);
            ivPasos[73].setImageResource(R.drawable.pasos_nigga);
            ivPasos[81].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[18].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 34);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 35) {
            btLevel[19].setBackgroundResource(R.drawable.lock);
            btLevel[19].setText("");
            ivPasos[74].setImageResource(R.drawable.pasos_nigga);
            ivPasos[75].setImageResource(R.drawable.pasos_nigga);
            ivPasos[76].setImageResource(R.drawable.pasos_nigga);
            ivPasos[80].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[19].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World2.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World2.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 35);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 36) {
            ivWorld2To3.setImageResource(R.drawable.world_lock_image);
            txtWorld2To3.setText("");
            ivPasos[77].setImageResource(R.drawable.pasos_nigga);
            ivPasos[78].setImageResource(R.drawable.pasos_nigga);
            ivPasos[79].setImageResource(R.drawable.pasos_nigga);
            ivPasos[82].setImageResource(R.drawable.pasos_nigga);
            ivPasos[83].setImageResource(R.drawable.pasos_nigga);
            ivPasos[84].setImageResource(R.drawable.pasos_nigga);
        } else {
            llayWorld2To3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(World2.this, World3.class);
                    startActivity(intent);
                }
            });
        }
        //Replay
        Intent getPopUpTrue = getIntent();
        final boolean replay = getPopUpTrue.getBooleanExtra("reintentar", false);
        if (replay) {
            Thread timerThread = new Thread() {
                public void run() {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        Intent intent = new Intent(World2.this, PopUpLevel.class);
                        intent.putExtra("replay", true);
                        startActivity(intent);
                    }
                }
            };
            timerThread.start();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(World2.this, Level.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
