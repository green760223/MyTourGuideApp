package com.example.android.mytourguideapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare a viewpaer
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Declare a custom fragment adpater
        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(
                getSupportFragmentManager(),
                MainActivity.this
        );

        // Setup the adapter into viewpager
        viewPager.setAdapter(simpleFragmentPagerAdapter);

        // Declare a tab layout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        // Setup viewpager into the tab layout.
        tabLayout.setupWithViewPager(viewPager);

    }
}
