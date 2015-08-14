package com.example.myproject;

import android.app.Activity;
import java.util.HashMap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ak47 extends Activity {
    private SoundPool mSoundPool;
    int mStreamID;
    private AssetManager mAssetManager;
    private int mReload,mak47,mblock;
    private int mCountLoadedSound;
    private Context mContext;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak47);
        mContext = this;

        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mAssetManager = getAssets();

        mak47 = loadSound("ak47_fire.ogg");
        mReload = loadSound("reload.ogg");
        mblock = loadSound("block.ogg");
ImageView mak477 = (ImageView) this.findViewById(R.id.btnBass1);
        mak477.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();
                if (eventAction == MotionEvent.ACTION_UP){
                    if(mStreamID > 0)
                        mSoundPool.stop(mStreamID);
                }
                if (eventAction == MotionEvent.ACTION_DOWN){
                    mStreamID = playSound(mak47);
                }
                if (event.getAction()==MotionEvent.ACTION_CANCEL){
                    mSoundPool.stop(mStreamID);
                }
                return false;
            }
        });
    }
}

