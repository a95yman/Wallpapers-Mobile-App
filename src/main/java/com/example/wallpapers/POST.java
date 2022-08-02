package com.example.wallpapers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

public class POST extends LinearLayout {
    LayoutInflater inflater;
    public POST(Context context) {
        super(context);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.post, this, true);
        findViewById(R.id.heart).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              if(c==0){
                  c=1;
                  findViewById(R.id.heart).setBackgroundResource(R.drawable.heart_filled);
              }
              else {
                  c=0;
                  findViewById(R.id.heart).setBackgroundResource(R.drawable.heart_stroke);
              }
            }
        });
        findViewById(R.id.comments).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c2==0){
                    c2=1;
                    findViewById(R.id.commentsbar).setVisibility(VISIBLE);
                }
                else {
                    c2=0;
                    findViewById(R.id.commentsbar).setVisibility(GONE);
                }
            }
        });
        int rnd = new Random().nextInt(6);
        if(rnd==0) rnd = 1;
        for (int i = 0; i< rnd; i++){
            COMMENT com = new COMMENT(context);
            ((LinearLayout)findViewById(R.id.commentsbar)).addView(com);
        }
        findViewById(R.id.me).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MainActivity3.class));
            }
        });
    }
    int c = 0;
    int c2 = 0;
}
