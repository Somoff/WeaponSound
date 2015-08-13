package com.example.myproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;

/**
 * Created by Somoff on 13.08.2015.
 */
public class ak47_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ak47);
    }





    public void Ak47go(View view) {
        Intent intent = new Intent(ak47_activity.this, aug_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.onetotwo, R.anim.onetwoo);

    }
    public void Chooseweaponak47(View view) {
        Intent choose = new Intent(getApplicationContext(), ak47.class);
        startActivity(choose);
    }
}