package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    Button trans,cook,coun,oth,path,health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        trans=(Button)findViewById(R.id.trans);
        cook=(Button) findViewById(R.id.cook);
        coun=(Button) findViewById(R.id.coun);
        oth=(Button) findViewById(R.id.oth);
        health=(Button) findViewById(R.id.health);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Transportation.class);
                startActivity(i);
            }
        });
        cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Cook.class);
                startActivity(i);
            }
        });
        coun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Counselling.class);
                startActivity(i);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Health.class);
                startActivity(i);
            }
        });
        oth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Other.class);
                startActivity(i);
            }
        });
    }
}
