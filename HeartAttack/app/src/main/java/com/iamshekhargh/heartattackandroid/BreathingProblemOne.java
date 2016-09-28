package com.iamshekhargh.heartattackandroid;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class BreathingProblemOne extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.iamshekhargh.heartattackandroid";
    public static final String PREFS_NAME = "PatientDatabase";
    RadioButton notAtAll;
    RadioButton yes;
    ImageButton imageButton;
    boolean breathingProblem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_problem_one);
        notAtAll = (RadioButton) findViewById(R.id.radioButton8);
        yes = (RadioButton) findViewById(R.id.radioButton7);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();

                int temp = settings.getInt("index" , -1);
                if(temp <0){
                    editor.putInt("index" , 0);
                    editor.commit();

                }
                else {
                    temp++;
                    editor.putInt("index" , temp);
                    editor.commit();
                }




            }
        });






    }

    public void breathingClick(View view){
        if (view.getId() == R.id.radioButton8) breathingProblem = false ;
        if (view.getId() == R.id.radioButton7) breathingProblem = true ;


    }
}
