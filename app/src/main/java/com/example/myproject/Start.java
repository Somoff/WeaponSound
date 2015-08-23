package com.example.myproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Somoff on 11.08.2015.
 */
public class Start extends Activity {

    View mDecorView;


    String url = "https://vk.com/som0ff";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);

        mDecorView = getWindow().getDecorView();
        setTitle("FullScreen");
        final ImageButton b = (ImageButton) findViewById(R.id.imageButton4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Allmusicgun.class);
                startActivity(intent);
//                overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);
            }
        });






        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

    }


    public void qwertyuiop(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("О приложении")
                .setMessage("Weapon Sound \n Version 0.0.1 \n \n \n Develops:\n Somoff \n Imperator \n Kraft \n @2015-2016")
                .setIcon(R.drawable.about_icon)
                .setInverseBackgroundForced(true)
                .setCancelable(false)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
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





    public void OnClickBrouser(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void OnClickExit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Выход")
                .setMessage("Вы точно хотите выйти?")
                .setCancelable(false)
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Спасибо вам", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Хнык", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        System.exit(0);
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }





}
