package com.anpapps.pongtennis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class World3 extends AppCompatActivity {

    //Items
    private Button[] btLevel;
    private ImageView[] ivPasos;
    private int level = 1, btLevelInt;
    private int conseguido;

    //llayWorld3To4
    private LinearLayout llayWorld3To4;
    private ImageView ivWorld3To4;
    private TextView txtWorld3To4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_3);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.lyWorld3);
        MainAnimation animation_layout = new MainAnimation(this);
        layout.addView(animation_layout, 0);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.classWorld3));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //SharePreferences
        SharedPreferences sharedPreferencesLoadLevelandLife = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.level), level);
        btLevelInt = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.btLevel), btLevelInt);
        //Conseguido
        conseguido = sharedPreferencesLoadLevelandLife.getInt(getString(R.string.conseguido), 0);

        //Buttons
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");
        btLevel = new Button[20];
        btLevel[0] = (Button) findViewById(R.id.bt36);
        btLevel[0].setTypeface(font);
        btLevel[1] = (Button) findViewById(R.id.bt37);
        btLevel[1].setTypeface(font);
        btLevel[2] = (Button) findViewById(R.id.bt38);
        btLevel[2].setTypeface(font);
        btLevel[3] = (Button) findViewById(R.id.bt39);
        btLevel[3].setTypeface(font);
        btLevel[4] = (Button) findViewById(R.id.bt40);
        btLevel[4].setTypeface(font);
        btLevel[5] = (Button) findViewById(R.id.bt41);
        btLevel[5].setTypeface(font);
        btLevel[6] = (Button) findViewById(R.id.bt42);
        btLevel[6].setTypeface(font);
        btLevel[7] = (Button) findViewById(R.id.bt43);
        btLevel[7].setTypeface(font);
        btLevel[8] = (Button) findViewById(R.id.bt44);
        btLevel[8].setTypeface(font);
        btLevel[9] = (Button) findViewById(R.id.bt45);
        btLevel[9].setTypeface(font);
        btLevel[10] = (Button) findViewById(R.id.bt46);
        btLevel[10].setTypeface(font);
        btLevel[11] = (Button) findViewById(R.id.bt47);
        btLevel[11].setTypeface(font);
        btLevel[12] = (Button) findViewById(R.id.bt48);
        btLevel[12].setTypeface(font);
        btLevel[13] = (Button) findViewById(R.id.bt49);
        btLevel[13].setTypeface(font);
        btLevel[14] = (Button) findViewById(R.id.bt50);
        btLevel[14].setTypeface(font);
        btLevel[15] = (Button) findViewById(R.id.bt51);
        btLevel[15].setTypeface(font);
        btLevel[16] = (Button) findViewById(R.id.bt52);
        btLevel[16].setTypeface(font);
        btLevel[17] = (Button) findViewById(R.id.bt53);
        btLevel[17].setTypeface(font);
        btLevel[18] = (Button) findViewById(R.id.bt54);
        btLevel[18].setTypeface(font);
        btLevel[19] = (Button) findViewById(R.id.bt55);
        btLevel[19].setTypeface(font);

        //Pasos
        ivPasos = new ImageView[85];
        ivPasos[0] = (ImageView) findViewById(R.id.imageView97);
        ivPasos[1] = (ImageView) findViewById(R.id.imageView101);
        ivPasos[2] = (ImageView) findViewById(R.id.imageView102);
        ivPasos[3] = (ImageView) findViewById(R.id.imageView103);
        ivPasos[4] = (ImageView) findViewById(R.id.imageView104);
        ivPasos[5] = (ImageView) findViewById(R.id.imageView105);
        ivPasos[6] = (ImageView) findViewById(R.id.imageView106);
        ivPasos[7] = (ImageView) findViewById(R.id.imageView107);
        ivPasos[8] = (ImageView) findViewById(R.id.imageView108);
        ivPasos[9] = (ImageView) findViewById(R.id.imageView109);
        ivPasos[10] = (ImageView) findViewById(R.id.imageView110);
        ivPasos[11] = (ImageView) findViewById(R.id.imageView111);
        ivPasos[12] = (ImageView) findViewById(R.id.imageView112);
        ivPasos[13] = (ImageView) findViewById(R.id.imageView113);
        ivPasos[14] = (ImageView) findViewById(R.id.imageView114);
        ivPasos[15] = (ImageView) findViewById(R.id.imageView115);
        ivPasos[16] = (ImageView) findViewById(R.id.imageView116);
        ivPasos[17] = (ImageView) findViewById(R.id.imageView117);
        ivPasos[18] = (ImageView) findViewById(R.id.imageView118);
        ivPasos[19] = (ImageView) findViewById(R.id.imageView119);
        ivPasos[20] = (ImageView) findViewById(R.id.imageView120);
        ivPasos[21] = (ImageView) findViewById(R.id.imageView121);
        ivPasos[22] = (ImageView) findViewById(R.id.imageView122);
        ivPasos[23] = (ImageView) findViewById(R.id.imageView123);
        ivPasos[24] = (ImageView) findViewById(R.id.imageView124);
        ivPasos[25] = (ImageView) findViewById(R.id.imageView125);
        ivPasos[26] = (ImageView) findViewById(R.id.imageView126);
        ivPasos[27] = (ImageView) findViewById(R.id.imageView127);
        ivPasos[28] = (ImageView) findViewById(R.id.imageView128);
        ivPasos[29] = (ImageView) findViewById(R.id.imageView129);
        ivPasos[30] = (ImageView) findViewById(R.id.imageView130);
        ivPasos[31] = (ImageView) findViewById(R.id.imageView131);
        ivPasos[32] = (ImageView) findViewById(R.id.imageView132);
        ivPasos[33] = (ImageView) findViewById(R.id.imageView133);
        ivPasos[34] = (ImageView) findViewById(R.id.imageView134);
        ivPasos[35] = (ImageView) findViewById(R.id.imageView135);
        ivPasos[36] = (ImageView) findViewById(R.id.imageView136);
        ivPasos[37] = (ImageView) findViewById(R.id.imageView137);
        ivPasos[38] = (ImageView) findViewById(R.id.imageView138);
        ivPasos[39] = (ImageView) findViewById(R.id.imageView139);
        ivPasos[40] = (ImageView) findViewById(R.id.imageView140);
        ivPasos[41] = (ImageView) findViewById(R.id.imageView141);
        ivPasos[42] = (ImageView) findViewById(R.id.imageView142);
        ivPasos[43] = (ImageView) findViewById(R.id.imageView143);
        ivPasos[44] = (ImageView) findViewById(R.id.imageView144);
        ivPasos[45] = (ImageView) findViewById(R.id.imageView145);
        ivPasos[46] = (ImageView) findViewById(R.id.imageView146);
        ivPasos[47] = (ImageView) findViewById(R.id.imageView147);
        ivPasos[48] = (ImageView) findViewById(R.id.imageView148);
        ivPasos[49] = (ImageView) findViewById(R.id.imageView149);
        ivPasos[50] = (ImageView) findViewById(R.id.imageView150);
        ivPasos[51] = (ImageView) findViewById(R.id.imageView151);
        ivPasos[52] = (ImageView) findViewById(R.id.imageView152);
        ivPasos[53] = (ImageView) findViewById(R.id.imageView153);
        ivPasos[54] = (ImageView) findViewById(R.id.imageView154);
        ivPasos[55] = (ImageView) findViewById(R.id.imageView155);
        ivPasos[56] = (ImageView) findViewById(R.id.imageView156);
        ivPasos[57] = (ImageView) findViewById(R.id.imageView157);
        ivPasos[58] = (ImageView) findViewById(R.id.imageView158);
        ivPasos[59] = (ImageView) findViewById(R.id.imageView159);
        ivPasos[60] = (ImageView) findViewById(R.id.imageView160);
        ivPasos[61] = (ImageView) findViewById(R.id.imageView161);
        ivPasos[62] = (ImageView) findViewById(R.id.imageView162);
        ivPasos[63] = (ImageView) findViewById(R.id.imageView163);
        ivPasos[64] = (ImageView) findViewById(R.id.imageView164);
        ivPasos[65] = (ImageView) findViewById(R.id.imageView165);
        ivPasos[66] = (ImageView) findViewById(R.id.imageView166);
        ivPasos[67] = (ImageView) findViewById(R.id.imageView167);
        ivPasos[68] = (ImageView) findViewById(R.id.imageView168);
        ivPasos[69] = (ImageView) findViewById(R.id.imageView169);
        ivPasos[70] = (ImageView) findViewById(R.id.imageView170);
        ivPasos[71] = (ImageView) findViewById(R.id.imageView171);
        ivPasos[72] = (ImageView) findViewById(R.id.imageView172);
        ivPasos[73] = (ImageView) findViewById(R.id.imageView173);
        ivPasos[74] = (ImageView) findViewById(R.id.imageView174);
        ivPasos[75] = (ImageView) findViewById(R.id.imageView175);
        ivPasos[76] = (ImageView) findViewById(R.id.imageView176);
        ivPasos[77] = (ImageView) findViewById(R.id.imageView177);
        ivPasos[78] = (ImageView) findViewById(R.id.imageView178);
        ivPasos[79] = (ImageView) findViewById(R.id.imageView179);
        ivPasos[80] = (ImageView) findViewById(R.id.imageView180);
        ivPasos[81] = (ImageView) findViewById(R.id.imageView181);
        ivPasos[82] = (ImageView) findViewById(R.id.imageView182);
        ivPasos[83] = (ImageView) findViewById(R.id.imageView183);
        ivPasos[84] = (ImageView) findViewById(R.id.imageView184);

        //llayWorld3To4
        llayWorld3To4 = (LinearLayout) findViewById(R.id.llayWorld3To4);
        ivWorld3To4 = (ImageView) findViewById(R.id.ivWorld3To4);
        txtWorld3To4 = (TextView) findViewById(R.id.txtWorld3To4);
        txtWorld3To4.setTypeface(font);

        //Intents and Set Graphics
        //Congratulation
        Intent getCongratulationTrue = getIntent();
        boolean congratulation = getCongratulationTrue.getBooleanExtra("congratulation", false);
        if (congratulation) {
            if (level == 36 && btLevelInt == 36) {
                conseguido = 36;
                level = 37;
            } else if (level == 37 && btLevelInt == 37) {
                conseguido = 37;
                level = 38;
            } else if (level == 38 && btLevelInt == 38) {
                conseguido = 38;
                level = 39;
            } else if (level == 39 && btLevelInt == 39) {
                conseguido = 39;
                level = 40;
            } else if (level == 40 && btLevelInt == 40) {
                conseguido = 40;
                level = 41;
            } else if (level == 41 && btLevelInt == 41) {
                conseguido = 41;
                level = 42;
            } else if (level == 42 && btLevelInt == 42) {
                conseguido = 42;
                level = 43;
            } else if (level == 43 && btLevelInt == 43) {
                conseguido = 43;
                level = 44;
            } else if (level == 44 && btLevelInt == 44) {
                conseguido = 44;
                level = 45;
            } else if (level == 45 && btLevelInt == 45) {
                conseguido = 45;
                level = 46;
            } else if (level == 46 && btLevelInt == 46) {
                conseguido = 46;
                level = 47;
            } else if (level == 47 && btLevelInt == 47) {
                conseguido = 47;
                level = 48;
            } else if (level == 48 && btLevelInt == 48) {
                conseguido = 48;
                level = 49;
            } else if (level == 49 && btLevelInt == 49) {
                conseguido = 49;
                level = 50;
            } else if (level == 50 && btLevelInt == 50) {
                conseguido = 50;
                level = 51;
            } else if (level == 51 && btLevelInt == 51) {
                conseguido = 51;
                level = 52;
            } else if (level == 52 && btLevelInt == 52) {
                conseguido = 52;
                level = 53;
            } else if (level == 53 && btLevelInt == 53) {
                conseguido = 53;
                level = 54;
            } else if (level == 54 && btLevelInt == 54) {
                conseguido = 54;
                level = 55;
            } else if (level == 55 && btLevelInt == 55) {
                conseguido = 55;
                level = 56;
            }
            SharedPreferences sharedPreferencesSaveLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
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
                        Intent intent = new Intent(World3.this, PopUpCongratulationLevel.class);
                        startActivity(intent);
                    }
                }
            };
            timerThread.start();
        }

        //Buttons
        if (level < 36) {
            btLevel[0].setBackgroundResource(R.drawable.lock);
            btLevel[0].setText("");
            ivPasos[0].setImageResource(R.drawable.pasos_nigga);
            ivPasos[1].setImageResource(R.drawable.pasos_nigga);
            ivPasos[2].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 36);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 37) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 37);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 38) {
            btLevel[2].setBackgroundResource(R.drawable.lock);
            btLevel[2].setText("");
            ivPasos[7].setImageResource(R.drawable.pasos_nigga);
            ivPasos[8].setImageResource(R.drawable.pasos_nigga);
            ivPasos[9].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 38);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 39) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 39);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 40) {
            btLevel[4].setBackgroundResource(R.drawable.lock);
            btLevel[4].setText("");
            ivPasos[17].setImageResource(R.drawable.pasos_nigga);
            ivPasos[18].setImageResource(R.drawable.pasos_nigga);
            ivPasos[19].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 40);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 41) {
            btLevel[5].setBackgroundResource(R.drawable.lock);
            btLevel[5].setText("");
            ivPasos[14].setImageResource(R.drawable.pasos_nigga);
            ivPasos[15].setImageResource(R.drawable.pasos_nigga);
            ivPasos[16].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 41);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 42) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 42);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 43) {
            btLevel[7].setBackgroundResource(R.drawable.lock);
            btLevel[7].setText("");
            ivPasos[26].setImageResource(R.drawable.pasos_nigga);
            ivPasos[27].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 43);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 44) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 44);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 45) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 45);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 46) {
            btLevel[10].setBackgroundResource(R.drawable.lock);
            btLevel[10].setText("");
            ivPasos[43].setImageResource(R.drawable.pasos_nigga);
            ivPasos[44].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 46);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 47) {
            btLevel[11].setBackgroundResource(R.drawable.lock);
            btLevel[11].setText("");
            ivPasos[40].setImageResource(R.drawable.pasos_nigga);
            ivPasos[41].setImageResource(R.drawable.pasos_nigga);
            ivPasos[42].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 47);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 48) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 48);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 49) {
            btLevel[13].setBackgroundResource(R.drawable.lock);
            btLevel[13].setText("");
            ivPasos[49].setImageResource(R.drawable.pasos_nigga);
            ivPasos[50].setImageResource(R.drawable.pasos_nigga);
            ivPasos[51].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 49);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 50) {
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
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 50);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 51) {
            btLevel[15].setBackgroundResource(R.drawable.lock);
            btLevel[15].setText("");
            ivPasos[56].setImageResource(R.drawable.pasos_nigga);
            ivPasos[57].setImageResource(R.drawable.pasos_nigga);
            ivPasos[58].setImageResource(R.drawable.pasos_nigga);
            ivPasos[70].setImageResource(R.drawable.pasos_nigga);
            ivPasos[71].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[15].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 51);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 52) {
            btLevel[16].setBackgroundResource(R.drawable.lock);
            btLevel[16].setText("");
            ivPasos[66].setImageResource(R.drawable.pasos_nigga);
            ivPasos[67].setImageResource(R.drawable.pasos_nigga);
            ivPasos[68].setImageResource(R.drawable.pasos_nigga);
            ivPasos[69].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[16].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 52);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 53) {
            btLevel[17].setBackgroundResource(R.drawable.lock);
            btLevel[17].setText("");
            ivPasos[63].setImageResource(R.drawable.pasos_nigga);
            ivPasos[64].setImageResource(R.drawable.pasos_nigga);
            ivPasos[65].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[17].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 53);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 54) {
            btLevel[18].setBackgroundResource(R.drawable.lock);
            btLevel[18].setText("");
            ivPasos[59].setImageResource(R.drawable.pasos_nigga);
            ivPasos[60].setImageResource(R.drawable.pasos_nigga);
            ivPasos[61].setImageResource(R.drawable.pasos_nigga);
            ivPasos[62].setImageResource(R.drawable.pasos_nigga);
            ivPasos[72].setImageResource(R.drawable.pasos_nigga);
            ivPasos[73].setImageResource(R.drawable.pasos_nigga);
            ivPasos[74].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[18].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 54);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 55) {
            btLevel[19].setBackgroundResource(R.drawable.lock);
            btLevel[19].setText("");
            ivPasos[75].setImageResource(R.drawable.pasos_nigga);
            ivPasos[76].setImageResource(R.drawable.pasos_nigga);
            ivPasos[77].setImageResource(R.drawable.pasos_nigga);
            ivPasos[78].setImageResource(R.drawable.pasos_nigga);
        } else {
            btLevel[19].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(World3.this, PopUpLevel.class);
                    SharedPreferences sharedPreferencesSaveBtLevel = World3.this.getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesSaveBtLevel.edit();
                    editor.remove(getString(R.string.btLevel));
                    editor.putInt(getString(R.string.btLevel), 55);
                    editor.commit();
                    startActivity(intent);
                }
            });
        }
        if (level < 56) {
            ivPasos[79].setImageResource(R.drawable.pasos_nigga);
            ivPasos[80].setImageResource(R.drawable.pasos_nigga);
            ivPasos[81].setImageResource(R.drawable.pasos_nigga);
            ivPasos[82].setImageResource(R.drawable.pasos_nigga);
            ivPasos[83].setImageResource(R.drawable.pasos_nigga);
            ivPasos[84].setImageResource(R.drawable.pasos_nigga);
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
                        Intent intent = new Intent(World3.this, PopUpLevel.class);
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
        Intent intent = new Intent(World3.this, Level.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
