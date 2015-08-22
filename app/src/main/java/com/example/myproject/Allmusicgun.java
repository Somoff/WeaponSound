package com.example.myproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by asass on 14.08.2015.
 */
public class Allmusicgun extends Activity {

    View mDecorView;
    public SoundPool mSoundPool;
    public AssetManager mAssetManager;
    public int ak47, aug, famas, ak74, fs2000, g36c, m4a1, sg552, shotgun_super90, reload, block, reloadshotgun,deagle,Zatvor;
    public int mCountLoadedSound;
    public Context mContext;
    private ProgressDialog mProgressDialog;
    public TextView patron1;
    public int patron = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak47);
        patron1 = (TextView) findViewById(R.id.txtnumber);
        patron1.setText(String.valueOf(patron));
        ImageView image = (ImageView) findViewById(R.id.Desertbutton);

        mDecorView = getWindow().getDecorView();
        setTitle("FullScreen");
        mContext = this;
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mAssetManager = getAssets();
        ak47 = loadSound("ak47_fire.ogg");
        aug = loadSound("aug_fire.ogg");
        famas = loadSound("famasf1_fire.ogg");
        fs2000 = loadSound("fs2000_fire.ogg");
        m4a1 = loadSound("m4a1_fire.ogg");
        sg552 = loadSound("sg552_fire.ogg");
        shotgun_super90 = loadSound("xm1014.ogg");
        reload = loadSound("reload.ogg");
        block = loadSound("block.ogg");
        g36c = loadSound("g36c_fire.ogg");
        ak74 = loadSound("ak74_fire.ogg");
        reloadshotgun = loadSound("xmdeploy.ogg");
        deagle = loadSound("deagle-2.ogg");
        Zatvor = loadSound("Zatvor.ogg");
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
    public void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);
    }
    public int loadSound(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    public void shareButton(View view){

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }


}








