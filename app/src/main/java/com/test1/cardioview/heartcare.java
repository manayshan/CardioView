package com.test1.cardioview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class heartcare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heartcare);

        //Workout btn
        Button btn1 = findViewById(R.id.workout);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityworkout();
            }
        });


        //Checkup Reminder
        Button btn5 = findViewById(R.id.checkup);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivitycheckup();
            }
        });

        //Medicine Reminder
        Button btn6 = findViewById(R.id.medicine);
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivitymedicine();
            }
        });

    }

    public void openActivityworkout() {

        Intent intent1 = new Intent(this, workout.class);
        startActivity(intent1);
    }


    public void openActivitycheckup(){
        Intent intent5 = new Intent(this, checkup.class);
        startActivity(intent5);
    }

    public void openActivitymedicine(){
        Intent intent6 = new Intent(this, medicine.class);
        startActivity(intent6);
    }

}
