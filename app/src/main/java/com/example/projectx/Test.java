package com.example.projectx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.Random;

public class Test extends AppCompatActivity {

    String mob1,mob2,mob3,mob4,mob5;
    String mail1,mail2,mail3,mail4,mail5;

    SQLiteDatabase mdb;
    Cursor res;

    Random rdm ;
    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdm=new Random();
        c=rdm.nextInt(100000);

        mob1="8600319978";
        mob2="7820919769";
        mob3="7447337666";
        mob4="7588338042";
        mob5="7030885945";

        mail1=mail2=mail3=mail4=mail5="sushantsambekar@gmail.com";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail1});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Helath Issue");
        intent.putExtra(Intent.EXTRA_TEXT, "User has Helath Issue and code is : "+c);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, null));

        SmsManager smsManager = SmsManager.getDefault();
        Intent smsi= new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, smsi, PendingIntent.FLAG_IMMUTABLE);
        smsManager.sendTextMessage(mob1, null, "User has Helath Issue and code is : "+c, pi, null);
        smsManager.sendTextMessage(mob2, null, "User has Helath Issue and code is : "+c, pi, null);
        smsManager.sendTextMessage(mob3, null, "User has Helath Issue and code is : "+c, pi, null);
        smsManager.sendTextMessage(mob4, null, "User has Helath Issue and code is : "+c, pi, null);
        smsManager.sendTextMessage(mob5, null, "User has Helath Issue and code is : "+c, pi, null);

        Toast.makeText(getApplicationContext(), "Successfull !!", Toast.LENGTH_LONG);

    }
}