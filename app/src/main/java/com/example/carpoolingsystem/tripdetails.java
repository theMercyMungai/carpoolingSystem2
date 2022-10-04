package com.example.carpoolingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class tripdetails extends AppCompatActivity {
    private EditText indestination, incarseatsbooked, inleavingtime;
    private Button inbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tripdetails);

        indestination = (EditText) findViewById(R.id.destination);
        incarseatsbooked = (EditText) findViewById(R.id.carseatsbooked);
        inleavingtime = (EditText) findViewById(R.id.leavingtime);

        inbook = (Button) findViewById(R.id.book);


        }
    }

