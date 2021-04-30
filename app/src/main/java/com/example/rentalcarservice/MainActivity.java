package com.example.rentalcarservice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnSignIn,btnSignUp, btnClear;
    final int SIGNUP_ACTIVITY = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
                if(checkValidation())
                {
                    String username, password;
                    username = etUsername.getText().toString().trim();
                    password = etPassword.getText().toString();
                    User isUser;
                    isUser = checkUser(username, password);
                    if(isUser!=null)
                    {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("keyUsername",isUser.getUsername());
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.rentalcarservice.SignUpActivity.class);
                startActivityForResult(intent,SIGNUP_ACTIVITY);

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

    private User checkUser(String uname, String upassword) {

        for(User user:MyData.users)
        {
            if(!user.equals(null) || user.getUsername().equals(uname) && user.getPassword().equals(upassword))
            {
                return user;
            }
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGNUP_ACTIVITY)
        {
            if(resultCode==RESULT_OK)
            {
                User u = new User(data.getStringExtra("username"),
                        data.getStringExtra("password1"));
                MyData.addUser(u);
                //Toast.makeText(this, ""+data.getStringExtra("username"), Toast.LENGTH_SHORT).show();

            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "You have to Sign In", Toast.LENGTH_SHORT).show();

            }
        }
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