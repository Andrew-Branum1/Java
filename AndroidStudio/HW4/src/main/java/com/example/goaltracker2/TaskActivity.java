package com.example.goaltracker2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {


    private static final String TAG = "TaskActivity";
    private Task currentTask = new Task();
    private int id = 1;
    ArrayList<Task> names;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        initButton();
        initTButton();
        TaskDataSource ds = new TaskDataSource(this);
        //ArrayList<String> names;
        try{
            ds.open();
            names = ds.getTasks();
            Log.d(TAG,"Names: " +names);
            ds.close();
            RecyclerView taskList = findViewById(R.id.rec);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            taskList.setLayoutManager(layoutManager);
            TaskAdapter taskAdapter = new TaskAdapter(names, this);
            taskAdapter.setOnItemClickListener(onItemClickListener);
            taskList.setAdapter(taskAdapter);
        }
        catch (Exception e){
            Toast.makeText(this, "Error retreiving tasks", Toast.LENGTH_LONG).show();
        }

    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            int taskId = names.get(position).getId();
            Intent intent = new Intent(TaskActivity.this, AddActivity.class);
            intent.putExtra("tId", taskId);
            intent.putExtra("t", "task");
            Log.d(TAG,"taskID: " +taskId);
            startActivity(intent);
        }
    };


    private void initButton() {
        Button displayButton = findViewById(R.id.add);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TaskActivity.this, AddActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ); //4
                intent.putExtra("id", id);
                Log.d(TAG,"Starting intent");
                startActivity(intent);
            }
        });
    }

    private void initTButton() {
        Button displayButton = findViewById(R.id.goals);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TaskActivity.this, GoalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ); //4
                Log.d(TAG,"Starting intent");
                startActivity(intent);
            }
        });
    }

}