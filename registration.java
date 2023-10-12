package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText rpname,rmob,rm,rmail,radd,rdis;
    Button rbtn,login;
    RadioButton r1,r2;
    SQLiteDatabase mdb;

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
        r1=(RadioButton) findViewById(R.id.r1);
        r1=(RadioButton) findViewById(R.id.r2);

        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(view);
            }
        });
        mdb=openOrCreateDatabase("VE CARE",MODE_PRIVATE,null);
    }
    public void register(View v)
    {
        if(rpname.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all slots !!", Toast.LENGTH_LONG);
        }
        else if(rmob.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all slots !!", Toast.LENGTH_LONG);
        }
        else if(rmail.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all slots !!", Toast.LENGTH_LONG);
        }
        else if(radd.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all slots !!", Toast.LENGTH_LONG);
        }
        else if(rdis.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Fill all slots !!", Toast.LENGTH_LONG);
        }
        else {
            if (r1.isChecked()) {
                mdb.execSQL("Create Table if not exists Patients (pname varchar(30),mob int,email varchar(20),addr varchar(30),disb varchar(30));");
                mdb.execSQL("insert into Patients('" + rpname.getText().toString() + "'," + rmob.getText().toString() + ",'" + rmail.getText().toString() + "','" + radd.getText().toString() + "','" + rdis.getText().toString() + ");");
            } else if (r2.isChecked()) {
                mdb.execSQL("Create Table if not exists CareGivers (pname varchar(30),mob int,email varchar(20),addr varchar(30),disb varchar(30));");
                mdb.execSQL("insert into CareGivers('" + rpname.getText().toString() + "'," + rmob.getText().toString() + ",'" + rmail.getText().toString() + "','" + radd.getText().toString() + "','" + rdis.getText().toString() + ");");
            } else {
                Toast.makeText(getApplicationContext(), "Check as Patient or CareGivers !!", Toast.LENGTH_LONG);
            }
        }
    }
}