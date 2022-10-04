package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class forgotpassword2 extends AppCompatActivity {
    private EditText incode;
    private Button inok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword2);

        incode =(EditText) findViewById(R.id.code);

        inok =(Button) findViewById(R.id.ok);
    }
}
