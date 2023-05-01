package com.example.goaltracker2;

import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.RatingBar;

        import androidx.fragment.app.DialogFragment;

public class AddDialog extends DialogFragment {

    private Goal currentGoal = new Goal();

    public interface SaveAddDialog{
        void didFinish();
    }
    public AddDialog(){

    }

    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle savedInstanceState){
        final View view = inflator.inflate(R.layout.activity_add, container);
        Button saveButton = view.findViewById(R.id.button);
        saveButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem();
            }
        });
        return view;
    }
    private void saveItem() { //6
        SaveAddDialog activity = (SaveAddDialog) getActivity();
        activity.didFinish();
        getDialog().dismiss();
    }
}
