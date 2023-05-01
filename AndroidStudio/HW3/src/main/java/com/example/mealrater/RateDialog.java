package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;

public class RateDialog extends DialogFragment {
    float selectedStars;
        public interface SaveRateDialog{
            void didFinish(float selectedStars);
        }
        public RateDialog(){

        }

        public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState){
            final View view = inflator.inflate(R.layout.activity_rate, container);

            getDialog().setTitle("Select Rating");
            final RatingBar rd = view.findViewById(R.id.ratingBar);
            rd.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    selectedStars = ratingBar.getRating();
                }
            });
            Button saveButton = view.findViewById(R.id.buttonSave);
            saveButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveItem(selectedStars);
                }
            });
            return view;
        }
        private void saveItem(float selectedStars) { //6
            SaveRateDialog activity = (SaveRateDialog) getActivity();
            activity.didFinish(selectedStars);
            getDialog().dismiss();
        }
    }
