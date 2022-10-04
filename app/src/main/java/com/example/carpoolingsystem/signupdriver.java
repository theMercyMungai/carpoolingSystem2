package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signupdriver extends AppCompatActivity {
    private EditText infirstName, inlastName, inemail, inphoneNumber, inconfirmpassword, inpassword;
    private Button insignupbutton, inloginsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupdriver);

        infirstName =(EditText) findViewById(R.id.firstName);
        inlastName =(EditText) findViewById(R.id.lastName);
        inemail =(EditText) findViewById(R.id.email);
        inphoneNumber =(EditText) findViewById(R.id.phoneNumber);
        inpassword =(EditText) findViewById(R.id.password);
        inconfirmpassword =(EditText) findViewById(R.id.confirmpassword);

        insignupbutton=(Button) findViewById(R.id.signupbutton);
        inloginsignup =(Button) findViewById(R.id.loginsignup);

        insignupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupdriver.this, cardetails.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

}
