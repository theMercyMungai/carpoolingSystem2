package com.example.carpoolingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;


public class confirmcode extends AppCompatActivity {
    private EditText incode;
    private Button inconfirmcodebtn;
    int counter=0;
    public int attempts=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmcode);

        incode = (EditText) findViewById(R.id.code);
        inconfirmcodebtn = (Button) findViewById(R.id.confirmcodebtn);

        if (incode.equals("343569") && (attempts<3)){
                    Intent intent = new Intent(confirmcode.this, adminLogin.class);
                    startActivity(intent);
                }else
        {
            attempts++;
            Toast.makeText(this, "Confirm password is not correct", Toast.LENGTH_SHORT).show();
        }
            }
        }
