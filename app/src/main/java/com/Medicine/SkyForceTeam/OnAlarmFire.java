package com.Medicine.SkyForceTeam;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class OnAlarmFire extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_fire);

        final Notify notify = new Notify(this);

        final NotificationCompat.Builder np = notify.getChannelN("success","success");

        final SwipeButton swipeButton = (SwipeButton) findViewById(R.id.swbtn);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            int played = 1;

            @Override
            public void onCompletion(MediaPlayer mp) {

                if (played>=10){
                    finish();
                    mediaPlayer.reset();
                    notify.getManager().notify(1,np.build());
                }
                else {
                    played++;
                    mediaPlayer.seekTo(0);
                    mediaPlayer.start();
                }
            }
        });

        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                if (active){
                    mediaPlayer.reset();

                    finish();

                }
            }
        });

    }
}
