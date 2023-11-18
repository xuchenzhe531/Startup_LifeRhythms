package com.cs407.myapplication;

public class Calendar {

    private String date;
    private String username;
    private String startHour;
    private String startMinute;
    private String endHour;
    private String endMinute;
    private String category;
    private String toDo;



    public Calendar(String date, String username, String startHour, String startMinute, String endHour, String endMinute, String category, String toDo){
        this.date = date;
        this.username = username;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.category = category;
        this.toDo = toDo;

    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public String getStartHour() {
        return startHour;
    }

    public String getStartMinute() {
        return startMinute;
    }

    public String getEndHour() {
        return endHour;
    }

    public String getEndMinute() {
        return endMinute;
    }

    public String getCategory() {
        return category;
    }

    public String getToDo() {
        return toDo;
    }
}
