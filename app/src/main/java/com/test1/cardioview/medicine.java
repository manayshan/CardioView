package com.test1.cardioview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class medicine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);


        //Add Button
        Button addBtn = findViewById(R.id.medicine_addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityaddmedicine();
            }
        });

        //View Button
        Button viewBtn = findViewById(R.id.medicine_viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityviewmedicine();
            }
        });

    }
    private void openActivityaddmedicine(){
        Intent intent1 = new Intent(this, addmedicine.class);
        startActivity(intent1);
    }

    private void openActivityviewmedicine(){
        Intent intent2 = new Intent(this, viewmedicine.class);
        startActivity(intent2);



    }
}
