package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class customerLandingPage extends AppCompatActivity {
    private Button inbookarider, insettings, inbecomeadriver,inlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_landing_page);


        inbookarider=(Button) findViewById(R.id.bookarider);
        insettings =(Button) findViewById(R.id.settings);
        inbecomeadriver =(Button) findViewById(R.id.becomeadriver);
        inlogout =(Button) findViewById(R.id.logout);

        inbookarider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerLandingPage.this, CustomerMapActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        insettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerLandingPage.this, login.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inbecomeadriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(customerLandingPage.this, signupdriver.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(customerLandingPage.this, customerdriver.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}