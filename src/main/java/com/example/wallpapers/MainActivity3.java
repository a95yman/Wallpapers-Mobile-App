package com.example.wallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity3 extends AppCompatActivity {

    Point p = new Point();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        for (int i = 0; i<20; i++){
            POST p = new POST(this);
            ((LinearLayout)findViewById(R.id.parr)).addView(p);
        }
        getWindowManager().getDefaultDisplay().getSize(p);
        findViewById(R.id.lnr).animate().translationY(p.y).setDuration(0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.lnr).setVisibility(View.VISIBLE);
                findViewById(R.id.bar1).animate().alpha(1).setDuration(300);
                findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Show();
                    }
                });
                findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Show();
                    }
                });
                findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Hide();
                    }
                });
            }
        }, 1000);
    }

    @Override
    public void onBackPressed() {
        if(opened==1){
            Hide();
        }
        else finish();
    }

    void Hide(){
        opened = 0;
        findViewById(R.id.lnr).animate().translationY(p.y).setDuration(500);
    }
    void Show(){
        opened = 1;
        findViewById(R.id.lnr).animate().translationY(0).setDuration(500);
    }
    int opened=0;
}