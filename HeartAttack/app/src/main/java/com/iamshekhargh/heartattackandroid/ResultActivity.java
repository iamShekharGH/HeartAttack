package com.iamshekhargh.heartattackandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";

    TextView index ;
    TextView resultDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        overridePendingTransition(R.animator.slide_in_right,R.animator.slide_out_left);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();



        index = (TextView) findViewById(R.id.textView_index);
        resultDisplay = (TextView) findViewById(R.id.textView_resultAnswer);
        int indx = settings.getInt("index",0);
        String aa = String.valueOf(indx);
        index.append(aa);

        Intent intent = getIntent();
        //String per = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int peri = intent.getIntExtra(MainActivity.EXTRA_MESSAGE,0);
        Log.d("ResultDisplay","percentage passed   ::"+peri);




        TextView textView = new TextView(this);
        textView.setTextSize(60);
        textView.setText(peri+"%");
        resultDisplay.setText("Your Chances of a HeartAttach are "+peri+"%");

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_result);
        //layout.addView(textView);
        if(peri <= 25) {
            layout.setBackgroundColor(Color.rgb(0, 255, 0));
        }else if (peri <= 50){
            layout.setBackgroundColor(Color.rgb(255, 255, 0));
        }else if (peri <= 75){
            layout.setBackgroundColor(Color.rgb(50, 205, 50));
        }else if (peri <= 100){
            layout.setBackgroundColor(Color.rgb(255, 0, 0));
        }
    }

}
