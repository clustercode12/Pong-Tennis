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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Level extends AppCompatActivity {

    private LinearLayout[] llayWorld;
    private TextView[] txtWorld;
    private TextView[] txtWorldType;
    private ImageView[] ivWorld;
    private int level = 1;

    private InterstitialAd mInterstitialAd;
    private Random ranAd = new Random();
    private int ranInt;
    private boolean ranAdShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_level);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/main_font.ttf");

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.classLevel));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //Adb
        MobileAds.initialize(this, "ca-app-pub-3733751731897567~8650581735");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.ad_interstitial_level));

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        //Random Ad
        ranInt = ranAd.nextInt(3 - 1) + 1;
        if (ranInt == 2) {
            ranAdShow = true;
        }

        //SharedPreferencesLoadLevel
        SharedPreferences sharedPreferencesLoadLevel = getSharedPreferences(getString(R.string.SharedPreferences), Context.MODE_PRIVATE);
        level = sharedPreferencesLoadLevel.getInt(getString(R.string.level), level);

        //Linear Layout
        llayWorld = new LinearLayout[3];
        llayWorld[0] = (LinearLayout) findViewById(R.id.llayWorld1);
            llayWorld[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mInterstitialAd.isLoaded() && ranAdShow) {
                    Intent intent = new Intent(Level.this, World1.class);
                    startActivity(intent);
                    mInterstitialAd.show();
                    } else {
                        Intent intent = new Intent(Level.this, World1.class);
                        startActivity(intent);
                    }
                }
            });
        llayWorld[1] = (LinearLayout) findViewById(R.id.llayWorld2);
        llayWorld[2] = (LinearLayout) findViewById(R.id.llayWorld3);

        //Txt World
        txtWorld = new TextView[4];
        txtWorld[0] = (TextView) findViewById(R.id.txtWorld1);
        txtWorld[0].setTypeface(font);
        txtWorld[1] = (TextView) findViewById(R.id.txtWorld2);
        txtWorld[1].setTypeface(font);
        txtWorld[2] = (TextView) findViewById(R.id.txtWorld3);
        txtWorld[2].setTypeface(font);
        txtWorld[3] = (TextView) findViewById(R.id.txtWorld4);
        txtWorld[3].setTypeface(font);

        //Txt World Type
        txtWorldType = new TextView[4];
        txtWorldType[0] = (TextView) findViewById(R.id.txtWorld1Type);
        txtWorldType[0].setTypeface(font);
        txtWorldType[1] = (TextView) findViewById(R.id.txtWorld2Type);
        txtWorldType[1].setTypeface(font);
        txtWorldType[2] = (TextView) findViewById(R.id.txtWorld3Type);
        txtWorldType[2].setTypeface(font);
        txtWorldType[3] = (TextView) findViewById(R.id.txtWorld4Type);
        txtWorldType[3].setTypeface(font);

        //ImageView
        ivWorld = new ImageView[4];
        ivWorld[0] = (ImageView) findViewById(R.id.ivWorld1);
        ivWorld[1] = (ImageView) findViewById(R.id.ivWorld2);
        ivWorld[2] = (ImageView) findViewById(R.id.ivWorld3);
        ivWorld[3] = (ImageView) findViewById(R.id.ivWorld4);

        //Levels
        if (level < 16) {
            ivWorld[1].setImageResource(R.drawable.world_lock_image);
            ivWorld[2].setImageResource(R.drawable.world_lock_image);
            ivWorld[3].setImageResource(R.drawable.world_lock_image);
        } else if (level > 15 & level < 36) {
            ivWorld[2].setImageResource(R.drawable.world_lock_image);
            ivWorld[3].setImageResource(R.drawable.world_lock_image);
            llayWorld[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mInterstitialAd.isLoaded() && ranAdShow) {
                        Intent intent = new Intent(Level.this, World2.class);
                        startActivity(intent);
                        mInterstitialAd.show();
                    } else {
                        Intent intent = new Intent(Level.this, World2.class);
                        startActivity(intent);
                    }
                }
            });
        } else if (level > 35 & level < 56) {
            ivWorld[3].setImageResource(R.drawable.world_lock_image);
            llayWorld[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mInterstitialAd.isLoaded() && ranAdShow) {
                        Intent intent = new Intent(Level.this, World3.class);
                        startActivity(intent);
                        mInterstitialAd.show();
                    } else {
                        Intent intent = new Intent(Level.this, World3.class);
                        startActivity(intent);
                    }
                }
            });
            llayWorld[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mInterstitialAd.isLoaded() && ranAdShow) {
                        Intent intent = new Intent(Level.this, World2.class);
                        startActivity(intent);
                        mInterstitialAd.show();
                    } else {
                        Intent intent = new Intent(Level.this, World2.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Level.this, Main.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
