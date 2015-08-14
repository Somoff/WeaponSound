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
public class m4a1 extends Allmusicgun {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m4a1);
        patron1 = (TextView) findViewById(R.id.textView222);
        patron1.setText(String.valueOf(patron));
    }
    public void Play3(View v) { //Клик на выстрел
        if ((patron <=30) && (patron > 0)){
            Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S9, 0);
            patron = patron - 1;
            patron1.setText(String.valueOf(patron));
        }else { Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
        }
    }

    public void Reweapon3(View v){//Перезарядка
        Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S8, 0);
        patron=30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(1500);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }

    public void backm4a1(View view) {
        Intent intent = new Intent(getApplicationContext(), ak74.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
    public void m4a1go(View view) {
        Intent intent = new Intent(this, ak47.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
}
