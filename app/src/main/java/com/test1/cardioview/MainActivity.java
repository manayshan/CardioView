package com.test1.cardioview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //knowyourheart
        Button btn1 = findViewById(R.id.knowyourheart);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityKnow();
            }
        });

        //Health Care
        Button btn2 = findViewById(R.id.healthcare);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityhealthcare();
            }
        });
    }
    private void openActivityKnow() {

        Intent intent1 = new Intent(this, activity_know.class);
        startActivity(intent1);
    }

    public void openActivityhealthcare() {

        Intent intent2 = new Intent(this, heartcare.class);
        startActivity(intent2);
    }
}
