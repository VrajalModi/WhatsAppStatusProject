package com.example.whatsappstatus.whatsappstatusproject;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


public class FirstPagectivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_pagectivity);

      ///  mTextMessage = (TextView) findViewById(R.id.message);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FrameLayout frameLayout = findViewById(R.id.main_container);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       // navigation.addOnLayoutChangeListener((View.OnLayoutChangeListener) mOnNavigationItemSelectedListener);

        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment)
    {
        if (fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container,fragment).commit();
            return true;
        }
        return false;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {

                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);
                    fragment = new HomeFragment();
                    break;
                case R.id.navigation_updates:
                    //  mTextMessage.setText(R.string.title_updates);
                    fragment = new LatestUpdateFragment();
                    break;
                case R.id.navigation_favourite:
                    //mTextMessage.setText(R.string.title_favourite);
                    fragment = new FavouriteFragment();
                    break;
            }
            return loadFragment(fragment);
        }

    };
}
