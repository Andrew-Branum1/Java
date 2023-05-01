package com.example.goaltracker2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class GoalDataSource {
    private SQLiteDatabase database;
    private GoalDBHelper dbHelper;

    public GoalDataSource(Context context) {
        dbHelper = new GoalDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertGoal(Goal c) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("name", c.getName());
            initialValues.put("des", c.getDesc());
            initialValues.put("date", c.getDate());

            didSucceed = database.insert("goal", null, initialValues) > 0;
        } catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public Goal getSpecGoal(int goalId) {
        Goal goal = new Goal();
        String query = "SELECT * FROM goal WHERE _id =" + goalId;
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            goal.setId(cursor.getInt(0));
            goal.setName(cursor.getString(1));
            goal.setDesc(cursor.getString(2));
            goal.setDate(cursor.getString(3));
            cursor.close();
        }
        return goal;
    }

    public boolean updateGoal(Goal c) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) c.getId();
            ContentValues updateValues = new ContentValues();

            updateValues.put("name", c.getName());
            updateValues.put("des", c.getDesc());
            updateValues.put("date", c.getDate());


            didSucceed = database.update("goal", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            //Do nothing -will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastGoalId() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from goal";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }

    public ArrayList<Goal> getGoals() {
        ArrayList<Goal> goals = new ArrayList<Goal>();
        try {
            String query = "SELECT * FROM goal";
            Cursor cursor = database.rawQuery(query, null);

            Goal newGoal;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newGoal = new Goal();
                newGoal.setId(cursor.getInt(0));
                newGoal.setName(cursor.getString(1));
                newGoal.setDesc(cursor.getString(2));
                newGoal.setDate(cursor.getString(3));
                goals.add(newGoal);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            goals = new ArrayList<Goal>();
        }
        return goals;
    }
    public boolean deleteGoal(int Id){
        boolean d = false;
        try{
            d = database.delete("goal","_id=" + Id, null)>0;
        }
        catch(Exception e){

        }
        return d;
    }
}