package com.iamshekhargh.heartattackandroid;


import android.provider.BaseColumns;

import com.orm.SugarRecord;

public class TableStore  extends SugarRecord {
    Integer age;
    Boolean breathingProblems;
    Boolean gender;
    Boolean diabetic;

    public TableStore(){}

    public TableStore(Integer age,Boolean breathingProblems,Boolean gender,Boolean diabetic){
        this.age = age;
        this.breathingProblems = breathingProblems;
        this.gender = gender;
        this.diabetic = diabetic;

    }



}
