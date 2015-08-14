package com.example.myproject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by asass on 14.08.2015.
 */
public class Allmusicgun extends Activity {
    public TextView patron1;
    public int patron = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak47);
        patron1 = (TextView) findViewById(R.id.txtnumber);
        patron1.setText(String.valueOf(patron));
        ImageView image = (ImageView) findViewById(R.id.btnBass1);
    }
    public static class OurSoundPlayer{


        public static final int S1 = R.raw.ak47_fire;
        public static final int S2 = R.raw.block;
        public static final int S3 = R.raw.reload;
        public static final int S4 = R.raw.ak74_fire;

        public static SoundPool soundPool;
        public static HashMap<Integer, Integer> soundPoolMap;

        /** Populate the SoundPool*/
        public static void initSounds(Context context) {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
            soundPoolMap = new HashMap<Integer, Integer>(3);
            soundPoolMap.put(S4, soundPool.load(context, R.raw.ak74_fire, 1));
            soundPoolMap.put(S1, soundPool.load(context, R.raw.ak47_fire, 1));
            soundPoolMap.put(S2, soundPool.load(context, R.raw.block,1));
            soundPoolMap.put(S3, soundPool.load(context, R.raw.reload,1));

        }
        /** Play a given sound in the soundPool */
        public static void playSound(Context context, int soundID, int st) {
            if(soundPool == null || soundPoolMap == null){
                initSounds(context);
            }
            if(st==1){ soundPool.stop(soundPoolMap.get(soundID));
            } else {
                float volume = 1;// whatever in the range = 0.0 to 1.0

                // play sound with same right and left volume, with a priority of 1,
                // zero repeats (i.e play once), and a play back rate of 1f
                soundPool.play(soundPoolMap.get(soundID), volume, volume, 1, 0, 1f);
                st=0;

            }
        }

    }


}
