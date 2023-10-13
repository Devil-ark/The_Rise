package com.example.projectx;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.*;

public class CGHome extends AppCompatActivity {

    EditText cd,mob;
    Button snd;
    String mob1,mob2,mob3,mob4,mob5;
    TextView nm;

    SQLiteDatabase mdb;
    Cursor res;
    CheckBox c1,c2,c3,c4,c5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cghome);
        cd=(EditText) findViewById(R.id.cd);
        mob=(EditText) findViewById(R.id.mob);
        snd=(Button)findViewById(R.id.snd);
        c1=(CheckBox) findViewById(R.id.c1);
        c2=(CheckBox) findViewById(R.id.c2);
        c3=(CheckBox) findViewById(R.id.c3);
        c4=(CheckBox) findViewById(R.id.c4);
        c5=(CheckBox) findViewById(R.id.c5);
        mob1="8600319978";
        mob2="7820919769";
        mob3="7447337666";
        mob4="7588338042";
        mob5="7030885945";
        snd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(mob.getText().toString(), null, "Check for Confirmation where code is "+cd.getText().toString(), null, null);
                if(c1.isChecked())
                {
                    smsManager.sendTextMessage(mob1, null, "I am conforming the request of "+cd.getText().toString(), null, null);
                }
                if(c2.isChecked())
                {
                    smsManager.sendTextMessage(mob2, null, "I am conforming the request of "+cd.getText().toString(), null, null);
                }
                if(c3.isChecked())
                {
                    smsManager.sendTextMessage(mob3, null, "I am conforming the request of "+cd.getText().toString(), null, null);
                }
                if(c4.isChecked())
                {
                    smsManager.sendTextMessage(mob4, null, "I am conforming the request of "+cd.getText().toString(), null, null);
                }
                if(c5.isChecked())
                {
                    smsManager.sendTextMessage(mob5, null, "I am conforming the request of "+cd.getText().toString(), null, null);
                }
            }
        });
    }
}