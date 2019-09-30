package com.example.purnota.hoorayzone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AvailableTripsActivity extends AppCompatActivity {
    Button sajek, cox, sundarban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_trips);


        sajek= (Button) findViewById(R.id.sajek);
        cox= (Button) findViewById(R.id.cox);
        sundarban= (Button) findViewById(R.id.sundarban);

        sajek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(AvailableTripsActivity.this,SajekActivity.class);
                startActivity(loginintent);
            }
        });
       cox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(AvailableTripsActivity.this,CoxActivity.class);
                startActivity(loginintent);
            }
        });
       sundarban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent= new Intent(AvailableTripsActivity.this,SundarbanActivity.class);
                startActivity(loginintent);
            }
        });

    }
}
