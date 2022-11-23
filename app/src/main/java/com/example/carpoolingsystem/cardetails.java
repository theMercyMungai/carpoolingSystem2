package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cardetails extends AppCompatActivity {
    private EditText innumberPlate, indestination, incarSeats;
    private Button inuploadCarDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardetails);

        innumberPlate = (EditText) findViewById(R.id.numberPlate);
        indestination = (EditText) findViewById(R.id.destination);
        incarSeats = (EditText) findViewById(R.id.carSeats);
        inuploadCarDetails = (Button) findViewById(R.id.uploadCardetails);

        inuploadCarDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cardetails.this, driverLandingPage.class);
                startActivity(intent);
                finish();
                return;
            }
        });


    }
}
