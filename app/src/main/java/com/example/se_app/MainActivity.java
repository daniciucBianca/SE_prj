package com.example.se_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnLogIn;
    private TextView txtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogInPage.class);
                startActivity(intent);
            }
        });


    } // function onCreate()

    private void initViews(){
        btnLogIn = findViewById(R.id.btnLogIn);
        txtRegister = findViewById(R.id.txtRegister);
    }
}