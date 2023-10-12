package com.example.vecare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    DatabaseReference dbr= FirebaseDatabase.getInstance().getReferenceFromUrl("https://ve-care-9d10f-default-rtdb.firebaseio.com/");
    EditText unm;
    Button rb,lb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        FirebaseApp.initializeApp(this);
        unm=(EditText) findViewById(R.id.unm);
        rb=(Button) findViewById(R.id.btn);
        lb=(Button) findViewById(R.id.login);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rClicked(view);
            }
        });
    }
    public void rClicked(View v)
    {
        if(rb.getText().toString().equals("Login"))
        {

        }
        else
        {
            dbr.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    dbr.child("users").child("Username").setValue(unm);
                    Toast.makeText(getApplicationContext(),"Registred",Toast.LENGTH_LONG).show();
                    finish();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
    public void lClicked(View v)
    {
        rb.setText("Login");
    }
}