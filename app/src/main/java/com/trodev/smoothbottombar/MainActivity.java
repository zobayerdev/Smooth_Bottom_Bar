package com.trodev.smoothbottombar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    SmoothBottomBar smoothBottomBar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*init views*/
        smoothBottomBar = findViewById(R.id.bottombar);
        toolbar = findViewById(R.id.toolbar);

        /*When apps start show HomeFragments*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
        fragmentTransaction.commit();


        /*set all status bar, navigation bar, toolbar color*/
        smoothBottomBar.setBarBackgroundColor(Color.parseColor("#2196F3"));
        getWindow().setNavigationBarColor(Color.parseColor("#2196F3"));
        getWindow().setStatusBarColor(Color.parseColor("#2196F3"));
        toolbar.setBackgroundColor(Color.parseColor("#2196F3"));


        /*smooth bar working process*/
        smoothBottomBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {


                if (i == 0) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#2196F3"));
                    getWindow().setNavigationBarColor(Color.parseColor("#2196F3"));
                    getWindow().setStatusBarColor(Color.parseColor("#2196F3"));
                    toolbar.setBackgroundColor(Color.parseColor("#2196F3"));
                    toolbar.setTitle("Home");

                }

                if (i == 1) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new SettingsFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#009688"));
                    getWindow().setNavigationBarColor(Color.parseColor("#009688"));
                    getWindow().setStatusBarColor(Color.parseColor("#009688"));
                    toolbar.setBackgroundColor(Color.parseColor("#009688"));
                    toolbar.setTitle("Settings");
                }

                if (i == 2) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new AboutFragment());
                    fragmentTransaction.commit();

                    /*set all status bar, navigation bar, toolbar color*/
                    smoothBottomBar.setBarBackgroundColor(Color.parseColor("#FF424E4D"));
                    getWindow().setNavigationBarColor(Color.parseColor("#FF424E4D"));
                    getWindow().setStatusBarColor(Color.parseColor("#FF424E4D"));
                    toolbar.setBackgroundColor(Color.parseColor("#FF424E4D"));
                    toolbar.setTitle("About Us");
                }

                return false;
            }
        });


    }
}