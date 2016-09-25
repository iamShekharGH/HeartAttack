package com.iamshekhargh.heartattackandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

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
    TextView getReq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getReq = (TextView) findViewById(R.id.textView_m2);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responce volley  ::" , response);
                //getReq.setText(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error ::",""+error);

            }
        });

        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responce volley post ::" , response);
                getReq.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error post::",""+error);

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                //Dummy Values..
                params.put("hasBreathingProblem","Yes");
                params.put("Age","77");
                params.put("gender","Male");
                params.put("diabetic","Yes");

                return params;
            }
        };


        queue.add(stringRequest);
        queue.add(stringRequest1);



    }

    public void pullInfo(){
        //it will get all the info list and can be accessed according to convenience.
    }



}
