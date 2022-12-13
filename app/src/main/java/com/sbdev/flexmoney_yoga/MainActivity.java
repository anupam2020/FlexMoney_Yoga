package com.sbdev.flexmoney_yoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    TextInputLayout nameLayout, ageLayout, emailLayout, passLayout;
    TextInputEditText nameText, ageText, emailText, passText;
    AppCompatButton create;

    FirebaseAuth firebaseAuth;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.WHITE);

        nameLayout=findViewById(R.id.mainNameLayout);
        ageLayout=findViewById(R.id.mainAgeLayout);
        emailLayout=findViewById(R.id.mainEmailLayout);
        passLayout=findViewById(R.id.mainPasswordLayout);

        nameText=findViewById(R.id.mainNameEditText);
        ageText=findViewById(R.id.mainAgeEditText);
        emailText=findViewById(R.id.mainEmailEditText);
        passText=findViewById(R.id.mainPasswordEditText);

        create=findViewById(R.id.mainCreateButton);

        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        ageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isAgeValid(s.toString());
            }
        });

        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                nameLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ageText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ageLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        emailText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                passLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nameText.getText().toString().isEmpty())
                {
                    nameLayout.setError("Name cannot be empty!");
                }
                else if(ageText.getText().toString().isEmpty())
                {
                    ageLayout.setError("Age cannot be empty!");
                }
                else if(emailText.getText().toString().isEmpty())
                {
                    emailLayout.setError("Email cannot be empty!");
                }
                else if(passText.getText().toString().isEmpty())
                {
                    passLayout.setError("Password cannot be empty!");
                }
                else
                {
                    if(isAgeValid(ageText.getText().toString()))
                    {
                        Toast.makeText(MainActivity.this, "Account Created!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public boolean isAgeValid(String s)
    {

        int age;
        try{
            age=Integer.parseInt(s);
            if(age < 18 || age > 65)
            {
                ageLayout.setError("Age must be 18-65");
                return false;
            }
        }
        catch(Exception e) {
            ageLayout.setError("Please enter a valid age!");
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Exit");
        builder.setMessage("Do you really want to exit?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

}