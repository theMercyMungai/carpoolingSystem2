package com.example.carpoolingsystem;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class signupdriver extends AppCompatActivity {
    private EditText infirstName, inlastName, inemail, inphoneNumber, inconfirmpassword, inpassword;
    private Button insignupbutton, inloginsignup;
    signupdriver driver;
    FirebaseDatabase Drivers;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupdriver);
        FirebaseDatabase firebaseDatabase;

        DatabaseReference databaseReference;

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Drivers");
        driver = new signupdriver();

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
                String firstName = infirstName.getText().toString();
                String lastName = inlastName.getText().toString();
                String phoneNumber = inphoneNumber.getText().toString();
                String email = inemail.getText().toString();
                String password = inpassword.getText().toString();

                if (TextUtils.isEmpty((CharSequence) infirstName) && TextUtils.isEmpty((CharSequence) inlastName ) &&
                        TextUtils.isEmpty((CharSequence)inphoneNumber)&& TextUtils.isEmpty((CharSequence)inemail) && TextUtils.isEmpty((CharSequence)inpassword)){
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(signupdriver.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(infirstName,inlastName, inemail,inphoneNumber,inpassword);
                }

            }
        });

        insignupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupdriver.this, cardetails.class);
                startActivity(intent);
                finish();
                return;
            }
        });

       
        inloginsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupdriver.this, login.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
    private void addDatatoFirebase(EditText infirstName, EditText inlastName, EditText inemail, EditText inphoneNumber,EditText inpassword) {
        driver.setdrivername(infirstName);
        driver.setdriverlastname(inlastName);
        driver.setdriverphonenumber(inphoneNumber);
        driver.setdriveremail(inemail);
        driver.setcdriverpassword(inpassword);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(driver);

                // after adding this data we are showing toast message.
                Toast.makeText(signupdriver.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(signupdriver.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setcdriverpassword(EditText inpassword) {
    }

    private void setdriveremail(EditText inemail) {
    }

    private void setdriverphonenumber(EditText inphoneNumber) {
    }

    private void setdriverlastname(EditText inlastName) {
    }

    private void setdrivername(EditText infirstName) {
    }

}
