package com.example.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText etUserSignUp, etUserPassword1, etUserPassword2;
    Button btnSignUpNew, btnCancelSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

        btnSignUpNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserSignUp.getText().toString().trim();
                String password1 = etUserPassword1.getText().toString();
                String password2 = etUserPassword2.getText().toString();

                if(!username.isEmpty() && !password1.isEmpty() && !password2.isEmpty())
                {
                    if(password1.equals(password2))
                    {
                        Intent  intent = new Intent();
                        intent.putExtra("username",username);
                        intent.putExtra("passwrord1",password1);
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                    else
                    {
                        etUserPassword2.setError("Password is Mis-matched");
                    }
                }

            }
        });
        btnCancelSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

    private void init() {
        etUserSignUp = findViewById(R.id.etUserSignUp);
        etUserPassword1 = findViewById(R.id.etUserPassword1);
        etUserPassword2 = findViewById(R.id.etUserPassword2);
        btnSignUpNew = findViewById(R.id.btnSignUpNew);
        btnCancelSignUp = findViewById(R.id.btnCancelSignUp);
    }
}