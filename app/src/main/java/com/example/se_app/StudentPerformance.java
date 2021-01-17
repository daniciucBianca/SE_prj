package com.example.se_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StudentPerformance extends AppCompatActivity {
    public static final String STUDENT_ID_KEY = "studentId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_performance);
    }
}