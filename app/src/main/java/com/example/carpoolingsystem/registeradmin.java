package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registeradmin extends AppCompatActivity {
    private EditText  inemail, inconfirmpassword, inpassword;
    private Button insignupbutton, inloginsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupdriver);


        inemail =(EditText) findViewById(R.id.email);
        inpassword =(EditText) findViewById(R.id.password);
        inconfirmpassword =(EditText) findViewById(R.id.confirmpassword);

        insignupbutton=(Button) findViewById(R.id.signupbutton);
        inloginsignup =(Button) findViewById(R.id.loginsignup);

        insignupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registeradmin.this, CustomerMapActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        inloginsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registeradmin.this, adminLogin.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}