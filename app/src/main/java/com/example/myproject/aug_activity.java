package com.example.myproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Somoff on 13.08.2015.
 */
public class aug_activity extends Allmusicgun {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aug);
        patron1 = (TextView) findViewById(R.id.textView535);
        patron1.setText(String.valueOf(patron));
    }
    public void Play1(View v) { //Клик на выстрел
        if ((patron <=30) && (patron > 0)){
            Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S7, 0);
            patron = patron - 1;
            patron1.setText(String.valueOf(patron));
        }else { Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
        }
    }

    public void Reweapon1(View v){//Перезарядка
        Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S5, 0);
        patron=30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }


    public void backaug(View view){
        Intent intent = new Intent(getApplicationContext(), ak47.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
    public void goaug(View view){
        Intent intent = new Intent(getApplicationContext(), ak74.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
}
