package com.example.sergiu.whereiscar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AplicationActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button butonAdaugaPetitie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplication);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }


        //initializing views
        //textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.btn_log_out);
        butonAdaugaPetitie = (Button) findViewById(R.id.btn_adaugaPetitie);

        //getting current user
        //FirebaseUser user = firebaseAuth.getCurrentUser();
        //displaying logged in user name
        //Toast.makeText(AplicationActivity.this, "Welcome " + user.getEmail(), Toast.LENGTH_LONG).show();
        buttonLogout.setOnClickListener(this);
        butonAdaugaPetitie.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        switch (view.getId()) {
            case R.id.btn_log_out:
                //logging out the user
                firebaseAuth.signOut();
                //closing activity
                System.out.println("Button nu se apasa");
                Toast.makeText(AplicationActivity.this, "Button log out ", Toast.LENGTH_LONG).show();
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
            break;
            case R.id.btn_adaugaPetitie:
                Intent uploadActivityintent = new Intent(this, UploadImage.class);
                startActivity(uploadActivityintent);
        }
    }
}
