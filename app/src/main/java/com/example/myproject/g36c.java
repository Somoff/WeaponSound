package com.example.myproject;

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
public class g36c extends Allmusicgun implements View.OnTouchListener {
    Timer timer;
    public int patron3 = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g36c);
        patron1 = (TextView) findViewById(R.id.g36ctextView);
        patron1.setText(String.valueOf(patron3));
        ImageView im2 = (ImageView) findViewById(R.id.g36cView);
        im2.setOnTouchListener(this);
    }

    public void Reweapon8(View v) {//Перезарядка
        Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S3, 0);
        patron3 = 20;
        patron1.setText(String.valueOf(patron3));
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer == null) {
                timer = new Timer();
                timer.scheduleAtFixedRate(new UpdateTimeTask5(), 50, 250);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer.cancel();
            timer = null;
        }
        if (patron3 == 0)
            Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
        return true;
    }

    class UpdateTimeTask5 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron3 <= 25) && (patron3 > 0)) {
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S13, 0);
                        patron3 = patron3 - 1;
                        patron1.setText(String.valueOf(patron3));
                    }
                }

            });
        }

    }

    public void backg36c(View view) {
        Intent intent = new Intent(getApplicationContext(), fs2000.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void g36cgo(View view) {
        Intent intent = new Intent(this, m4a1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
}
