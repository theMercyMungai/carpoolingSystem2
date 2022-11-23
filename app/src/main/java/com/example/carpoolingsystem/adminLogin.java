package com.example.carpoolingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class adminLogin extends AppCompatActivity {private EditText inemail, inpassword;
    private Button inloginbtn, inregister, inforgotpassword;

    private FirebaseAuth inAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        inAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(adminLogin.this, DriverMapActivity2.class);
                    startActivity(intent);
                    finish();
                    return;

                }

            }
        };

        inemail =(EditText) findViewById(R.id.email);
        inpassword =(EditText) findViewById(R.id.password);

        inloginbtn =(Button) findViewById(R.id.loginbtn);
        inregister =(Button) findViewById(R.id.register);
        inforgotpassword =(Button) findViewById(R.id.forgotpassword);

        inregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminLogin.this,customerdriver.class);
                startActivity(intent);
            }
        });

        inloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = inemail.getText().toString();
                final String password = inpassword.getText().toString();
                inAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(adminLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()) {
                            Toast.makeText(adminLogin.this, "user does not exist", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(adminLogin.this, DriverMapActivity2.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        });
        inforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adminLogin.this,customerdriver.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        inAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        inAuth.addAuthStateListener(firebaseAuthListener);
    }
}