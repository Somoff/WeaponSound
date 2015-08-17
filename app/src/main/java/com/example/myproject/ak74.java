package com.example.myproject;


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


public class ak74 extends Allmusicgun implements View.OnTouchListener {
    Timer timer2;
    String[] data = {"AK47", "AK74", "AUG", "M4A1", "FAMAS", "FS2000", "G36C", "SG552","SHOTGUN_SUPER90"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak74);
        patron1 = (TextView) findViewById(R.id.textView42);
        patron1.setText(String.valueOf(patron));
        ImageView button23 = (ImageView) findViewById(R.id.imageView3);
        button23.setOnTouchListener(this);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        android.widget.Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinner74);
        spinner.setAdapter(adapter);

        spinner.setSelection(1, true);

        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CustomAdapter.flag = true;

                if (position == 0){
                    Toast.makeText(ak74.this, "Weapon Selected AK47", Toast.LENGTH_SHORT).show();
                    Intent ak47 = new Intent(getApplicationContext(), ak47.class);
                    startActivity(ak47);
                }
                if(position == 1){
                    Toast.makeText(ak74.this, "Weapon Selected AK74", Toast.LENGTH_SHORT).show();
                    Intent ak74 = new Intent(getApplicationContext(), ak74.class);
                    startActivity(ak74);
                }
                if(position == 2){
                    Toast.makeText(ak74.this, "Weapon Selected AUG", Toast.LENGTH_SHORT).show();
                    Intent aug = new Intent (getApplicationContext(), aug_activity.class);
                    startActivity(aug);
                }
                if(position == 3){
                    Toast.makeText(ak74.this, "Weapon Selected M4A1", Toast.LENGTH_SHORT).show();
                    Intent m4a1 = new Intent(getApplicationContext(), m4a1.class);
                    startActivity(m4a1);

                }
                if (position == 4) {
                    Toast.makeText(ak74.this, "Weapon Selected FAMAS", Toast.LENGTH_SHORT).show();
                    Intent famas = new Intent(getApplicationContext(), Famas.class);
                    startActivity(famas);
                }

                if (position == 5) {
                    Toast.makeText(ak74.this, "Weapon Selected FS2000", Toast.LENGTH_SHORT).show();
                    Intent fs2000 = new Intent(getApplicationContext(), fs2000.class);
                    startActivity(fs2000);
                }
                if (position == 6) {
                    Toast.makeText(ak74.this, "Weapon Selected G36C", Toast.LENGTH_SHORT).show();
                    Intent g36c = new Intent(getApplicationContext(), g36c.class);
                    startActivity(g36c);
                }
                if (position == 7) {
                    Toast.makeText(ak74.this, "Weapon Selected SG552", Toast.LENGTH_SHORT).show();
                    Intent sg552 = new Intent(getApplicationContext(), sg552.class);
                    startActivity(sg552);
                }
                if (position == 8) {
                    Toast.makeText(ak74.this, "SHOTGUN_SUPER90", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), shotgun_super90.class);
                    startActivity(SHOTGUN_SUPER90);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

    }


    //  public void Play2(View v) { //Клик на выстрел
      //      if ((patron <=30) && (patron > 0)){
       //         Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S4, 0);
       //         patron = patron - 1;
        //        patron1.setText(String.valueOf(patron));
        //    }else { Allmusicgun.OurSoundPlayer.playSound(this, Allmusicgun.OurSoundPlayer.S2, 0);
         //   }
        //}

        public void Reweapon2(View v){//Перезарядка
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
        Intent intent = new Intent(getApplicationContext(), ak47.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }

    public void Ak74go(View view) {
        Intent intent = new Intent(this, aug_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN ) {
            if (timer2 == null ) {
                timer2 = new Timer();
                timer2.scheduleAtFixedRate(new UpdateTimeTask2(), 50, 210);}
        } else if (event.getAction() == MotionEvent.ACTION_UP ) {
            timer2.cancel();
            timer2 = null;
        }if (patron == 0)
            Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S2, 0);
        return true;
    }
    class UpdateTimeTask2 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron <= 30) && (patron > 0)) {
                        Allmusicgun.OurSoundPlayer.playSound(getApplicationContext(), Allmusicgun.OurSoundPlayer.S4, 0);
                        patron = patron - 1;
                        patron1.setText(String.valueOf(patron));
                    }
                }

            });
        }

    }
}
