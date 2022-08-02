package com.example.wallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {
    Point p = new Point();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindowManager().getDefaultDisplay().getSize(p);
        findViewById(R.id.page2).animate().translationX(p.x).setDuration(0);
        findViewById(R.id.mainnav).animate().translationX(-p.x).setDuration(0);
        findViewById(R.id.sr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.searchbar).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.closenav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HideNav();
            }
        });
        for (int i = 0; i<10; i++){
            POST p = new POST(this);
            ((LinearLayout)findViewById(R.id.parr)).addView(p);
        }
        nav = findViewById(R.id.nav);
        tmp =(LinearLayout) nav.getChildAt(0);
        findViewById(R.id.me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity3.class));
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.page2).setVisibility(View.VISIBLE);
                findViewById(R.id.mainnav).setVisibility(View.VISIBLE);

                findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Hide();

                    }
                });
                for (int i = 0; i<nav.getChildCount(); i++){
                    int ind = i;
                    nav.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(tmp != null){
                                tmp.getChildAt(1).setVisibility(View.GONE);
                            }
                            tmp = (LinearLayout) view;
                            tmp.getChildAt(1).setVisibility(View.VISIBLE);
                            if(ind == 0){
                                Hide();
                            }
                            else if(ind == 1){
                                Show();
                            }
                            else if(ind == 2){
                                ShowNav();
                            }
                        }
                    });
                }
            }
        }, 500);
        parr2 = findViewById(R.id.parr2);
        for(int i = 0; i<parr2.getChildCount(); i++){
            parr2.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MainActivity4.class));
                }
            });
        }

    }
    LinearLayout parr2;
    int opened = 0;

    @Override
    public void onBackPressed() {
        if (n == 1) {
            HideNav();
        } else {
            if (opened == 1) {
                Hide();
            } else finish();
        }
    }

    void Show(){
        opened = 1;
        findViewById(R.id.page1).animate().translationX(-p.x).setDuration(500);
        findViewById(R.id.page2).animate().translationX(0).setDuration(500);
    }
    void Hide(){
        tmp = (LinearLayout)  nav.getChildAt(2);
        tmp.getChildAt(1).setVisibility(View.GONE);
        tmp = (LinearLayout)  nav.getChildAt(1);
        tmp.getChildAt(1).setVisibility(View.GONE);
        opened = 0;
        tmp = (LinearLayout)  nav.getChildAt(opened);
        tmp.getChildAt(1).setVisibility(View.VISIBLE);
        findViewById(R.id.page2).animate().translationX(p.x).setDuration(500);
        findViewById(R.id.page1).animate().translationX(0).setDuration(500);
    }
    LinearLayout tmp, nav;
    int n = 0;
    void ShowNav(){
        n = 1;
        findViewById(R.id.mainpage).animate().translationX(p.x - 150).setDuration(500);
        findViewById(R.id.mainpage).animate().scaleX(0.9f).setDuration(500);
        findViewById(R.id.mainpage).animate().scaleY(0.9f).setDuration(500);
        findViewById(R.id.mainnav).animate().translationX(0).setDuration(500);
    }
    void HideNav(){
        tmp = (LinearLayout)  nav.getChildAt(2);
        tmp.getChildAt(1).setVisibility(View.GONE);
        tmp = (LinearLayout)  nav.getChildAt(opened);
        tmp.getChildAt(1).setVisibility(View.VISIBLE);
        n = 0;
        findViewById(R.id.mainnav).animate().translationX(-p.x).setDuration(500);
        findViewById(R.id.mainpage).animate().translationX(0).setDuration(500);
        findViewById(R.id.mainpage).animate().scaleX(1f).setDuration(500);
        findViewById(R.id.mainpage).animate().scaleY(1f).setDuration(500);
    }
}