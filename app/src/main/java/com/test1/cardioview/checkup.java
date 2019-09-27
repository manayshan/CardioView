package com.test1.cardioview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup);

        //Add Button
        Button addBtn = (Button)findViewById(R.id.checkup_addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityaddcheckup();
            }
        });

        //View Button
        Button viewBtn = (Button)findViewById(R.id.checkup_viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityviewcheckup();
            }
        });

    }
    private void openActivityaddcheckup(){
        Intent intent1 = new Intent(this, addcheckup.class);
        startActivity(intent1);
    }

    private void openActivityviewcheckup(){
        Intent intent2 = new Intent(this, viewcheckup.class);
        startActivity(intent2);

    }
}
