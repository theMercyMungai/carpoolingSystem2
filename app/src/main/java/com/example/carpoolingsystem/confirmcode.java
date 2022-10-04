package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class confirmcode extends AppCompatActivity {
    private EditText incode;
    private Button inconfirmcodebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmcode);

        incode = (EditText) findViewById(R.id.code);
        inconfirmcodebtn = (Button) findViewById(R.id.confirmcodebtn);
    }

}