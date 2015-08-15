package com.example.myproject;

import android.app.Activity;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ak47 extends  Allmusicgun implements View.OnTouchListener {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageButton something = (ImageButton) findViewById(R.id.btnBass1);
        something.setOnTouchListener(this);
    }
    //   public void Play(View v) { //Клик на выстрел
    //     if ((patron <=30) && (patron > 0)){
    //        OurSoundPlayer.playSound(this, OurSoundPlayer.S1, 0);
    //        patron = patron - 1;
    //       patron1.setText(String.valueOf(patron));
    //   }else { OurSoundPlayer.playSound(this, OurSoundPlayer.S2,0);
    //    }
    // }


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
    public void setPatronText(String text) {
        patron1.setText(text);
    }


    public void Ak47go(View view) {
        Intent intent = new Intent(ak47.this, aug_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);

    }

    public void backak47(View view) {
        Intent intent = new Intent(getApplicationContext(), m4a1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void onClick11(View v) {
        startActivity(new Intent(this,
                Testactivity.class));
    }

    /**
     * Called when a touch event is dispatched to a view. This allows listeners to
     * get a chance to respond before the target view.
     *
     * @param v     The view the touch event has been dispatched to.
     * @param event The MotionEvent object containing full information about
     *              the event.
     * @return True if the listener has consumed the event, false otherwise.
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                if (timer == null ) {
                timer = new Timer();
                timer.scheduleAtFixedRate(new UpdateTimeTask(), 1000, 1000);}}
        else if (event.getAction() == MotionEvent.ACTION_UP ) {
            timer.cancel();
            timer = null;
        }


            if (patron == 0)
                Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
   //     }

        return true;
    }

    class UpdateTimeTask extends TimerTask {

        @Override
        public void run() {
            if ((patron <= 30) && (patron > 0)) {
                Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S1, 0);
                patron = patron - 1;
            }



        }
    }
}









