package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customerdriver extends AppCompatActivity {
    private Button inDriver,inCustomer,inAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerdriver);

        inDriver =(Button) findViewById(R.id.driver);
        inCustomer =(Button) findViewById(R.id.customer);
        inAdmin = (Button) findViewById(R.id.admin);

        inDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerdriver.this, login.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerdriver.this, CustomerLoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerdriver.this, confirmcode.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}