package com.example.myproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Somoff on 13.08.2015.
 */
public class aug_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aug);
    }


    public void backaug(View view){
        Intent intent = new Intent(getApplicationContext(), ak47_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.twotoone, R.anim.twotoonee);
    }
}
