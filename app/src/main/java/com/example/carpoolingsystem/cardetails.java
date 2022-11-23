package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cardetails extends AppCompatActivity {
    private EditText innumberPlate, indestination, incarSeats;
    private Button inuploadCarDetails;
    String[] item = {"5:30pm", "7:30pm", "8:30pm"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardetails);

        innumberPlate = (EditText) findViewById(R.id.numberPlate);
        indestination = (EditText) findViewById(R.id.destination);
        incarSeats = (EditText) findViewById(R.id.carSeats);
        inuploadCarDetails = (Button) findViewById(R.id.uploadCardetails);
        autoCompleteTextView = findViewById(R.id.leavingtimes);

        adapterItems = new ArrayAdapter<String>(this,R.layout.leaving_times,item);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = AdapterView(parent.getItemAtPosition(position).toString());

                Toast.makeText(cardetails.this, "item"+ item, Toast.LENGTH_SHORT).show();
            }
        });


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
