package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class feedback extends AppCompatActivity{
    private Button inrude, inlate, inmoney, inok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        inrude = (Button) findViewById(R.id.rude);
        inlate = (Button) findViewById(R.id.late);
        inmoney = (Button) findViewById(R.id.money);
        inok = (Button) findViewById(R.id.ok);
    }
}
