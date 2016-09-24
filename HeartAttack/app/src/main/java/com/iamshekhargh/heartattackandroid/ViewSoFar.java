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
        overridePendingTransition(R.animator.slide_in_right,R.animator.slide_out_left);
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


}




