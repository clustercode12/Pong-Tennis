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

/**
 * Created by andres__np on 7/27/2016.
 */
public class World1 extends AppCompatActivity {

    //Items
    private Button[] btLevel;
    private ImageView[] ivPasos;
    private int level = 1, btLevelInt;
    private int conseguido;
    private boolean consegido1Vez = false;

    //llayWorld1To2
    private LinearLayout llayWorld1To2;
    private ImageView ivWorld1To2;
    private TextView txtWorld1To2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_1);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lyWorld1);
        MainAnimation animation_layout = new MainAnimation(this);
        layout.addView(animation_layout, 0);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.classWorld1));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //SharePreferences
        SharedPreferences sharedPreferencesLoadLevelandLife = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.level), level);
        btLevelInt = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.btLevel), btLevelInt);
        //Conseguido
        conseguido = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.conseguido), 0);

        //Buttons
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");
        btLevel = new Button[15];
        btLevel[0] = (Button) findViewById(R.id.bt1);
        btLevel[0].setTypeface(font);
        btLevel[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(World1.this, PopUpLevel.class);
                SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                editor.remove(getString(R.string.btLevel));
                editor.putInt(getString(R.string.btLevel), 1);
                editor.commit();
                startActivity(intent);
            }
        });
        btLevel[1] = (Button) findViewById(R.id.bt2);
        btLevel[1].setTypeface(font);
        btLevel[2] = (Button) findViewById(R.id.bt3);
        btLevel[2].setTypeface(font);
        btLevel[3] = (Button) findViewById(R.id.bt4);
        btLevel[3].setTypeface(font);
        btLevel[4] = (Button) findViewById(R.id.bt5);
        btLevel[4].setTypeface(font);
        btLevel[5] = (Button) findViewById(R.id.bt6);
        btLevel[5].setTypeface(font);
        btLevel[6] = (Button) findViewById(R.id.bt7);
        btLevel[6].setTypeface(font);
        btLevel[7] = (Button) findViewById(R.id.bt8);
        btLevel[7].setTypeface(font);
        btLevel[8] = (Button) findViewById(R.id.bt9);
        btLevel[8].setTypeface(font);
        btLevel[9] = (Button) findViewById(R.id.bt10);
        btLevel[9].setTypeface(font);
        btLevel[10] = (Button) findViewById(R.id.bt11);
        btLevel[10].setTypeface(font);
        btLevel[11] = (Button) findViewById(R.id.bt12);
        btLevel[11].setTypeface(font);
        btLevel[12] = (Button) findViewById(R.id.bt13);
        btLevel[12].setTypeface(font);
        btLevel[13] = (Button) findViewById(R.id.bt14);
        btLevel[13].setTypeface(font);
        btLevel[14] = (Button) findViewById(R.id.bt15);
        btLevel[14].setTypeface(font);

        //Pasos
        ivPasos = new ImageView[62];
        ivPasos[0] = (ImageView) findViewById(R.id.ivPasos1);
        ivPasos[1] = (ImageView) findViewById(R.id.ivPasos2);
        ivPasos[2] = (ImageView) findViewById(R.id.ivPasos3);
        ivPasos[3] = (ImageView) findViewById(R.id.ivPasos4);
        ivPasos[4] = (ImageView) findViewById(R.id.ivPasos5);
        ivPasos[5] = (ImageView) findViewById(R.id.ivPasos6);
        ivPasos[6] = (ImageView) findViewById(R.id.ivPasos7);
        ivPasos[7] = (ImageView) findViewById(R.id.ivPasos8);
        ivPasos[8] = (ImageView) findViewById(R.id.ivPasos9);
        ivPasos[9] = (ImageView) findViewById(R.id.ivPasos10);
        ivPasos[10] = (ImageView) findViewById(R.id.ivPasos11);
        ivPasos[11] = (ImageView) findViewById(R.id.ivPasos12);
        ivPasos[12] = (ImageView) findViewById(R.id.ivPasos13);
        ivPasos[13] = (ImageView) findViewById(R.id.ivPasos14);
        ivPasos[14] = (ImageView) findViewById(R.id.ivPasos15);
        ivPasos[15] = (ImageView) findViewById(R.id.ivPasos16);
        ivPasos[16] = (ImageView) findViewById(R.id.ivPasos17);
        ivPasos[17] = (ImageView) findViewById(R.id.ivPasos18);
        ivPasos[18] = (ImageView) findViewById(R.id.ivPasos19);
        ivPasos[19] = (ImageView) findViewById(R.id.ivPasos20);
        ivPasos[20] = (ImageView) findViewById(R.id.ivPasos21);
        ivPasos[21] = (ImageView) findViewById(R.id.ivPasos22);
        ivPasos[22] = (ImageView) findViewById(R.id.ivPasos23);
        ivPasos[23] = (ImageView) findViewById(R.id.ivPasos24);
        ivPasos[24] = (ImageView) findViewById(R.id.ivPasos25);
        ivPasos[25] = (ImageView) findViewById(R.id.ivPasos26);
        ivPasos[26] = (ImageView) findViewById(R.id.ivPasos27);
        ivPasos[27] = (ImageView) findViewById(R.id.ivPasos28);
        ivPasos[28] = (ImageView) findViewById(R.id.ivPasos29);
        ivPasos[29] = (ImageView) findViewById(R.id.ivPasos30);
        ivPasos[30] = (ImageView) findViewById(R.id.ivPasos31);
        ivPasos[31] = (ImageView) findViewById(R.id.ivPasos32);
        ivPasos[32] = (ImageView) findViewById(R.id.ivPasos33);
        ivPasos[33] = (ImageView) findViewById(R.id.ivPasos34);
        ivPasos[34] = (ImageView) findViewById(R.id.ivPasos35);
        ivPasos[35] = (ImageView) findViewById(R.id.ivPasos36);
        ivPasos[36] = (ImageView) findViewById(R.id.ivPasos37);
        ivPasos[37] = (ImageView) findViewById(R.id.ivPasos38);
        ivPasos[38] = (ImageView) findViewById(R.id.ivPasos39);
        ivPasos[39] = (ImageView) findViewById(R.id.ivPasos40);
        ivPasos[40] = (ImageView) findViewById(R.id.ivPasos41);
        ivPasos[41] = (ImageView) findViewById(R.id.ivPasos42);
        ivPasos[42] = (ImageView) findViewById(R.id.ivPasos43);
        ivPasos[43] = (ImageView) findViewById(R.id.ivPasos44);
        ivPasos[44] = (ImageView) findViewById(R.id.ivPasos45);
        ivPasos[45] = (ImageView) findViewById(R.id.ivPasos46);
        ivPasos[46] = (ImageView) findViewById(R.id.ivPasos47);
        ivPasos[47] = (ImageView) findViewById(R.id.ivPasos48);
        ivPasos[48] = (ImageView) findViewById(R.id.imageView13);
        ivPasos[49] = (ImageView) findViewById(R.id.imageView);
        ivPasos[50] = (ImageView) findViewById(R.id.imageView2);
        ivPasos[51] = (ImageView) findViewById(R.id.imageView3);
        ivPasos[52] = (ImageView) findViewById(R.id.imageView4);
        ivPasos[53] = (ImageView) findViewById(R.id.imageView5);
        ivPasos[54] = (ImageView) findViewById(R.id.imageView6);
        ivPasos[55] = (ImageView) findViewById(R.id.imageView7);
        ivPasos[56] = (ImageView) findViewById(R.id.imageView8);
        ivPasos[57] = (ImageView) findViewById(R.id.imageView9);
        ivPasos[58] = (ImageView) findViewById(R.id.imageView10);
        ivPasos[59] = (ImageView) findViewById(R.id.imageView11);
        ivPasos[60] = (ImageView) findViewById(R.id.imageView12);
        ivPasos[61] = (ImageView) findViewById(R.id.imageView96);

        //llayWorld1To2
        llayWorld1To2 = (LinearLayout) findViewById(R.id.llayWorld1To2);
        ivWorld1To2 = (ImageView) findViewById(R.id.ivWorld1To2);
        txtWorld1To2 = (TextView) findViewById(R.id.txtWorld1To2);
        txtWorld1To2.setTypeface(font);

        //Intents and Set Graphics
        //Congratulation
        Intent getCongratulationTrue = getIntent();
        final boolean congratulation = getCongratulationTrue.getBooleanExtra("congratulation", false);
        if (congratulation) {
            if (level == 1 && btLevelInt == 1) {
                conseguido = 1;
                level = 2;
                consegido1Vez = true;
            } else if (level == 2 && btLevelInt == 2) {
                conseguido = 2;
                level = 3;
                consegido1Vez = true;
            } else if (level == 3 && btLevelInt == 3) {
                conseguido = 3;
                level = 4;
                consegido1Vez = true;
            } else if (level == 4 && btLevelInt == 4) {
                conseguido = 4;
                level = 5;
                consegido1Vez = true;
            } else if (level == 5 && btLevelInt == 5) {
                conseguido = 5;
                level = 6;
                consegido1Vez = true;
            } else if (level == 6 && btLevelInt == 6) {
                conseguido = 6;
                level = 7;
                consegido1Vez = true;
            } else if (level == 7 && btLevelInt == 7) {
                conseguido = 7;
                level = 8;
                consegido1Vez = true;
            } else if (level == 8 && btLevelInt == 8) {
                conseguido = 8;
                level = 9;
                consegido1Vez = true;
            } else if (level == 9 && btLevelInt == 9) {
                conseguido = 9;
                level = 10;
                consegido1Vez = true;
            } else if (level == 10 && btLevelInt == 10) {
                conseguido = 10;
                level = 11;
                consegido1Vez = true;
            } else if (level == 11 && btLevelInt == 11) {
                conseguido = 11;
                level = 12;
                consegido1Vez = true;
            } else if (level == 12 && btLevelInt == 12) {
                conseguido = 12;
                level = 13;
                consegido1Vez = true;
            } else if (level == 13 && btLevelInt == 13) {
                conseguido = 13;
                level = 14;
                consegido1Vez = true;
            } else if (level == 14 && btLevelInt == 14) {
                conseguido = 14;
                level = 15;
                consegido1Vez = true;
            } else if (level == 15 && btLevelInt == 15) {
                conseguido = 15;
                level = 16;
                consegido1Vez = true;
            }

            if (consegido1Vez) {
                SharedPreferences sharedPreferencesSaveLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
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
                            Intent intentPresent = null;
                            if (conseguido == 2 || conseguido == 5 || conseguido == 10 || conseguido == 15) {
                                intentPresent = new Intent(World1.this, PopUpCongratulationLevelGift.class);
                                startActivity(intentPresent);
                            } else {
                                Intent intent = new Intent(World1.this, PopUpCongratulationLevel.class);
                                startActivity(intent);
                            }
                        }
                    }
                };
                timerThread.start();
            }
        }

        //Buttons
        if (level < 2) {
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
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 2);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 3) {
            btLevel[2].setBackgroundResource(R.drawable.lock);
            btLevel[2].setText("");
            ivPasos[7].setImageResource(R.drawable.pasos_nigga);
            ivPasos[8].setImageResource(R.drawable.pasos_nigga);
            ivPasos[9].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 3);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 4) {
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
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 4);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 5) {
            btLevel[4].setBackgroundResource(R.drawable.lock);
            btLevel[4].setText("");
            ivPasos[17].setImageResource(R.drawable.pasos_nigga);
            ivPasos[18].setImageResource(R.drawable.pasos_nigga);
            ivPasos[19].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 5);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 6) {
            btLevel[5].setBackgroundResource(R.drawable.lock);
            btLevel[5].setText("");
            ivPasos[14].setImageResource(R.drawable.pasos_nigga);
            ivPasos[15].setImageResource(R.drawable.pasos_nigga);
            ivPasos[16].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 6);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 7) {
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
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 7);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 8) {
            btLevel[7].setBackgroundResource(R.drawable.lock);
            btLevel[7].setText("");
            ivPasos[26].setImageResource(R.drawable.pasos_nigga);
            ivPasos[27].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 8);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 9) {
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
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 9);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 10) {
            btLevel[9].setBackgroundResource(R.drawable.lock);
            btLevel[9].setText("");
            ivPasos[33].setImageResource(R.drawable.pasos_nigga);
            ivPasos[43].setImageResource(R.drawable.pasos_nigga);
            ivPasos[44].setImageResource(R.drawable.pasos_nigga);
            ivPasos[34].setImageResource(R.drawable.pasos_nigga);
            ivPasos[35].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 10);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 11) {
            btLevel[10].setBackgroundResource(R.drawable.lock);
            btLevel[10].setText("");
            ivPasos[41].setImageResource(R.drawable.pasos_nigga);
            ivPasos[42].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 11);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 12) {
            btLevel[11].setBackgroundResource(R.drawable.lock);
            btLevel[11].setText("");
            ivPasos[38].setImageResource(R.drawable.pasos_nigga);
            ivPasos[39].setImageResource(R.drawable.pasos_nigga);
            ivPasos[40].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 12);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 13) {
            btLevel[12].setBackgroundResource(R.drawable.lock);
            btLevel[12].setText("");
            ivPasos[36].setImageResource(R.drawable.pasos_nigga);
            ivPasos[48].setImageResource(R.drawable.pasos_nigga);
            ivPasos[37].setImageResource(R.drawable.pasos_nigga);
            ivPasos[45].setImageResource(R.drawable.pasos_nigga);
            ivPasos[46].setImageResource(R.drawable.pasos_nigga);
            ivPasos[47].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 13);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 14) {
            btLevel[13].setBackgroundResource(R.drawable.lock);
            btLevel[13].setText("");
            ivPasos[49].setImageResource(R.drawable.pasos_nigga);
            ivPasos[50].setImageResource(R.drawable.pasos_nigga);
            ivPasos[51].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 14);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 15) {
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
                    Intent intent = new Intent(World1.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World1.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 15);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 16) {
            ivWorld1To2.setImageResource(R.drawable.world_lock_image);
            txtWorld1To2.setText("");
            ivPasos[56].setImageResource(R.drawable.pasos_nigga);
            ivPasos[57].setImageResource(R.drawable.pasos_nigga);
            ivPasos[58].setImageResource(R.drawable.pasos_nigga);
            ivPasos[59].setImageResource(R.drawable.pasos_nigga);
            ivPasos[60].setImageResource(R.drawable.pasos_nigga);
            ivPasos[61].setImageResource(R.drawable.pasos_nigga);
        } else {
            llayWorld1To2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(World1.this, World2.class);
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
                        Intent intent = new Intent(World1.this, PopUpLevel.class);
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
        Intent intent = new Intent(World1.this, Level.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
