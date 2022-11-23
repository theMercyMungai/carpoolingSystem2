package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class driverLandingPage extends AppCompatActivity {
    private Button inofferaride, insettings, inbecomeacustomer,incardetails,inlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_landing_page);


        inofferaride=(Button) findViewById(R.id.offerarider);
        insettings =(Button) findViewById(R.id.settings);
        inbecomeacustomer =(Button) findViewById(R.id.becomeacustomer);
        incardetails =(Button) findViewById(R.id.cardetails);
        inlogout =(Button) findViewById(R.id.logout);

        inofferaride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(driverLandingPage.this, DriverMapActivity2.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        insettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(driverLandingPage.this, login.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inbecomeacustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(driverLandingPage.this, signupcustomer.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        incardetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(driverLandingPage.this, cardetails.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(driverLandingPage.this, customerdriver.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}