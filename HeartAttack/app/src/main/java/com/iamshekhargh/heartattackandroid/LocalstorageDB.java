package com.iamshekhargh.heartattackandroid;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class LocalstorageDB extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localstorage_db);

        List<TableStore> list = TableStore.listAll(TableStore.class);
        //Log.d("Length",""+list.toString());

        long count = TableStore.count(TableStore.class);
        count--;
        Log.d("TableCount ::" , ""+count);
        int counter = 0;


        while (counter <= count){
            Log.d("counter" ,""+counter);
            TableStore temp = list.get(counter);
            String val1,val2,val3,val4;
            val1 = temp.breathingProblems ? "Can Breath" : "Can't Breath" ;
            val2 = temp.age.toString();
            val3 = temp.gender ? "Man" : "Women" ;
            val4 = temp.diabetic ? "is Diabetic" : "Not Diabetic" ;
             printInfo(val1,val2,val3,val4);


            counter++;


        }






        //while ()







    }

    public void printInfo(String breathingV,String ageV,String genderV,String diabeticV ){



        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);

        //This is to add weight of 1 to each element.
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);


        //This is a line to Seperate the cases.
        LinearLayout linearLayout4 = new LinearLayout(this);
        TextView line = new TextView(this);
        line.setText("-----------------------");
        linearLayout4.addView(line);
        linearLayout4.setLayoutParams(param);


        //This is his/her age
        LinearLayout linearLayout0 = new LinearLayout(this);
        TextView age = new TextView(this);
        age.setText("Age    ::"+ageV);
        linearLayout0.addView(age);
        linearLayout0.setLayoutParams(param);

        //This is breathing Condition
        LinearLayout linearLayout1 = new LinearLayout(this);
        TextView breathing = new TextView(this);
        breathing.setText(breathingV);
        linearLayout1.addView(breathing);
        linearLayout1.setLayoutParams(param);

        //This displays Gender
        LinearLayout linearLayout2 = new LinearLayout(this);
        TextView gender = new TextView(this);
        gender.setText(genderV);
        linearLayout2.addView(gender);
        linearLayout2.setLayoutParams(param);

        //This shows if he or she has diabetes or not.
        LinearLayout linearLayout3 = new LinearLayout(this);
        TextView diabetic = new TextView(this);
        diabetic.setText(diabeticV);
        linearLayout3.addView(diabetic);
        linearLayout3.setLayoutParams(param);

        //Here I am adding all views to the main View
        tableLayout.addView(linearLayout0);
        tableLayout.addView(linearLayout1);
        tableLayout.addView(linearLayout2);
        tableLayout.addView(linearLayout3);
        tableLayout.addView(linearLayout4);
        //tableLayout.append




    }


}
