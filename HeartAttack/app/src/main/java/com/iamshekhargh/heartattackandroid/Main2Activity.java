package com.iamshekhargh.heartattackandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String PREFS_NAME = "MyPrefsFile";



    //Breathing
    RadioButton breatingProblemsYes;
    RadioButton breatingProblemsNo;
    boolean breathing;

    //Age
    EditText age;

    //Gender
    RadioButton genderMen;
    RadioButton genderFemail;
    boolean gender;


    //Diabetic
    RadioButton diabeticYes;
    RadioButton diabeticNo;
    boolean diabetic;

    //Submit
    Button submitdetails;
    MainActivity.Consumer consumer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
