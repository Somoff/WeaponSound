package com.example.myproject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Famas extends Activity implements View.OnTouchListener {
    Timer timer5;
    View mDecorView;
    public SoundPool mSoundPool;
    public AssetManager mAssetManager;
    public int  famas,reload, block;
    public int mCountLoadedSound;
    public Context mContext;
    private ProgressDialog mProgressDialog;
    public TextView patron1;
    String[] data = {"AK47", "AK74", "AUG", "M4A1", "FAMAS", "FS2000", "G36C", "SG552","SHOTGUN_SUPER90","DESERTEAGLE"};
    public int patron2 = 25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.famas);
        patron1 = (TextView) findViewById(R.id.famasview);
        patron1.setText(String.valueOf(patron2));
        ImageView im2 = (ImageView) findViewById(R.id.famas);
        im2.setOnTouchListener(this);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mDecorView = getWindow().getDecorView();
        setTitle("FullScreen");
        mContext = this;
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mAssetManager = getAssets();
        reload = loadSound("reload.ogg");
        block = loadSound("block.ogg");
        famas = loadSound("famasf1_fire.ogg");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        android.widget.Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinnerfamas);
        spinner.setAdapter(adapter);

        spinner.setSelection(4, true);

        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CustomAdapter.flag = true;

                if (position == 0) {
                    Toast.makeText(Famas.this, "Weapon Selected AK47", Toast.LENGTH_SHORT).show();
                    Intent ak47 = new Intent(getApplicationContext(), Allmusicgun.class);
                    startActivity(ak47);
                }
                if (position == 1) {
                    Toast.makeText(Famas.this, "Weapon Selected AK74", Toast.LENGTH_SHORT).show();
                    Intent ak74 = new Intent(getApplicationContext(), ak74.class);
                    startActivity(ak74);
                }
                if (position == 2) {
                    Toast.makeText(Famas.this, "Weapon Selected AUG", Toast.LENGTH_SHORT).show();
                    Intent aug = new Intent(getApplicationContext(), aug_activity.class);
                    startActivity(aug);
                }
                if (position == 3) {
                    Toast.makeText(Famas.this, "Weapon Selected M4A1", Toast.LENGTH_SHORT).show();
                    Intent m4a1 = new Intent(getApplicationContext(), m4a1.class);
                    startActivity(m4a1);

                }
                if (position == 4) {
                    Toast.makeText(Famas.this, "Weapon Selected FAMAS", Toast.LENGTH_SHORT).show();
                    Intent famas = new Intent(getApplicationContext(), Famas.class);
                    startActivity(famas);
                }

                if (position == 5) {
                    Toast.makeText(Famas.this, "Weapon Selected FS2000", Toast.LENGTH_SHORT).show();
                    Intent fs2000 = new Intent(getApplicationContext(), fs2000.class);
                    startActivity(fs2000);
                }
                if (position == 6) {
                    Toast.makeText(Famas.this, "Weapon Selected G36C", Toast.LENGTH_SHORT).show();
                    Intent g36c = new Intent(getApplicationContext(), g36c.class);
                    startActivity(g36c);
                }
                if (position == 7) {
                    Toast.makeText(Famas.this, "Weapon Selected SG552", Toast.LENGTH_SHORT).show();
                    Intent sg552 = new Intent(getApplicationContext(), sg552.class);
                    startActivity(sg552);
                }
                if (position == 8) {
                    Toast.makeText(Famas.this, "SHOTGUN_SUPER90", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), shotgun_super90.class);
                    startActivity(SHOTGUN_SUPER90);
                }
                if (position == 9) {
                    Toast.makeText(Famas.this, "Weapon Selected DESERTEAGLE", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), Deserteagl.class);
                    startActivity(SHOTGUN_SUPER90);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

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



    public void AlertDialogFamas(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Famas.this);

        builder.setTitle("Famas")
                .setMessage(" Страна: Франция \n Масса: 3,61кг \n Длина: 750мм \n Калибр: 5,56мм \n Начальная скорость пули: 960 м/c \n Максимальная дальность: 300м")
                .setInverseBackgroundForced(true)
                .setCancelable(false)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        android.app.AlertDialog alert = builder.create();
        alert.show();
    }


    public void Reweapon6(View v){//Перезарядка
        playSound(reload);
        patron2=25;
        patron1.setText(String.valueOf(patron2));
        try {
            Thread.sleep(3500);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN ) {
            if (timer5 == null ) {
                timer5 = new Timer();
                timer5.scheduleAtFixedRate(new UpdateTimeTask5(), 70, 200);}
        } else if (event.getAction() == MotionEvent.ACTION_UP ) {
            timer5.cancel();
            timer5 = null;
        }if (patron2 == 0)
            playSound(block);
        return true;
    }
    class UpdateTimeTask5 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron2 <= 25) && (patron2 > 0)) {
                        playSound(famas);
                        patron2 = patron2 - 1;
                        patron1.setText(String.valueOf(patron2));
                    }
                }

            });
        }

    }
    public void backfamas(View view) {
        Intent intent = new Intent(getApplicationContext(), aug_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void famasgo(View view) {
        Intent intent = new Intent(this, fs2000.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
    protected void onPause() {
        super.onPause();
        if (mSoundPool != null) {
            mSoundPool.release();
            mSoundPool = null;
        }
    }
}
