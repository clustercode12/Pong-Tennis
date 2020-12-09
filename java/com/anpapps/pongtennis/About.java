package com.anpapps.pongtennis;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.ScrollView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ScrollView layout = (ScrollView) findViewById(R.id.lyAbout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //Action Bar Title Font
        SpannableString s = new SpannableString(getString(R.string.miAbout));
        s.setSpan(new TypefaceSpan(this, "MyTypeface.otf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(s);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(About.this, Main.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
