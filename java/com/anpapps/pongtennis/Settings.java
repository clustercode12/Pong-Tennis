package com.anpapps.pongtennis;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.lySettings);
        MainAnimation animation_layout = new MainAnimation(this);
        layout.addView(animation_layout, 0);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.miSettings));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Settings.this, Main.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
