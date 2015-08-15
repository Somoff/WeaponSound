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

    View mDecorView;

    public TextView patron1;
    public int patron = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak47);
        patron1 = (TextView) findViewById(R.id.txtnumber);
        patron1.setText(String.valueOf(patron));
        ImageView image = (ImageView) findViewById(R.id.btnBass1);

        mDecorView = getWindow().getDecorView();
        setTitle("FullScreen");


    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        }
    }


    public static class OurSoundPlayer{


        public static final int S1 = R.raw.ak47_fire;
        public static final int S2 = R.raw.block;
        public static final int S3 = R.raw.reload;
        public static final int S4 = R.raw.ak74_fire;
        public static final int S5 = R.raw.reloadaug;
        public static final int S6 = R.raw.reloadak74;
        public static final int S7 = R.raw.aug_fire;
        public static final int S8 = R.raw.reloadm4a1;
        public static final int S9 = R.raw.m4a1_fire;
        public static final int S10 = R.raw.famasf1_fire;
        public static final int S12 = R.raw.mg42_fire;
        public static final int S13 = R.raw.g36c_fire;

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
            soundPoolMap.put(S5, soundPool.load(context, R.raw.reloadaug,1));
            soundPoolMap.put(S6, soundPool.load(context, R.raw.reloadak74,1));
            soundPoolMap.put(S7, soundPool.load(context, R.raw.aug_fire,1));
            soundPoolMap.put(S8, soundPool.load(context, R.raw.reloadm4a1,1));
            soundPoolMap.put(S9, soundPool.load(context, R.raw.m4a1_fire,1));
            soundPoolMap.put(S10, soundPool.load(context, R.raw.famasf1_fire,1));
            soundPoolMap.put(S12, soundPool.load(context, R.raw.mg42_fire,1));
            soundPoolMap.put(S13, soundPool.load(context, R.raw.g36c_fire,1));

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

        public static void StopSound(Context context, int soundID,int st) {
            if(soundPool == null || soundPoolMap == null){
                initSounds(context);
            }
            if(st==1){ soundPool.stop(soundPoolMap.get(soundID));
            } else {
                float volume = 0;// whatever in the range = 0.0 to 1.0

                // play sound with same right and left volume, with a priority of 1,
                // zero repeats (i.e play once), and a play back rate of 1f
                soundPool.play(soundPoolMap.get(soundID), volume, volume, 1, 0, 1f);
                st=0;

            }
        }
        }
    }



