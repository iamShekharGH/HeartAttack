package com.iamshekhargh.heartattackandroid;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

public class ViewSoFar extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    TextView aInformation;



    String allInformation="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_so_far);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        ViewGroup relativeLayout = (ViewGroup) findViewById(R.id.mainViewGroup);
        aInformation = new TextView(this);

        int index = settings.getInt("index",-1);
        int temp = 0;
        allInformation = "The Log for all "+index+" information So Far is here :~\n----------------------------------------\n----------------------------------------\n";
        while (temp<=index){

            allInformation += temp +". "; //settings.getInt("index" , -1);
            allInformation += "\t";
            allInformation += (settings.getBoolean("problemBreathing"+temp , false)? " Has Breathing Problems, " : " No Breathing Problems, " );
            allInformation += (settings.getBoolean("gender"+temp , false)? " Is a Guy. " : " Is a Girl. " );
            allInformation += " Age ::"+(settings.getInt("Age"+temp , -1))+", ";
            allInformation += " Diabetic ::"+ (settings.getBoolean("Diabetic"+temp , false)? "Yes" : "No");
            allInformation += "\n----------------------------------\n";
            temp++;

        }
        aInformation.setText(allInformation);
        aInformation.setScroller(new Scroller(getApplicationContext()));
        //aInformation.canScrollVertically(3);












        relativeLayout.addView(aInformation);
        //relativeLayout.addView(index);



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
}








//if (indexNo>=0){
//            TextView index = new TextView(this);
//            TextView breathingProblems = new TextView(this);
//            TextView gender = new TextView(this);
//            TextView age = new TextView(this);
//            TextView diabetic = new TextView(this);
//
//            int temp = 0;
//            temp = indexNo;
//            while(temp>=0){
//
//                index.setText(String.valueOf(settings.getInt("index",-1)));
//                breathingProblems.setText(settings.getBoolean("problemBreathing"+index,false) ? "HaveBreathingProbles" : "NoBreathingProblems");
//                gender.setText(settings.getBoolean("gender"+index,false) ? "male" : "female");
//                age.setText(String.valueOf(settings.getInt("Age"+index,-1)));
//                diabetic.setText(settings.getBoolean("Diabetic"+index,false) ? "Have Diabeties" : "No Diabeties");
//
//                //RelativeLayout relativeLayout1 = new RelativeLayout(this);
//                relativeLayout.addView(index);
////                relativeLayout.addView(breathingProblems);
////                relativeLayout.addView(gender);
////                relativeLayout.addView(age);
////                relativeLayout.addView(diabetic);
//
//                //relativeLayout.addView(relativeLayout1);
//
//
//
//                temp--;
//            }
//
//
//        }