package com.example.goaltracker2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GoalAdapter extends RecyclerView.Adapter {
    private static final String TAG = "GoalAdapter";
    private ArrayList<Goal> goalData;
    private View.OnClickListener myOnItemClickListener;
    private Context parentContext;
    private Boolean isDeleting = true;

    public class GoalViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewGoal;
        public TextView textName2;
        public TextView textDesc2;
        public TextView textDate2;
        public Button deleteButton;

        public GoalViewHolder(@NonNull View itemView){
            super(itemView);
            //textViewDish = itemView.findViewById(R.id.textViewName);
            textName2 = itemView.findViewById(R.id.name2);
            textDesc2 = itemView.findViewById(R.id.desc2);
            textDate2 = itemView.findViewById(R.id.date2);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            itemView.setTag(this);
            itemView.setOnClickListener(myOnItemClickListener);
        }
        public TextView getTextViewGoal() {
            return textViewGoal;
        }

        public TextView getTextName2() {
            return textName2;
        }

        public TextView getDesc2TextView() {
            return textDesc2;
        }
        public TextView getDate2TextView() {
            return textDate2;
        }
        public Button getDeleteButton(){
            return deleteButton;
        }
    }
    public GoalAdapter(ArrayList<Goal> goalList, Context context){

        goalData = goalList;
        Log.d(TAG,"goalData: " +goalData);
        parentContext=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new GoalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        GoalViewHolder dvh = (GoalViewHolder) holder;
        //dvh.getDishTextView().setText(dishData.get(position));
        dvh.getTextName2().setText(goalData.get(position).getName());
        Log.d(TAG,"nameData: " +goalData.get(position).getName());
        dvh.getDesc2TextView().setText(goalData.get(position).getDesc());
        dvh.getDate2TextView().setText(""+ goalData.get(position).getDate());
        dvh.getDeleteButton().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                deleteItem(position);
            }
        });

    }

    @Override
    public int getItemCount() {

        Log.d(TAG, "getItemCount(): " + goalData.size());
        return goalData.size();
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener){
        this.myOnItemClickListener = itemClickListener;
    }

    private void deleteItem(int position) {
        Goal goal = goalData.get(position);
        GoalDataSource ds = new GoalDataSource(parentContext);
        Log.d(TAG,"About to delete");
        try {
            ds.open();
            Log.d(TAG,"DB open");
            boolean d = ds.deleteGoal(goal.getId());
            Log.d(TAG,"Deleted Bool: " +d);
            ds.close();
            if (d) {
                goalData.remove(position);
                notifyDataSetChanged();
            } else {
                Toast.makeText(parentContext, "Delete Failed", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Log.d(TAG,"FAILED");
        }
    }

}

