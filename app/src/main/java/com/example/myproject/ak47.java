package com.example.myproject;

import android.app.Activity;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ak47 extends  Allmusicgun {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void Play(View v) { //Клик на выстрел
        if ((patron <=30) && (patron > 0)){
            OurSoundPlayer.playSound(this, OurSoundPlayer.S1, 0);
            patron = patron - 1;
            patron1.setText(String.valueOf(patron));
        }else { OurSoundPlayer.playSound(this, OurSoundPlayer.S2,0);
        }
    }

    public void Reweapon(View v){//Перезарядка
        OurSoundPlayer.playSound(this, OurSoundPlayer.S3, 0);
        patron=30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(3500);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }


    public void Ak47go (View view){
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
    };

}