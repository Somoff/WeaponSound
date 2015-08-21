package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class aug_activity extends Allmusicgun implements View.OnTouchListener {
    Timer timer3;

    String[] data = {"AK47", "AK74", "AUG", "M4A1", "FAMAS", "FS2000", "G36C","SG552","SHOTGUN_SUPER90","DESERTEAGLE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aug);
        patron1 = (TextView) findViewById(R.id.textView535);
        patron1.setText(String.valueOf(patron));
        ImageView im = (ImageView) findViewById(R.id.imageView64);
        im.setOnTouchListener(this);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        android.widget.Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinneraug);
        spinner.setAdapter(adapter);

        spinner.setSelection(2, true);

        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CustomAdapter.flag = true;

                if (position == 0){
                    Toast.makeText(aug_activity.this, "Weapon Selected AK47", Toast.LENGTH_SHORT).show();
                    Intent ak47 = new Intent(getApplicationContext(), ak47.class);
                    startActivity(ak47);
                }
                if(position == 1){
                    Toast.makeText(aug_activity.this, "Weapon Selected AK74", Toast.LENGTH_SHORT).show();
                    Intent ak74 = new Intent(getApplicationContext(), ak74.class);
                    startActivity(ak74);
                }
                if(position == 2){
                    Toast.makeText(aug_activity.this, "Weapon Selected AUG", Toast.LENGTH_SHORT).show();
                    Intent aug = new Intent (getApplicationContext(), aug_activity.class);
                    startActivity(aug);
                }
                if(position == 3){
                    Toast.makeText(aug_activity.this, "Weapon Selected M4A1", Toast.LENGTH_SHORT).show();
                    Intent m4a1 = new Intent(getApplicationContext(), m4a1.class);
                    startActivity(m4a1);

                }
                if (position == 4) {
                    Toast.makeText(aug_activity.this, "Weapon Selected FAMAS", Toast.LENGTH_SHORT).show();
                    Intent famas = new Intent(getApplicationContext(), Famas.class);
                    startActivity(famas);
                }

                if (position == 5) {
                    Toast.makeText(aug_activity.this, "Weapon Selected FS2000", Toast.LENGTH_SHORT).show();
                    Intent fs2000 = new Intent(getApplicationContext(), fs2000.class);
                    startActivity(fs2000);
                }
                if (position == 6) {
                    Toast.makeText(aug_activity.this, "Weapon Selected G36C", Toast.LENGTH_SHORT).show();
                    Intent g36c = new Intent(getApplicationContext(), g36c.class);
                    startActivity(g36c);
                }
                if (position == 7) {
                    Toast.makeText(aug_activity.this, "Weapon Selected SG552", Toast.LENGTH_SHORT).show();
                    Intent sg552 = new Intent(getApplicationContext(), sg552.class);
                    startActivity(sg552);
                }
                if (position == 8) {
                    Toast.makeText(aug_activity.this, "SHOTGUN_SUPER90", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), shotgun_super90.class);
                    startActivity(SHOTGUN_SUPER90);
                }
                if (position == 9) {
                    Toast.makeText(aug_activity.this, "Weapon Selected DESERTEAGLE", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), Deserteagl.class);
                    startActivity(SHOTGUN_SUPER90);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

    }



    public void AlertDialogAUG(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(aug_activity.this);

        builder.setTitle("AUG")
                .setMessage("Страна: Австрия \n Масса: 3,3кг \n Длина: 690мм \n Калибр: 5,56мм \n Начальная скорость пули: 992 м/c \n Максимальная дальность: 650м")
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



    //  public void Play1(View v) { //Клик на выстрел
    //    if ((patron <= 30) && (patron > 0)) {
     //       Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S7, 0);
      //      patron = patron - 1;
      //      patron1.setText(String.valueOf(patron));
     //   } else {
     //       Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
     //   }
   // }

    public void Reweapon1(View v) {//Перезарядка
        playSound(reload);
        patron = 30;
        patron1.setText(String.valueOf(patron));
        try {
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }


    public void backaug(View view) {
        Intent intent = new Intent(getApplicationContext(), ak74.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void goaug(View view) {
        Intent intent = new Intent(getApplicationContext(), Famas.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer3 == null) {
                timer3 = new Timer();
                timer3.scheduleAtFixedRate(new UpdateTimeTask3(), 50, 210);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer3.cancel();
            timer3 = null;
        }
        if (patron == 0)
            playSound(block);
        return true;
    }

    class UpdateTimeTask3 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron <= 30) && (patron > 0)) {
                        playSound(aug);
                        patron = patron - 1;
                        patron1.setText(String.valueOf(patron));
                    }
                }

            });
        }
    }
}
