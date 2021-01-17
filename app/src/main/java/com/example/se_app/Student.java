package com.example.se_app;

public class Student {
        private String name;
        private String surname;
        private String group;
        private String username;
        private String password;
        private String id;
        private String imageUrl;
        private String attendanceNumber;
        private boolean isExpanded;


    public Student(String name, String surname, String group, String username, String password, String id, String imageUrl, String attendanceNumber) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.username = username;
        this.password = password;
        this.id = id;
        this.imageUrl = imageUrl;
        this.attendanceNumber = attendanceNumber;
        isExpanded = false;
    }

    public boolean isExpanded(){
        return isExpanded;
    }
    public void setExpanded(boolean expanded){
        isExpanded= expanded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAttendanceNumber() {
        return attendanceNumber;
    }

    public void setAttendanceNumber(String attendanceNumber) {
        this.attendanceNumber = attendanceNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + group + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
