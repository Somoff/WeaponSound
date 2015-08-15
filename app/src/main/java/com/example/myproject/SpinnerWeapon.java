package com.example.myproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class SpinnerWeapon extends Activity{

    String[] data = {"ak47", "ak74", "AUG", "M16", "Start"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weapon_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        android.widget.Spinner spinner = (android.widget.Spinner) findViewById(R.id.spinner_weapon);
        spinner.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CustomAdapter.flag = true;
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                if (position == 1){
                    Intent ak47 = new Intent(getApplicationContext(), ak47.class);
                startActivity(ak47);
            }
                if(position == 2){
                    Intent ak74 = new Intent(getApplicationContext(), ak74.class);
                    startActivity(ak74);
                }
                if(position == 3){
                    Intent aug = new Intent (getApplicationContext(), aug_activity.class);
                    startActivity(aug);
                }
                if(position == 4){
                    Intent m4a1 = new Intent(getApplicationContext(), m4a1.class);
                    startActivity(m4a1);

                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

    }
}
