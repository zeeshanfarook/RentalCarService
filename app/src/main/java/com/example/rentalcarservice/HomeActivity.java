package com.example.rentalcarservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvUser, tvSelectDriver;
    Spinner spinner;
    ImageView ivCall, ivLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();


        String getUsername = getIntent().getStringExtra("keyUsername");
        tvUser.setText("Manager Name: "+getUsername);

        // this code is for Dropdown menu ... took help from this link https://www.youtube.com/watch?v=on_OrrX7Nw4&ab_channel=CodinginFlow

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.list_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="));
                startActivity(intent1);

            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void init()
    {
        tvUser = findViewById(R.id.tvUser);
        tvSelectDriver = findViewById(R.id.tvSelectDriver);
        spinner = findViewById(R.id.spinnerDrivers);
        ivCall = findViewById(R.id.ivCall);
        ivLocation = findViewById(R.id.ivLocation);


    }
}