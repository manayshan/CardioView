package com.test1.cardioview;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import com.test1.cardioview.DBHelper;


public class addcheckup extends AppCompatActivity {

    DBHelper dbHelper;
    EditText topicET,durationET;
    TextView dateTV,timeTV;
    DatePickerDialog.OnDateSetListener dateSetListener;
    TimePickerDialog timePickerDialog;
    Button alarm,addMeeting;
    int year,month,day;
    int currentHour,currentMin,hour,min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addcheckup);
        dbHelper = new DBHelper(this);
        topicET = findViewById(R.id.topicET);
        dateTV = findViewById(R.id.dateTV);
        timeTV = findViewById(R.id.timeTV);

        durationET= findViewById(R.id.durationET);

        alarm = findViewById(R.id.alarmBtn);
        addMeeting = findViewById(R.id.addMeetingBtn);

        dateTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        addcheckup.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        timeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar calendar=Calendar.getInstance();
                currentHour=calendar.get(Calendar.HOUR_OF_DAY);
                currentMin=calendar.get(Calendar.MINUTE);



                timePickerDialog = new TimePickerDialog(addcheckup.this,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfday, int minOfday) {


                        timeTV.setText(hourOfday + ":" + minOfday);
                        hour = hourOfday;
                        min = minOfday;

                    }
                },currentHour,currentMin,true);
                timePickerDialog.show();
            }

        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;
                String date = day + "/" + month + "/" + year;
                dateTV.setText(date);
            }
        };

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,min);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"MEETING TIME!!!");
                startActivity(intent);
                Toast.makeText(addcheckup.this, "Reminder set for "+dateTV.getText().toString()+" time "+timeTV.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        addMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t=topicET.getText().toString();
                String du=durationET.getText().toString();
                String d=dateTV.getText().toString();
                String time=timeTV.getText().toString();

                if(t.equals("")||du.equals("")||d.equals("")||time.equals("")){

                    Toast.makeText(addcheckup.this, "Please fill all details!!", Toast.LENGTH_SHORT).show();
                }else{

                    Boolean insert = dbHelper.checkTime(t,du);

                    if(insert == true){

                        Boolean insertData=dbHelper.insert(t,du,d,time);
                        if(insertData==true){
                            Toast.makeText(addcheckup.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(addcheckup.this,viewcheckup.class);
                            i.putExtra("topic",t);
                            i.putExtra("duration",du);
                            i.putExtra("date",d);
                            i.putExtra("time",time);
                            startActivity(i);
                        }else{
                            Toast.makeText(addcheckup.this, "Couldn't add.", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(addcheckup.this, "Time already exists, Please choose some other time", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
