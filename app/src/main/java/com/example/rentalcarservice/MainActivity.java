package com.example.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnSignIn,btnSignUp, btnClear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = etUsername.getText().toString();
                String p = etPassword.getText().toString();
                if(checkValidation())
                {
                    String username, password;
                    username = etUsername.getText().toString().trim();
                    password = etPassword.getText().toString();
                    Intent intent = new Intent(MainActivity.this, com.example.rentalcarservice.HomeActivity.class);
                    intent.putExtra("keyUsername", username);
                    startActivity(intent);
                    finish();

                }
            }

        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUsername.setText("");
                etPassword.setText("");
            }
        });



    }

    private boolean checkValidation() {
        boolean flag=true;
        if(etUsername.getText().toString().isEmpty())
        {
            etUsername.setError("Please Enter Username");
            flag = false;
        }
        if(etPassword.getText().toString().isEmpty())
        {
            etPassword.setError("Please Enter Password");
            flag = false;
        }
        return flag;
    }
    public void init(){
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnClear = findViewById(R.id.btnClear);
    }
}