package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mob;
    Button lbtn,register;
    RadioButton r1,r2;

    SQLiteDatabase mdb;
    Cursor res;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mob=(EditText) findViewById(R.id.mob);
        lbtn =(Button) findViewById(R.id.lbtn);
        register=(Button) findViewById(R.id.register);
        rg=(RadioGroup) findViewById(R.id.rg);
        mdb=openOrCreateDatabase("VE CARE",MODE_PRIVATE,null);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mob.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Fill Mobile NO. !!", Toast.LENGTH_LONG);
                }
                int id= rg.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton) findViewById(id);
                if (rb.getText().equals("Patient"))
              {
                    res=mdb.rawQuery("select pname from Patients where mob='"+mob.getText().toString()+"';",null);
                }
                else
                {
                    res=mdb.rawQuery("select pname from CareGivers where mob='"+mob.getText().toString()+"';",null);

                }
                if(res.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "Mobile is not matching !!", Toast.LENGTH_LONG);
                    Intent i=new Intent(getApplicationContext(),Registration.class);
                    startActivity(i);
                }
                else
                {
                    if (rb.getText().equals("Patient"))
                    {
                        res=mdb.rawQuery("select pname from Patients where mob='"+mob.getText().toString()+"';",null);
                        Toast.makeText(getApplicationContext(), "Successfull !!", Toast.LENGTH_LONG);
                        Intent i=new Intent(getApplicationContext(),Home.class);
                        startActivity(i);
                    }
                    else
                    {
                        res=mdb.rawQuery("select pname from CareGivers where mob='"+mob.getText().toString()+"';",null);
                        Toast.makeText(getApplicationContext(), "Successfull !!", Toast.LENGTH_LONG);
                        Intent i=new Intent(getApplicationContext(),CGHome.class);
                       // i.putExtra("name",res.getString(0).toString());
                     //   i.putExtra("mode",rb.getText().toString());
                        startActivity(i);
                    }

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