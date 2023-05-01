package cse470.helloworld;

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
        initGreetButton();
        initClearButton();
    }

    private void initGreetButton() {
        Button displayButton = findViewById(R.id.button);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = findViewById(R.id.firstname);
                TextView textDisplay = findViewById(R.id.textView);
                String nameToDisplay = editName.getText().toString();
                EditText editName2 = findViewById(R.id.lastname);
                String nameToDisplay2 = editName2.getText().toString();
                textDisplay.setText("Hello " + nameToDisplay + " "+ nameToDisplay2);
            }
        });
    }

    private void initClearButton() {
        Button displayButton = findViewById(R.id.clear);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textDisplay = findViewById(R.id.textView);
                textDisplay.setText("Hello World!");
            }
        });
    }

}

