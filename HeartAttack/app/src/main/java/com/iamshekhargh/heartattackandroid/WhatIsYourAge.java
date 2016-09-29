package com.iamshekhargh.heartattackandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class WhatIsYourAge extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.iamshekhargh.heartattackandroid";
    public static final String PREFS_NAME = "PatientDatabase";
    EditText age_editText;
    Integer age_integer;
    ImageButton submit_button;
    ImageButton goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_what_is_your_age);
        overridePendingTransition(R.animator.slide_in_right,R.animator.slide_out_left);

        age_editText = (EditText) findViewById(R.id.editText2);
        submit_button = (ImageButton) findViewById(R.id.imageButton4);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                submit_button.setBackgroundColor(Color.parseColor("#4298b5"));

                int temp = settings.getInt("index" , -1);



                String age_string = age_editText.getText().toString();
                age_integer = Integer.parseInt(age_string);
                editor.putInt("Age"+temp,age_integer);
                editor.commit();

                launchGenderActivity();









            }
        });





    }

    private void launchGenderActivity() {
        Intent intent = new Intent(this,YouAGuy.class);
        startActivity(intent);
    }
}
