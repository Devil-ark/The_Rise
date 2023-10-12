package com.example.project_vc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mob;
    Button lbtn,register;
    RadioButton r1,r2;

    SQLiteDatabase mdb;
    Cursor res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mob=(EditText) findViewById(R.id.mob);
        lbtn =(Button) findViewById(R.id.lbtn);
        register=(Button) findViewById(R.id.register);
        r1=(RadioButton) findViewById(R.id.r1);
        r1=(RadioButton) findViewById(R.id.r2);
        mdb=openOrCreateDatabase("VE CARE",MODE_PRIVATE,null);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mob.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fill Mobile NO. !!", Toast.LENGTH_LONG);
                }
                if(r1.isChecked())
                {
                    res=mdb.rawQuery("select * from Patients where mob="+mob.getText().toString()+";",null);
                }
                else
                {
                    res=mdb.rawQuery("select * from CareGivers where mob="+mob.getText().toString()+";",null);

                }
                if(res.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "Mobile is not matching !!", Toast.LENGTH_LONG);
                    Intent i=new Intent(getApplicationContext(),Registration.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Successfull !!", Toast.LENGTH_LONG);
                    Intent i=new Intent(getApplicationContext(),Home.class);
                    startActivity(i);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });
    }
}