package com.example.vec;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button btnRegister,btnHomeLogIn;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnHomeLogIn=findViewById(R.id.btn_homelogin);
        btnRegister=findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),RegisterActivity.class)));
        btnHomeLogIn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),InspectionPage.class)));



    }


    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}