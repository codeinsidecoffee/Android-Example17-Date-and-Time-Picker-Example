package com.mrlonewolfer.example48;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
/*
Write a program on take two on
one button click get the a date picker dialog
    and to pick day , month , year of date will display that date in TextView control

    and

    on another button click get the time picker dialog
        and to pick the hours and minutes will display on TextView
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment= new MainFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContainer,fragment);
        fragmentTransaction.commit();
    }
}
