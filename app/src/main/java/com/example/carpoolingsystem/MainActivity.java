package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText inemail, inpassword;
    private Button inloginbtn, inregister, inforgotpassword;
    private FirebaseAuth inAuth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inemail =(EditText) findViewById(R.id.email);
        inpassword =(EditText) findViewById(R.id.password);

        inloginbtn =(Button) findViewById(R.id.loginbtn);
        inregister =(Button) findViewById(R.id.register);
        inforgotpassword =(Button) findViewById(R.id.forgotpassword);


    }
}