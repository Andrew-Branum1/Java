package com.example.goaltracker2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private static final String TAG = "AddActivity";
    private Goal newGoal = new Goal();
    private Task newTask = new Task();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initSaveButton();
        initTextChangedEvents();
        initTextChangedEventsT();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            if(extras.containsKey("g")) {
                initGoal(extras.getInt("gId"));
            }
            else {
                initTask(extras.getInt("tId"));
            }
        }
        else {
            newGoal = new Goal();
            newTask = new Task();
        }
    }


    private void initTextChangedEvents() {
        final EditText goalNameGoal = findViewById(R.id.goal);
        final EditText descNameGoal = findViewById(R.id.desc);
        final EditText dateGoal = findViewById(R.id.expect);

        goalNameGoal.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                newGoal.setName(goalNameGoal.getText().toString());
            }
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        descNameGoal.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                newGoal.setDesc(descNameGoal.getText().toString());
            }
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        dateGoal.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                newGoal.setDate(dateGoal.getText().toString());
            }
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
//    private void initTextChangedEvents() {
//        final EditText goalName = (EditText) findViewById(R.id.goal);
//        goalName.addTextChangedListener(new TextWatcher() {
//
//            public void afterTextChanged(Editable s) {
//                newGoal.setName(goalName.getText().toString());
//            }
//
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                //  Auto-generated method stub
//            }
//
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                //  Auto-generated method stub
//            }
//        });
//
//        final EditText descName = (EditText) findViewById(R.id.desc);
//        descName.addTextChangedListener(new TextWatcher() {
//
//            public void afterTextChanged(Editable s) {
//                newGoal.setDesc(descName.getText().toString());
//            }
//
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                //  Auto-generated method stub
//            }
//
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                //  Auto-generated method stub
//            }
//        });
//
//        final EditText date = (EditText) findViewById(R.id.expect);
//        date.addTextChangedListener(new TextWatcher() {
//
//            public void afterTextChanged(Editable s) {
//                newGoal.setDate(date.getText().toString());
//            }
//
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//                //  Auto-generated method stub
//            }
//
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                //  Auto-generated method stub
//            }
//        });
//
//    }
    private void initTextChangedEventsT() {
        final EditText goalName = (EditText) findViewById(R.id.goal);
        goalName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                newTask.setName(goalName.getText().toString());
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                //  Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  Auto-generated method stub
            }
        });

        final EditText descName = (EditText) findViewById(R.id.desc);
        descName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                newTask.setDesc(descName.getText().toString());
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                //  Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  Auto-generated method stub
            }
        });

        final EditText date = (EditText) findViewById(R.id.expect);
        date.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                newTask.setDate(date.getText().toString());
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                //  Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //  Auto-generated method stub
            }
        });

    }


    private void initSaveButton() {
        Button saveButton = (Button) findViewById(R.id.button);
        Switch mySwitch = (Switch) findViewById(R.id.switch1);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean switchValue = mySwitch.isChecked();
                boolean wasSuccessful;
                if (switchValue) {
                    GoalDataSource ds = new GoalDataSource(AddActivity.this);
                    try {
                        Log.d(TAG, "About to insert");
                        ds.open();
                        Log.d(TAG, "DS opened");
                        if (newGoal.getId() == -1) {
                            wasSuccessful = ds.insertGoal(newGoal);
                            int newId = ds.getLastGoalId();
                            newGoal.setId(newId);
                        } else {
                            wasSuccessful = ds.updateGoal(newGoal);
                        }
                        ds.close();
                    } catch (Exception e) {
                        wasSuccessful = false;
                    }
                    Intent intent = new Intent(AddActivity.this, GoalActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //4
                    Log.d(TAG, "Starting intent");
                    startActivity(intent);
                }
                else{
                    TaskDataSource ds = new TaskDataSource(AddActivity.this);
                    try {
                        Log.d(TAG, "About to insert");
                        ds.open();
                        Log.d(TAG, "DS opened");
                        if (newTask.getId() == -1) {
                            wasSuccessful = ds.insertTask(newTask);
                            int newId = ds.getLastTaskId();
                            newTask.setId(newId);
                        } else {
                            wasSuccessful = ds.updateTask(newTask);
                        }
                        ds.close();
                    } catch (Exception e) {
                        wasSuccessful = false;
                    }
                    Intent intent = new Intent(AddActivity.this, TaskActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //4
                    Log.d(TAG, "Starting intent");
                    startActivity(intent);
                }
            }
    });
    }


    private void initGoal(int id) {
        GoalDataSource ds = new GoalDataSource(AddActivity.this);
        try {
            ds.open();
            newGoal = ds.getSpecGoal(id);
            Log.d(TAG,"newGoal: " +newGoal.getName());
            ds.close();
        }
        catch (Exception e) {
            Toast.makeText(this, "Load Dish Failed", Toast.LENGTH_LONG).show();
        }

        EditText editName = findViewById(R.id.goal);
        EditText editDesc = findViewById(R.id.desc);
        EditText editDate = findViewById(R.id.expect);
        Log.d(TAG,"newGoal: " +newGoal.getName());

        editName.setText(newGoal.getName());
        editDesc.setText(newGoal.getDesc());
        editDate.setText(newGoal.getDate());
    }

    private void initTask(int id) {
        TaskDataSource ds = new TaskDataSource(AddActivity.this);
        try {
            ds.open();
            newTask = ds.getSpecTask(id);
            Log.d(TAG,"newTask: " +newTask);
            ds.close();
        }
        catch (Exception e) {
            Toast.makeText(this, "Load Task Failed", Toast.LENGTH_LONG).show();
        }

        EditText editName = findViewById(R.id.goal);
        EditText editDesc = findViewById(R.id.desc);
        EditText editDate = findViewById(R.id.expect);


        editName.setText(newTask.getName());
        editDesc.setText(newTask.getDesc());
        editDate.setText(newTask.getDate());
    }
}