package com.example.myproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Somoff on 13.08.2015.
 */
public class ak74 extends Allmusicgun {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak74);
    }
        public void Play1(View v) { //Клик на выстрел
            if ((patron <=30) && (patron > 0)){
                Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S4, 0);
                patron = patron - 1;
                patron1.setText(String.valueOf(patron));
            }else { Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
            }
        }

        public void Reweapon1(View v){//Перезарядка
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


    public void backak74(View view) {
        Intent intent = new Intent(getApplicationContext(), aug_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void Ak74go(View view) {
        Intent intent = new Intent(this, m4a1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
}
