package com.example.goaltracker2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class GoalActivity extends AppCompatActivity {
    private static final String TAG = "GoalActivity";
    private Goal currentGoal = new Goal();
    private int id = 1;
    ArrayList<Goal> names;
    GoalAdapter goalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        initTButton();
        GoalDataSource ds = new GoalDataSource(this);
        //ArrayList<String> names;
        try{
            ds.open();
            names = ds.getGoals();
            Log.d(TAG,"Names: " +names);
            ds.close();
            RecyclerView goalList = findViewById(R.id.rec);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            goalList.setLayoutManager(layoutManager);
            GoalAdapter goalAdapter = new GoalAdapter(names, this);
            goalAdapter.setOnItemClickListener(onItemClickListener);
            goalList.setAdapter(goalAdapter);
        }
        catch (Exception e){
            Toast.makeText(this, "Error retreiving goals", Toast.LENGTH_LONG).show();
        }

    }

    private View.OnClickListener onItemClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            int goalId = names.get(position).getId();
            Intent intent = new Intent(GoalActivity.this, AddActivity.class);
            intent.putExtra("gId", goalId);
            intent.putExtra("g", 1);
            Log.d(TAG,"goalId: " +goalId);
            startActivity(intent);
        }
    };


    private void initButton() {
        Button displayButton = findViewById(R.id.add);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GoalActivity.this, AddActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ); //4
                intent.putExtra("id", id);
                Log.d(TAG,"Starting intent");
                startActivity(intent);
            }
        });
    }

    private void initTButton() {
        Button displayButton = findViewById(R.id.tasks);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(GoalActivity.this, TaskActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ); //4
                Log.d(TAG,"Starting intent");
                startActivity(intent);
            }
        });
    }

}