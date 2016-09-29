package com.iamshekhargh.heartattackandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class YouAGuy extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.iamshekhargh.heartattackandroid";
    public static final String PREFS_NAME = "PatientDatabase";
    boolean gender_boolean;
//    RadioButton handsome;
//    RadioButton gorgeous;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_you_aguy);

//        handsome = (RadioButton) findViewById(R.id.radioButton10);
//        gorgeous = (RadioButton) findViewById(R.id.radioButton9);

        imageButton = (ImageButton) findViewById(R.id.imageButton5);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                int temp = settings.getInt("index" , -1);
                editor.putBoolean("gender"+temp,gender_boolean);
                editor.commit();

                launchDiabeticActivity();
                overridePendingTransition(R.animator.slide_in_right,R.animator.slide_out_left);


            }
        });




    }

    private void launchDiabeticActivity() {
        Intent intent = new Intent(this,DiabeticActivity.class);
        startActivity(intent);
    }


    public void findOutGender(View view){
        if (view.getId() == R.id.radioButton9) gender_boolean = false ;
        if (view.getId() == R.id.radioButton10) gender_boolean = true ;

    }
}
