package com.Medicine.SkyForceTeam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
 int splechTime=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fide_in,R.anim.fide_out);
                finish();
            }
        },splechTime);
    }
}
