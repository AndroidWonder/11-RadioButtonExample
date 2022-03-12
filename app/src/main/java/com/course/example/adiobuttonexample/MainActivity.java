package com.course.example.adiobuttonexample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView simpleList;
    ArrayList<String> questions;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide title and icon in action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);

        //create ArrayList and add data
        questions = new ArrayList<String>();
        questions.add("Do you have Aerosmith's latest album?");
        questions.add("Are you ready for dinner yet?");
        questions.add("Do you want the door open?");
        questions.add("Want to take a walk later?");

        simpleList = (ListView) findViewById(R.id.simpleListView);
        submit = (Button) findViewById(R.id.submit);

        // set the adapter to fill the data in the ListView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), questions);
        simpleList.setAdapter(customAdapter);

        //listen for button click
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Answers Selected \n";
                // get the value of selected answers from custom adapter
                for (int i = 0; i < CustomAdapter.getSelectedAnswers().size(); i++) {
                    message = message + "\n" + (i + 1) + " " + CustomAdapter.getSelectedAnswers().get(i);
                }
                // display the message with toast
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //check menu selection
        if (id == R.id.exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
