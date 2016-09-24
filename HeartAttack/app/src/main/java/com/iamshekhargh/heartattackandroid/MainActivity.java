package com.iamshekhargh.heartattackandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String PREFS_NAME = "MyPrefsFile";


    class Consumer{
        private boolean breathingProblem;
        private Integer age ;
        private boolean gender;
        private  boolean diabetic;
        private int percentage;
        private int index;
        Consumer(boolean breathingProblem, int age, boolean gender, boolean diabetic){

            this.breathingProblem = breathingProblem;
            this.age = age;
            this.gender = gender ;
            this.diabetic = diabetic ;
            this.percentage = 0;
            if(breathingProblem == false) this.percentage += 25;
            if (age>29) this.percentage +=25;
            if (gender == true) this.percentage +=25;
            if (diabetic == true) this.percentage +=25;
            this.toString();

        }

        @Override
        public String toString() {
            String string = "";
            if (breathingProblem == true){
                string += "You have BreathingProblems\n";
            }else string += "You dont Have BreathingProblemd\n";
            string += "Your Age is"+age+"\n";
            if (diabetic) string += "You are Diabetic\n";
            else string += "You dont Have Diabatese\n";
            if (gender) string += "You are A Guy.\n";
            else string += "You are a Women\n";

            //Toast.makeText(getApplicationContext(),string,Toast.LENGTH_SHORT).show();
            if (string == "")
                return super.toString();
            else
            return string;
        }
    }

    private static ArrayList<Consumer> consumerList = new ArrayList<Consumer>();


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
     Consumer consumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        breatingProblemsYes = (RadioButton) findViewById(R.id.radioButton);
        breatingProblemsNo = (RadioButton) findViewById(R.id.radioButton2);
        breathing = false;

        age = (EditText) findViewById(R.id.editText_age);

        genderMen = (RadioButton) findViewById(R.id.radioButton3);
        genderFemail= (RadioButton) findViewById(R.id.radioButton4);
        gender = true;

        diabeticYes = (RadioButton) findViewById(R.id.radioButton5);
        diabeticNo= (RadioButton) findViewById(R.id.radioButton6);
        diabetic = false;

        submitdetails = (Button) findViewById(R.id.button_Submit);




        consumerList = new ArrayList<Consumer>();




        submitdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                Integer ageNumber;
                String ageText = "0";
                ageText = age.getText().toString();
                if ("".equals(ageText)) ageNumber =0 ;
                else ageNumber = Integer.parseInt(ageText);
                consumer = new Consumer(breathing,ageNumber,gender,diabetic);
                consumerList.add(consumer);

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


                saveInfo(temp,breathing,ageNumber,gender,diabetic);
                resultActivity(consumer.percentage);

                //Toast.makeText(getApplicationContext(),consumer.percentage,Toast.LENGTH_SHORT).show();






            }
        });



    }

    public void saveInfo(int index ,boolean prbBreathing , int age , boolean gender , boolean diabetic ){

        Log.d("Age  ::", String.valueOf(age));

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        //editor.putInt("total",a);
        editor.putBoolean("problemBreathing"+index,prbBreathing);
        editor.putInt("Age"+index,age);
        editor.putBoolean("gender"+index,gender);
        editor.putBoolean("Diabetic"+index,diabetic);


        editor.commit();

    }

    public void resultActivity(Integer percentage){
        Log.d("resultActivity","percentage passed   ::"+percentage);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE , percentage);
        startActivity(intent);

    }

    public void breathingClick(View view){
        boolean checked = ((RadioButton)view).isChecked();
        if(view.getId() == R.id.radioButton) breathing = true;
        if(view.getId() == R.id.radioButton2) breathing = false;


    }

    public void diabeticFn(View view){
        boolean checked = ((RadioButton)view).isChecked();
        if(view.getId() == R.id.radioButton5) diabetic = true;
        if(view.getId() == R.id.radioButton6) diabetic = false;

    }

    public void genderFn(View view){

        boolean checked = ((RadioButton)view).isChecked();
        if(view.getId() == R.id.radioButton3) gender = true;
        if(view.getId() == R.id.radioButton4) gender = false;

    }

    public void radioBtnSingleChoice(RadioButton a , RadioButton b) {
        if(a.isChecked()){
            b.setChecked(false);

        }
        else if (b.isChecked()){
            a.setChecked(false);
        }

    }

    protected void allInformation(String breathingProblems){

    }


}
