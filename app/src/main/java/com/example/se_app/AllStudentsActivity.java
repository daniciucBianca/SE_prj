package com.example.se_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllStudentsActivity extends AppCompatActivity {
    private RecyclerView studentsRecView;
    private StudentRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students);
        adapter = new StudentRecViewAdapter(this);
        studentsRecView = findViewById(R.id.studentsRecView);
        studentsRecView.setAdapter(adapter);

        studentsRecView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setStudents(Utils.getInstance(this).getAllStudents());
    }
}