package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projectx.R;

public class Registration extends AppCompatActivity {

    EditText rpname,rmob,rm,rmail,radd,rdis;
    Button rbtn,login;
    RadioButton r1,r2;
    SQLiteDatabase mdb;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        rpname=(EditText) findViewById(R.id.rpname);
        rmob=(EditText) findViewById(R.id.rmob);
        rmail=(EditText) findViewById(R.id.rmail);
        radd=(EditText) findViewById(R.id.radd);
        rdis=(EditText) findViewById(R.id.rdis);
        rbtn=(Button) findViewById(R.id.rbtn);
        login=(Button) findViewById(R.id.login);
        r1=(RadioButton) findViewById(R.id.r1);
        r1=(RadioButton) findViewById(R.id.r2);
        rg=(RadioGroup) findViewById(R.id.rg);
        mdb=openOrCreateDatabase("VE CARE",MODE_PRIVATE,null);

        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(view);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });

    }
    public void register(View v)
    {
        if(rpname.getText().toString().isEmpty() || rmob.getText().toString().isEmpty() || rmail.getText().toString().isEmpty() || radd.getText().toString().isEmpty() || rdis.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all slots !!", Toast.LENGTH_LONG).show();
        }
        else
        {
            int id= rg.getCheckedRadioButtonId();
            RadioButton rb=(RadioButton) findViewById(id);
            if (rb.getText().equals("Patient")) {
                mdb.execSQL("Create Table if not exists Patients (pname varchar(30),mob varchar(12),email varchar(20),addr varchar(30),disb varchar(30));");
                mdb.execSQL("insert into Patients values('" + rpname.getText().toString() + "','" + rmob.getText().toString() + "','" + rmail.getText().toString() + "','" + radd.getText().toString() + "','" + rdis.getText().toString() + "');");
                Toast.makeText(getApplicationContext(), "Successfull !!", Toast.LENGTH_LONG).show();
                Intent i=new Intent(this,Home.class);
                startActivity(i);
            }
            else if (rb.getText().toString().equals("CareGiver")) {
                mdb.execSQL("Create Table if not exists CareGivers (pname varchar(30),mob varchar(12),email varchar(20),addr varchar(30),disb varchar(30));");
              mdb.execSQL("insert into CareGivers values('" + rpname.getText().toString() + "','" + rmob.getText().toString() + "','" + rmail.getText().toString() + "','" + radd.getText().toString() + "','" + rdis.getText().toString() + "');");
                Intent i=new Intent(this,CGHome.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Check as Patient or CareGivers !!", Toast.LENGTH_LONG);
            }
        }
    }
}