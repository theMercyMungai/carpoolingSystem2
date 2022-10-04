package com.example.carpoolingsystem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class forgotpassword extends AppCompatActivity {
    private EditText inemail;
    private Button inok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword2);

        inemail =(EditText) findViewById(R.id.email);

        inok =(Button) findViewById(R.id.ok);
    }
}
