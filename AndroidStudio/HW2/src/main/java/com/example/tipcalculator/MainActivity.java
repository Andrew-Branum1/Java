package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton18();
        initButton20();
        initButton22();
    }

    private void initButton18() {
        Button displayButton = findViewById(R.id.button15);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = findViewById(R.id.tip);
                TextView textDisplay = findViewById(R.id.textView);
                float tipToDisplay = Float.valueOf(editName.getText().toString());
                float tipA = (float) ((tipToDisplay * 0.18));
                tipToDisplay = (float) ((tipToDisplay * 0.18) + tipToDisplay);
                String tip = "" +  String.format("%.2f", tipToDisplay);
                String tip2 = "" +  String.format("%.2f", tipA);
                textDisplay.setText("Tip: $"+tip2 + ", Total Bill: $" +tip+ "");
            }
        });
    }
    private void initButton20() {
        Button displayButton = findViewById(R.id.button18);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = findViewById(R.id.tip);
                TextView textDisplay = findViewById(R.id.textView);
                float tipToDisplay = Float.valueOf(editName.getText().toString());
                float tipA = (float) ((tipToDisplay * 0.2));
                tipToDisplay = (float) ((tipToDisplay * 0.2) + tipToDisplay);
                String tip = "" + String.format("%.2f", tipToDisplay);
                String tip2 = "" +  String.format("%.2f", tipA);
                textDisplay.setText("Tip: $"+tip2 + ", Total Bill: $" +tip+ "");
            }
        });
    }
    private void initButton22() {
        Button displayButton = findViewById(R.id.button20);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = findViewById(R.id.tip);
                TextView textDisplay = findViewById(R.id.textView);
                float tipToDisplay = Float.valueOf(editName.getText().toString());
                float tipA = (float) ((tipToDisplay * 0.22));
                tipToDisplay = (float) ((tipToDisplay * 0.22) + tipToDisplay);
                String tip = "" +  String.format("%.2f", tipToDisplay);
                String tip2 = "" +  String.format("%.2f", tipA);
                textDisplay.setText("Tip: $"+tip2 + ", Total Bill: $" +tip+ "");
            }
        });
    }
}