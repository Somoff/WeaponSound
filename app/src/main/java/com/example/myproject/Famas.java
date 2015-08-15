package com.example.myproject;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Somoff on 15.08.2015.
 */
public class Famas extends  Allmusicgun implements View.OnTouchListener {
    Timer timer5;
    public int patron2 = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.famas);
        patron1 = (TextView) findViewById(R.id.famasview);
        patron1.setText(String.valueOf(patron2));
        ImageView im2 = (ImageView) findViewById(R.id.famas);
        im2.setOnTouchListener(this);
    }
    public void Reweapon6(View v){//Перезарядка
        Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S3, 0);
        patron2=25;
        patron1.setText(String.valueOf(patron2));
        try {
            Thread.sleep(3500);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN ) {
            if (timer5 == null ) {
                timer5 = new Timer();
                timer5.scheduleAtFixedRate(new UpdateTimeTask5(), 50, 250);}
        } else if (event.getAction() == MotionEvent.ACTION_UP ) {
            timer5.cancel();
            timer5 = null;
        }if (patron2 == 0)
            Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
        return true;
    }
    class UpdateTimeTask5 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron2 <= 25) && (patron2 > 0)) {
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S10, 0);
                        patron2 = patron2 - 1;
                        patron1.setText(String.valueOf(patron2));
                    }
                }

            });
        }

    }
    public void backfamas(View view) {
        Intent intent = new Intent(getApplicationContext(), aug_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void famasgo(View view) {
        Intent intent = new Intent(this, fs2000.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
}
