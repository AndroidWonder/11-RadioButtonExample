package com.course.example.adiobuttonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> questionsList;

    private static ArrayList<String> selectedAnswers;

    public static ArrayList<String> getSelectedAnswers(){
        return selectedAnswers;
    }

    public CustomAdapter(Context applicationContext, ArrayList<String> questionsList) {
        this.context = applicationContext;
        this.questionsList = questionsList;

        // initialize arraylist and add static string for all the questions
        selectedAnswers = new ArrayList<String>();
        for (int i = 0; i < questionsList.size(); i++) {
            selectedAnswers.add("No Answer");
        }
    }

    @Override
    public int getCount() {
        return questionsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
       view =  LayoutInflater.from(this.context).inflate(R.layout.rows, null);

        TextView question = (TextView) view.findViewById(R.id.question);
        RadioButton yes = (RadioButton) view.findViewById(R.id.yes);
        RadioButton no = (RadioButton) view.findViewById(R.id.no);

        // perform setOnCheckedChangeListener event on yes button
        yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(i, "Yes");
            }
        });

        // perform setOnCheckedChangeListener event on no button
        no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set No values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(i, "No");

            }
        });

        // set the value in TextView
        question.setText(questionsList.get(i));
        return view;
    }
}
