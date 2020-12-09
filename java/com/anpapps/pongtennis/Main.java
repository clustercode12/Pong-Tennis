package com.anpapps.pongtennis;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class Main extends AppCompatActivity {

    private ImageView ibtStart;
    private int ibtStartWidth, ibtStartHeight;
    private ImageView ibtCharacter;
    private int ibtCharacterWidth, ibtCharacterHeight;
    private ImageView ibtMinigames;
    private int ibtMinigamesWidth, ibtMinigamesHeight;

    private InterstitialAd mInterstitialAd;
    private Random ranAd = new Random();
    private int ranInt;
    private boolean ranAdShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.lyMain);
        final MainAnimation animation_layout = new MainAnimation(this);
        layout.addView(animation_layout, 0);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.appName));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);

        //Ad
        MobileAds.initialize(this, "ca-app-pub-3733751731897567~8650581735");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.ad_interstitial_main));

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        //Random Ad
        ranInt = ranAd.nextInt(3 - 1) + 1;
        if (ranInt == 2) {
            ranAdShow = true;
        }

        //Buttons
        ibtStart = (ImageView) findViewById(R.id.ibtStart);
        ibtStartHeight = ibtStart.getHeight();
        ibtStartWidth = ibtStart.getWidth();
        ibtStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        ibtStart.getLayoutParams().height = (int) (ibtStart.getHeight() * 1.2);
                        ibtStart.getLayoutParams().width = (int) (ibtStart.getWidth() * 1.2);
                        ibtStart.requestLayout();
                        break;
                    case MotionEvent.ACTION_UP:
                        ibtStart.getLayoutParams().height = ibtStartHeight;
                        ibtStart.getLayoutParams().width = ibtStartWidth;
                        ibtStart.requestLayout();
                        Intent intent = new Intent(Main.this, Level.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        ibtCharacter = (ImageView) findViewById(R.id.ibtCharacter);
        ibtCharacterHeight = ibtCharacter.getHeight();
        ibtCharacterWidth = ibtCharacter.getWidth();
        ibtCharacter.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        ibtCharacter.getLayoutParams().height = (int) (ibtCharacter.getHeight() * 1.2);
                        ibtCharacter.getLayoutParams().width = (int) (ibtCharacter.getWidth() * 1.2);
                        ibtCharacter.requestLayout();
                        break;
                    case MotionEvent.ACTION_UP:
                        ibtCharacter.getLayoutParams().height = ibtCharacterHeight;
                        ibtCharacter.getLayoutParams().width = ibtCharacterWidth;
                        ibtCharacter.requestLayout();
                        if (mInterstitialAd.isLoaded()) {
                            Intent intent = new Intent(Main.this, Character.class);
                            startActivity(intent);
                            mInterstitialAd.show();
                        } else {
                            Intent intent = new Intent(Main.this, Character.class);
                            startActivity(intent);
                        }
                }
                return true;
            }
        });
        ibtMinigames = (ImageView) findViewById(R.id.ibtMinigames);
        ibtMinigamesHeight = ibtMinigames.getHeight();
        ibtMinigamesWidth = ibtMinigames.getWidth();
        ibtMinigames.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        ibtMinigames.getLayoutParams().height = (int) (ibtMinigames.getHeight() * 1.2);
                        ibtMinigames.getLayoutParams().width = (int) (ibtMinigames.getWidth() * 1.2);
                        ibtMinigames.requestLayout();
                        break;
                    case MotionEvent.ACTION_UP:
                        ibtMinigames.getLayoutParams().height = ibtMinigamesHeight;
                        ibtMinigames.getLayoutParams().width = ibtMinigamesWidth;
                        ibtMinigames.requestLayout();
                        if (mInterstitialAd.isLoaded()) {
                            Intent intent = new Intent(Main.this, Minigames.class);
                            startActivity(intent);
                            mInterstitialAd.show();
                        } else {
                            Intent intent = new Intent(Main.this, Minigames.class);
                            startActivity(intent);
                        }
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.miSettings) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        } else if (id == R.id.miAbout) {
            if (mInterstitialAd.isLoaded()) {
                Intent intent = new Intent(Main.this, About.class);
                startActivity(intent);
                mInterstitialAd.show();
            } else {
                Intent intent = new Intent(Main.this, About.class);
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
