package com.example.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Somoff on 19.08.2015.
 */
public class Deserteagl extends Allmusicgun implements View.OnTouchListener {
    Timer timer;
    public int patron9 = 7;
    String[] data = {"AK47", "AK74", "AUG", "M4A1", "FAMAS", "FS2000", "G36C", "SG552","SHOTGUN_SUPER90","DESERTEAGLE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.deserteagl);
        patron1 = (TextView) findViewById(R.id.txtnumberdesert);
        patron1.setText(String.valueOf(patron9));
        ImageView something = (ImageView) findViewById(R.id.Desertbutton);
        something.setOnTouchListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        android.widget.Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinner4766);
        spinner.setAdapter(adapter);

        spinner.setSelection(9, true);

        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CustomAdapter.flag = true;

                if (position == 0) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected AK47", Toast.LENGTH_SHORT).show();
                    Intent ak47 = new Intent(getApplicationContext(), ak47.class);
                    startActivity(ak47);
                }
                if (position == 1) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected AK74", Toast.LENGTH_SHORT).show();
                    Intent ak74 = new Intent(getApplicationContext(), ak74.class);
                    startActivity(ak74);
                }
                if (position == 2) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected AUG", Toast.LENGTH_SHORT).show();
                    Intent aug = new Intent(getApplicationContext(), aug_activity.class);
                    startActivity(aug);
                }
                if (position == 3) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected M4A1", Toast.LENGTH_SHORT).show();
                    Intent m4a1 = new Intent(getApplicationContext(), m4a1.class);
                    startActivity(m4a1);

                }
                if (position == 4) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected FAMAS", Toast.LENGTH_SHORT).show();
                    Intent famas = new Intent(getApplicationContext(), Famas.class);
                    startActivity(famas);
                }

                if (position == 5) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected FS2000", Toast.LENGTH_SHORT).show();
                    Intent fs2000 = new Intent(getApplicationContext(), fs2000.class);
                    startActivity(fs2000);
                }
                if (position == 6) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected G36C", Toast.LENGTH_SHORT).show();
                    Intent g36c = new Intent(getApplicationContext(), g36c.class);
                    startActivity(g36c);
                }
                if (position == 7) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected SG552", Toast.LENGTH_SHORT).show();
                    Intent sg552 = new Intent(getApplicationContext(), sg552.class);
                    startActivity(sg552);
                }
                if (position == 8) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected SHOTGUN_SUPER90", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), shotgun_super90.class);
                    startActivity(SHOTGUN_SUPER90);
                }
                if (position == 9) {
                    Toast.makeText(Deserteagl.this, "Weapon Selected DESERTEAGLE", Toast.LENGTH_SHORT).show();
                    Intent SHOTGUN_SUPER90 = new Intent(getApplicationContext(), Deserteagl.class);
                    startActivity(SHOTGUN_SUPER90);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

    }




    public void AlertDialogDESERTEAGLE(View view) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(Deserteagl.this);

        builder.setTitle("Desert Eagle")
                .setMessage("Страна: США \n Масса: 1,7кг \n Длина: 269мм \n Калибр: .41 Magnum \n Начальная скорость пули: 395 м/c \n Максимальная дальность: 200м")
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

    public void Reweapon10(View v){//Перезарядка
        playSound(Zatvor);
        patron9=7;
        patron1.setText(String.valueOf(patron9));
        try {
            Thread.sleep(3500);
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }

    public void backdesert(View view) {
        Intent intent = new Intent(getApplicationContext(), shotgun_super90.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
    public void desertgo(View view) {
        Intent intent = new Intent(this, ak47.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (timer == null) {
                timer = new Timer();
                timer.scheduleAtFixedRate(new UpdateTimeTask9(), 50, 300);
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            timer.cancel();
            timer = null;
        }
        if (patron9 == 0)
            playSound(block);
        return true;
    }
    class UpdateTimeTask9 extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if ((patron9 <= 7) && (patron9 > 0)) {
                        playSound(deagle);
                        patron9 = patron9 - 1;
                        patron1.setText(String.valueOf(patron9));
                    }
                }

            });
        }
    }
}
