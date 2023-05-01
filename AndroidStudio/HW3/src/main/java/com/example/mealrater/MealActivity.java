package com.example.mealrater;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MealActivity extends FragmentActivity implements RateDialog.SaveRateDialog {

    private static final String TAG = "MealActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
    }

    private void initButton() {
        Button displayButton = findViewById(R.id.button);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent(MealActivity.this, RateActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP ); //4
                Log.d(TAG,"Starting intent");
                startActivity(intent);
                 */
                FragmentManager fm = getSupportFragmentManager();
                RateDialog rateDialog = new RateDialog();;
                rateDialog.show(fm,"Select Rating");
            }
        });
    }

    @Override
    public void didFinish(float selectedStars) {
        TextView rate = findViewById(R.id.rate2);
        String stars = "" +selectedStars+ " / 5 stars!";
        rate.setText(stars);
    }
}
