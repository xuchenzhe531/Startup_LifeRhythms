package com.cs407.myapplication;

import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DBHelper {
    static SQLiteDatabase sqLiteDatabase;

    public DBHelper(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS calendars " +
                "(id INTEGER PRIMARY KEY, username TEXT, date TEXT, startHour TEXT, startMinute TEXT, endHour TEXT, endMinute TEXT, category TEXT, toDo TEXT ,src TEXT)");
    }

    public ArrayList<Calendar> readCalendars(String username) {

        createTable();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * from calendars where username like ?", new String[]{"%" + username + "%"});

        int dateIndex = c.getColumnIndex("date");
        int startHourIndex = c.getColumnIndex("startHour");
        int startMinuteIndex = c.getColumnIndex("startMinute");
        int endHourIndex = c.getColumnIndex("endHour");
        int endMinuteIndex = c.getColumnIndex("endMinute");
        int categoryIndex = c.getColumnIndex("category");
        int toDoIndex = c.getColumnIndex("toDo");

        c.moveToFirst();

        ArrayList<Calendar> CalendarList = new ArrayList<>();

        while (!c.isAfterLast()) {
            String startHour = c.getString(startHourIndex);
            String date = c.getString(dateIndex);
            String startMinute = c.getString(startMinuteIndex);
            String endHour = c.getString(endHourIndex);
            String endMinute = c.getString(endMinuteIndex);
            String category = c.getString(categoryIndex);
            String toDo = c.getString(toDoIndex);

            Calendar note = new Calendar(date, username, startHour, startMinute, endHour, endMinute, category, toDo);
            CalendarList.add(note);
            c.moveToNext();
        }
        c.close();
        sqLiteDatabase.close();

        return CalendarList;
    }

    public void saveCalender(String date, String username, String startHour, String startMinute, String endHour, String endMinute, String category, String toDo) {
        createTable();
        sqLiteDatabase.execSQL("INSERT INTO calendars (date, username, startHour, startMinute, endHour, endMinute, category, toDo) VALUES (?, ?, ?, ?, ?,?,?,?)",
                new String[]{date, username, startHour, startMinute, endHour, endMinute, category, toDo});
    }

//    public void updateNote(String title, String date, String content, String username) {
//        createTable();
//        sqLiteDatabase.execSQL("UPDATE notes set content = ?, date = ? where title = ? and username = ?",
//                new String[]{content, date, title, username});
//    }
//
//    public void deleteNotes(String content, String title) {
//        createTable();
//        String date = "";
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT date FROM notes WHERE content = ?",
//                new String[]{content});
//
//        if (cursor.moveToNext()) {
//            date = cursor.getString(0);
//        }
//
//        sqLiteDatabase.execSQL("DELETE FROM notes WHERE content = ? AND date = ?",
//                new String[]{content, date});
//        cursor.close();
//    }
}
