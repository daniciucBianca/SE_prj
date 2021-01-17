package com.example.se_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LogInPage extends AppCompatActivity {
    private Button loginBtn ;
    private TextView usernameTxtView;
    private TextView passwordTxtView;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        initShow();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    Student student;
                    if(user.equals("") || pass.equals("")){
                        Toast.makeText(LogInPage.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    }
                    else{
//                        if(checkUsernamePassword(user, pass) == true){
//                            Toast.makeText(LogInPage.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(getApplicationContext(), StudentAccount.class);
//                            startActivity(intent);
//                        } else{
//                            Toast.makeText(LogInPage.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
//                        }

                        if(user.equals("maria.dascalu") && pass.equals("dascalu1234")) {
                            Toast.makeText(LogInPage.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), TeacherAccount.class);
                            startActivity(intent);
                        }
//                         else if(user.equals(student.getUsername().toString()) && pass.equals(student.getPassword().toString())){
//
//                        }
                            else if(user.equals("bianca.daniciuc") && pass.equals("daniciuc1234")){
                            Toast.makeText(LogInPage.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), StudentAccount.class);
                            startActivity(intent);
                            }
                        else{
                            Toast.makeText(LogInPage.this, "Incorrect username or password, try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
//             
            }
        });
    }

    private void initShow(){
        loginBtn = findViewById(R.id.button);
        usernameTxtView = findViewById(R.id.usernameTxtView);
        passwordTxtView = findViewById(R.id.passwordTxtView);
        username = findViewById(R.id.usernameTxt);
        password = findViewById(R.id.passwordTxt);
    }
}