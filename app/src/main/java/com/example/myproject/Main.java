package com.example.myproject;

import android.app.Activity;
import android.os.Bundle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

public class Main extends Activity implements OnTouchListener
{
    private ViewFlipper flipper = null;
    private float fromPosition;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
        mainLayout.setOnTouchListener(this);

        flipper = (ViewFlipper) findViewById(R.id.flipper);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int layouts[] = new int[]{ R.layout.ak47, R.layout.aug, R.layout.m4a1, R.layout.ak74};
        for (int layout : layouts)
            flipper.addView(inflater.inflate(layout, null));
    }

    public boolean onTouch(View view, MotionEvent event)
    {
        switch (event.getAction())
        {
        case MotionEvent.ACTION_DOWN:
            fromPosition = event.getX();
            break;
        case MotionEvent.ACTION_UP:
            float toPosition = event.getX();
            if (fromPosition > toPosition)
            {
                flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_out));
                flipper.showNext();
            }
            else if (fromPosition < toPosition)
            {
                flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_in));
                flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_out));
                flipper.showPrevious();
            }
        default:
            break;
        }
        return true;
    }
}