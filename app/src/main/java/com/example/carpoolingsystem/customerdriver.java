package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customerdriver extends AppCompatActivity {
    private Button inDriver,inCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inDriver =(Button) findViewById(R.id.driver);
        inCustomer =(Button) findViewById(R.id.customer);

        inDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerdriver.this, signUp.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}