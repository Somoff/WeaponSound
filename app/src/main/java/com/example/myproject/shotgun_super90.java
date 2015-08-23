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

/**
 * Created by Somoff on 17.08.2015.
 */
public class shotgun_super90 extends Activity implements View.OnTouchListener {
    Timer timer;
    View mDecorView;
    public SoundPool mSoundPool;
    public AssetManager mAssetManager;
    public int ak47, aug, famas, ak74, fs2000, g36c, m4a1, sg552, shotgun_super90, reload, block, reloadshotgun, deagle, Zatvor;
    public int mCountLoadedSound;
    public Context mContext;
    private ProgressDialog mProgressDialog;
    public TextView patron1;
    int patron5 = 8;
    String[] data = {"AK47", "AK74", "AUG", "M4A1", "FAMAS", "FS2000", "G36C", "SG552","SHOTGUN_SUPER90","DESERTEAGLE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shotgun_super90);
            patron1 = (TextView) findViewById(R.id.shotgunView);
            patron1.setText(String.valueOf(patron5));
            ImageView im4 = (ImageView) findViewById(R.id.shotgunButton);
            im4.setOnTouchListener(this);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mDecorView = getWindow().getDecorView();
        setTitle("FullScreen");
        mContext = this;
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mAssetManager = getAssets();
        reloadshotgun = loadSound("xmdeploy.ogg");
        shotgun_super90 = loadSound("xm1014.ogg");
        block = loadSound("block.ogg");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


            android.widget.Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinneshotgun);
            spinner.setAdapter(adapter);

            spinner.setSelection(8, true);

            adapter.notifyDataSetChanged();

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CustomAdapter.flag = true;

                    if (position == 0) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected AK47", Toast.LENGTH_SHORT).show();
                        Intent ak47 = new Intent(getApplicationContext(), ak47.class);
                        startActivity(ak47);
                    }
                    if (position == 1) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected AK74", Toast.LENGTH_SHORT).show();
                        Intent ak74 = new Intent(getApplicationContext(), ak74.class);
                        startActivity(ak74);
                    }
                    if (position == 2) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected AUG", Toast.LENGTH_SHORT).show();
                        Intent aug = new Intent(getApplicationContext(), aug_activity.class);
                        startActivity(aug);
                    }
                    if (position == 3) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected M4A1", Toast.LENGTH_SHORT).show();
                        Intent m4a1 = new Intent(getApplicationContext(), m4a1.class);
                        startActivity(m4a1);

                    }
                    if (position == 4) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected FAMAS", Toast.LENGTH_SHORT).show();
                        Intent famas = new Intent(getApplicationContext(), Famas.class);
                        startActivity(famas);
                    }

                    if (position == 5) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected FS2000", Toast.LENGTH_SHORT).show();
                        Intent fs2000 = new Intent(getApplicationContext(), fs2000.class);
                        startActivity(fs2000);
                    }
                    if (position == 6) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected G36C", Toast.LENGTH_SHORT).show();
                        Intent g36c = new Intent(getApplicationContext(), g36c.class);
                        startActivity(g36c);
                    }
                    if (position == 7) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected SG552", Toast.LENGTH_SHORT).show();
                        Intent sg552 = new Intent(getApplicationContext(), sg552.class);
                        startActivity(sg552);
                    }
                    if (position == 8) {
                        Toast.makeText(shotgun_super90.this, "SHOTGUN_SUPER90", Toast.LENGTH_SHORT).show();
                        Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), shotgun_super90.class);
                        startActivity(SHOTGUN_SUPER90);
                    }
                    if (position == 9) {
                        Toast.makeText(shotgun_super90.this, "Weapon Selected DESERTEAGLE", Toast.LENGTH_SHORT).show();
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


    public void AlertDialogSHOTGUN(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(shotgun_super90.this);

        builder.setTitle("AK47")
                .setMessage(" Страна: Италия \n Масса: 3,8кг \n Длина: 1010мм \n Калибр: 18,5мм \n Начальная скорость пули: 380 м/c \n Максимальная дальность: 50м")
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


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer == null) {
                timer = new Timer();
                timer.scheduleAtFixedRate(new UpdateTimeTask(), 100, 500);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer.cancel();
            timer = null;
        }
        if (patron5 == 0)
            playSound(block);
        return true;
    }
    class UpdateTimeTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron5 <= 8) && (patron5 > 0)) {
                        playSound(shotgun_super90);
                        patron5 = patron5 - 1;
                        patron1.setText(String.valueOf(patron5));
                    }
                }

            });
        }

    }
    public void Reweapon9(View v) {//Перезарядка
        playSound(reloadshotgun);
        if (patron5<8)
        patron5 = patron5+1;
        patron1.setText(String.valueOf(patron5));
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
    public void Shotgungo(View view) {
        Intent intent = new Intent(this, Deserteagl.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);

    }

    public void backshotgun (View view) {
        Intent intent = new Intent(getApplicationContext(), sg552.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
    protected void onPause() {
        super.onPause();
        if (mSoundPool != null) {
            mSoundPool.release();
            mSoundPool = null;
        }
    }
}
