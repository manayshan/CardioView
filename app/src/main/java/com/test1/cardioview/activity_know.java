package com.test1.cardioview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class activity_know extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.know_activity);

        //HeartBeat btn
        Button btn1 = findViewById(R.id.heartbeat);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityheartbeat();
            }
        });
        //Heart Attack btn
        Button btn2 = findViewById(R.id.heartattack);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityheartattack();
            }
        });
        //Chest Pain
        Button btn3 = findViewById(R.id.chestpain);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivitychestpain();
            }
        });
        //Cardiac Arrest
        Button btn4 = findViewById(R.id.cardiacarrest);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivitycardiacarrest();
            }
        });
        //Angina Pain
        Button btn5 = findViewById(R.id.anginapain);
        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityanginapain();
            }
        });
        //Search More
        Button btn6 = findViewById(R.id.searchmore);
        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivitysearchmore();
            }
        });


    }
    //Fn Heart Beat
    public void openActivityheartbeat(){

        Intent intent1 = new Intent(this, activity_heartbeat.class);
        startActivity(intent1);}

    //Fn Heart Attack
    public void openActivityheartattack(){

        Intent intent2 = new Intent(this, activity_heartattack.class);
        startActivity(intent2);}

    //Fn Chest Pain
    public void openActivitychestpain(){

        Intent intent3 = new Intent(this, activitry_chestpain.class);
        startActivity(intent3);}

    //Fn Cardiac Arrest
    public void openActivitycardiacarrest(){

        Intent intent4 = new Intent(this, cardiacarrest.class);
        startActivity(intent4);}

    //Fn Angina Pain
    public void openActivityanginapain(){

        Intent intent5 = new Intent(this, anginapain.class);
        startActivity(intent5);}

    //Fn searchmore
    public void openActivitysearchmore(){

        Intent intent6 = new Intent(this, activity_search.class);
        startActivity(intent6);}
}
