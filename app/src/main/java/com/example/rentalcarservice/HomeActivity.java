package com.example.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvUser = findViewById(R.id.tvUser);
        String getUsername = getIntent().getStringExtra("keyUsername");
        tvUser.setText("Manager Name: "+getUsername);

        // this code is for Dropdown menu ... took help from this link https://www.youtube.com/watch?v=on_OrrX7Nw4&ab_channel=CodinginFlow
        Spinner spinner = findViewById(R.id.spinnerDrivers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerDrivers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}