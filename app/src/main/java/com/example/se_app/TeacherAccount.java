package com.example.se_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TeacherAccount extends AppCompatActivity {
    private ImageView imageView;
    private TextView txtTeacher, txtTeacherID;
    Button btnSE, btnSDA, btnMTDL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_account);
        initShow();
    }

    private void initShow(){
        imageView = findViewById(R.id.avatarTeacher);
        txtTeacher = findViewById(R.id.txtTeacher);
        txtTeacherID = findViewById(R.id.txtTeacherID);

        btnMTDL = findViewById(R.id.btnMTDL);
        btnSE = findViewById(R.id.btnSE);
        btnSDA = findViewById(R.id.btnSDA);

        btnSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherAccount.this, AllStudentsActivity.class);
                startActivity(intent);
            }
        });

    }
}