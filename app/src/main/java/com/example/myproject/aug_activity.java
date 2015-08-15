package com.example.myproject;

import android.content.Intent;
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
public class aug_activity extends Allmusicgun implements View.OnTouchListener {
    Timer timer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aug);
        patron1 = (TextView) findViewById(R.id.textView535);
        patron1.setText(String.valueOf(patron));
        ImageView im = (ImageView) findViewById(R.id.imageView64);
        im.setOnTouchListener(this);
    }

  //  public void Play1(View v) { //Клик на выстрел
    //    if ((patron <= 30) && (patron > 0)) {
     //       Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S7, 0);
      //      patron = patron - 1;
      //      patron1.setText(String.valueOf(patron));
     //   } else {
     //       Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
     //   }
   // }

    public void Reweapon1(View v) {//Перезарядка
        Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S3, 0);
        patron = 30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }


    public void backaug(View view) {
        Intent intent = new Intent(getApplicationContext(), ak47.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void goaug(View view) {
        Intent intent = new Intent(getApplicationContext(), ak74.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer3 == null) {
                timer3 = new Timer();
                timer3.scheduleAtFixedRate(new UpdateTimeTask3(), 50, 250);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer3.cancel();
            timer3 = null;
        }
        if (patron == 0)
            Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
        return true;
    }

    class UpdateTimeTask3 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron <= 30) && (patron > 0)) {
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S7, 0);
                        patron = patron - 1;
                        patron1.setText(String.valueOf(patron));
                    }
                }

            });
        }
    }
}
