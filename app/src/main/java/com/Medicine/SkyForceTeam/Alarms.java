package com.Medicine.SkyForceTeam;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class Alarms extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    ArrayList<PendingIntent> intents = new ArrayList<>();

    private Notify n ;

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,0);
        startalrm(calendar);

    }

    private void startalrm(Calendar calendar) {

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(this, BroadCast.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,intents.size()+1,intent,0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

        intents.add(pendingIntent);

    }
}
