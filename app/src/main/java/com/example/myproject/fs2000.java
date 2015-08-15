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
 * Created by Somoff on 15.08.2015.
 */
public class fs2000 extends Allmusicgun implements View.OnTouchListener {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fs2000);
        patron1 = (TextView) findViewById(R.id.fss2000View);
        patron1.setText(String.valueOf(patron));
        ImageView something = (ImageView) findViewById(R.id.fs2000View);
        something.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer == null) {
                timer = new Timer();
                timer.scheduleAtFixedRate(new UpdateTimeTask(), 50, 210);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer.cancel();
            timer = null;
        }
        if (patron == 0)
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
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S12, 0);
                        patron = patron - 1;
                        patron1.setText(String.valueOf(patron));
                    }
                }

            });
        }

    }
    public void Reweapon7(View v) {//Перезарядка
        OurSoundPlayer.playSound(this, OurSoundPlayer.S3, 0);
        patron = 30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
    public void Fs2000go(View view) {
        Intent intent = new Intent(this, m4a1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);

    }

    public void backfs2000(View view) {
        Intent intent = new Intent(getApplicationContext(), Famas.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
}