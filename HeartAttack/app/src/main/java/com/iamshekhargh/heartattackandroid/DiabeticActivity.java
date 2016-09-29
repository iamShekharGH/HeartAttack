package com.iamshekhargh.heartattackandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class DiabeticActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.iamshekhargh.heartattackandroid";
    public static final String PREFS_NAME = "PatientDatabase";
    boolean diabetic_boolean;
    ImageView diabetic_imageView;
    ImageView sweets_imageView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diabetic);

        diabetic_imageView = (ImageView) findViewById(R.id.imageView_diabetes);
        sweets_imageView = (ImageView) findViewById(R.id.imageView_sweets);

        imageButton= (ImageButton) findViewById(R.id.imageButton7);



        diabetic_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diabetic_imageView.setBackgroundColor(Color.GRAY);
                sweets_imageView.setBackgroundColor(Color.parseColor("#92b06a"));
                diabetic_boolean = true;

            }
        });

        sweets_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diabetic_imageView.setBackgroundColor(Color.parseColor("#92b06a"));
                sweets_imageView.setBackgroundColor(Color.GRAY);
                diabetic_boolean = false;

            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();

                int temp = settings.getInt("index" , -1);
                editor.putBoolean("Diabetic"+temp,diabetic_boolean);
                editor.commit();

                boolean breathingTemp;
                Integer ageTemp;
                boolean genderTemp;
                boolean diabeticTemp;
                Integer percentage = 0;



                breathingTemp = settings.getBoolean("problemBreathing"+temp , false);
                ageTemp = settings.getInt("Age"+temp , -1);
                genderTemp = settings.getBoolean("gender"+temp,false);
                diabeticTemp = settings.getBoolean("Diabetic"+temp,false);

                TableStore tempTable = new TableStore(Integer.parseInt(String.valueOf(ageTemp)), breathingTemp , genderTemp , diabeticTemp );
                tempTable.save();

                if (breathingTemp) percentage += 25;
                if (ageTemp > 29) percentage += 25;
                if (genderTemp) percentage += 25;
                if (diabeticTemp) percentage += 25;
                launchResultActivity(percentage);




                overridePendingTransition(R.animator.slide_in_right,R.animator.slide_out_left);

            }
        });







    }

    private void launchResultActivity(int percentage) {
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("com.example.myfirstapp.MESSAGE" , percentage);
        startActivity(intent);
    }


}
