package com.example.myproject;

import android.app.Activity;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ak47 extends  Allmusicgun implements View.OnTouchListener {
    Timer timer;
    View mDecorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageButton something = (ImageButton) findViewById(R.id.btnBass1);
        something.setOnTouchListener(this);
        mDecorView = getWindow().getDecorView();
        setTitle("FullScreen");




    }
    //   public void Play(View v) { //Клик на выстрел
    //     if ((patron <=30) && (patron > 0)){
    //        OurSoundPlayer.playSound(this, OurSoundPlayer.S1, 0);
    //        patron = patron - 1;
    //       patron1.setText(String.valueOf(patron));
    //   }else { OurSoundPlayer.playSound(this, OurSoundPlayer.S2,0);
    //    }
    // }





    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)

            mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        }


    public void Reweapon(View v) {//Перезарядка
        OurSoundPlayer.playSound(this, OurSoundPlayer.S3, 0);
        patron = 30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }



    public void Ak47go(View view) {
        Intent intent = new Intent(ak47.this, ak74.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);

    }

    public void backak47(View view) {
        Intent intent = new Intent(getApplicationContext(), m4a1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                if (timer == null ) {
                timer = new Timer();
                timer.scheduleAtFixedRate(new UpdateTimeTask(), 50, 210);}
                } else if (event.getAction() == MotionEvent.ACTION_UP ) {
            timer.cancel();
            timer = null;
        }if (patron == 0)
                Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
        return true;
    }
    class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron <= 30) && (patron > 0)) {
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S1, 0);
                        patron = patron - 1;
                        patron1.setText(String.valueOf(patron));
                    }
                }

            });
        }

}
    public void setPatronText(String text) {
        patron1.setText(text);
    }
}









