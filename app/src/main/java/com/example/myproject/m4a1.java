package com.example.myproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Somoff on 13.08.2015.
 */
public class m4a1 extends Allmusicgun implements View.OnTouchListener {
Timer timer4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m4a1);
        patron1 = (TextView) findViewById(R.id.textView222);
        patron1.setText(String.valueOf(patron));
        ImageView im2 = (ImageView) findViewById(R.id.imageView2);
        im2.setOnTouchListener(this);
    }
 //   public void Play3(View v) { //Клик на выстрел
     //   if ((patron <=30) && (patron > 0)){
      //      Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S9, 0);
      //      patron = patron - 1;
      //      patron1.setText(String.valueOf(patron));
     //   }else { Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
    //    }
   // }

    public void Reweapon3(View v){//Перезарядка
        Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S3, 0);
        patron=30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(3500);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }

    public void backm4a1(View view) {
        Intent intent = new Intent(getApplicationContext(), g36c.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
    public void m4a1go(View view) {
        Intent intent = new Intent(this, ak47.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer4 == null) {
                timer4 = new Timer();
                timer4.scheduleAtFixedRate(new UpdateTimeTask4(), 50, 210);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer4.cancel();
            timer4 = null;
        }
        if (patron == 0)
            Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
        return true;
    }
    class UpdateTimeTask4 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron <= 30) && (patron > 0)) {
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S9, 0);
                        patron = patron - 1;
                        patron1.setText(String.valueOf(patron));
                    }
                }

            });
        }
    }
}
