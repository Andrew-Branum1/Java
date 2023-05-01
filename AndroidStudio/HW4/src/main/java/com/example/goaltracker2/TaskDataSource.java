package com.example.goaltracker2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TaskDataSource {
    private SQLiteDatabase database;
    private TaskDBHelper dbHelper;

    public TaskDataSource(Context context) {
        dbHelper = new TaskDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertTask(Task c) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("name", c.getName());
            initialValues.put("des", c.getDesc());
            initialValues.put("date", c.getDate());

            didSucceed = database.insert("task", null, initialValues) > 0;
        } catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public Task getSpecTask(int taskId) {
        Task task = new Task();
        String query = "SELECT * FROM task WHERE _id =" + taskId;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            task.setId(cursor.getInt(0));
            task.setName(cursor.getString(1));
            task.setDesc(cursor.getString(2));
            task.setDate(cursor.getString(3));
            cursor.close();
        }
        return task;
    }

    public boolean updateTask(Task c) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) c.getId();
            ContentValues updateValues = new ContentValues();

            updateValues.put("name", c.getName());
            updateValues.put("des", c.getDesc());
            updateValues.put("date", c.getDate());


            didSucceed = database.update("task", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastTaskId() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from task";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        try {
            String query = "SELECT * FROM task";
            Cursor cursor = database.rawQuery(query, null);

            Task newTask;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newTask = new Task();
                newTask.setId(cursor.getInt(0));
                newTask.setName(cursor.getString(1));
                newTask.setDesc(cursor.getString(2));
                newTask.setDate(cursor.getString(3));
                tasks.add(newTask);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            tasks = new ArrayList<Task>();
        }
        return tasks;
    }
    public boolean deleteTask(int Id){
        boolean d = false;
        try{
            d = database.delete("task","_id=" + Id, null)>0;
        }
        catch(Exception e){

        }
        return d;
    }
}
