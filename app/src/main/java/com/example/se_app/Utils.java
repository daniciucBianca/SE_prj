package com.example.se_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private SharedPreferences sharedPreferences;
    private static final String ALL_STUDENTS = "all_students";

    public  ArrayList<Student> getAllStudents() {
//
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Student>>(){}.getType();
        ArrayList<Student> students = gson.fromJson(sharedPreferences.getString(ALL_STUDENTS, null), type);
        return students;
    }

    // Utils constructor
    public Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        if(null == getAllStudents()){
            initData();
        }
    }


    private void initData(){
        ArrayList<Student> students= new ArrayList<>();

        students.add(new Student("Bianca", "Daniciuc", "1240F", "bianca.daniciuc", "daniciuc1234", "FILS01", "https://w7.pngwing.com/pngs/666/201/png-transparent-computer-icons-woman-women-s-day-face-holidays-head-thumbnail.png", "10"));
        students.add(new Student("Cedric", "Fohom", "1240F", "cedric.fohom", "fohom1234", "FILS02", "https://cdn3.iconfinder.com/data/icons/avatar-set/512/Avatar02-512.png", "9"));
        students.add(new Student("Christian", "Bankoue", "1240F", "christian.bankoue", "bankoue1234", "FILS03", "https://cdn3.iconfinder.com/data/icons/avatar-set/512/Avatar02-512.png", "8"));


        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String text =  gson.toJson(students); // deserialization
        editor.putString(ALL_STUDENTS, text);

        //apply the changes:
        editor.commit();
    }

    public static synchronized Utils getInstance(Context context) {
        if(null != instance){
            return instance;
        } else{
            instance = new Utils(context);
            return instance;
        }
    }

    public Student getStudentById(String id){
        ArrayList<Student> students = getAllStudents();
        if(null != students){
            for(Student s: students){
                if(s.getId().equals(id)){
                    return s;
                }
            }
        }
        return null;
    }

    public Student  checkUsernamePassword(String username, String password){
       ArrayList<Student> students = getAllStudents();
       if( null != students){
           for(Student s: students){
               if(s.getUsername().equals(username) && s.getPassword().equals(password)){
                   return s;
               }
           }
       }
       return  null;
    }
}
