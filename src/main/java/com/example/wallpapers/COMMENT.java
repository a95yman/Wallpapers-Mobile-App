package com.example.wallpapers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class COMMENT extends LinearLayout {
    LayoutInflater inflater;
    public COMMENT(Context context) {
        super(context);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment, this, true);
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

            }
        });
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
