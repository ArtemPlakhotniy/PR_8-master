package com.example.minorius.pr_8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public ImageView back_1;
    public ImageView back_2;
    public ImageView back_3;
    public ImageView back_4;
    public ImageView back_5;

    public ImageView main_1;
    public ImageView main_2;
    public ImageView main_3;
    public ImageView main_4;
    public ImageView main_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back_1 = (ImageView) findViewById(R.id.back_1);
        back_2 = (ImageView) findViewById(R.id.back_2);
        back_3 = (ImageView) findViewById(R.id.back_3);
        back_4 = (ImageView) findViewById(R.id.back_4);
        back_5 = (ImageView) findViewById(R.id.back_5);

        main_1 = (ImageView) findViewById(R.id.main_1);
        main_2 = (ImageView) findViewById(R.id.main_2);
        main_3 = (ImageView) findViewById(R.id.main_3);
        main_4 = (ImageView) findViewById(R.id.main_4);
        main_5 = (ImageView) findViewById(R.id.main_5);

        main_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1.setVisibility(View.VISIBLE);
                back_2.setVisibility(View.INVISIBLE);
                back_3.setVisibility(View.INVISIBLE);
                back_4.setVisibility(View.INVISIBLE);
                back_5.setVisibility(View.INVISIBLE);

                Intent i = new Intent(getApplicationContext(), OnePlayer_activity.class);
                startActivity(i);
            }
        });

        main_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1.setVisibility(View.INVISIBLE);
                back_2.setVisibility(View.VISIBLE);
                back_3.setVisibility(View.INVISIBLE);
                back_4.setVisibility(View.INVISIBLE);
                back_5.setVisibility(View.INVISIBLE);
            }
        });

        main_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1.setVisibility(View.INVISIBLE);
                back_2.setVisibility(View.VISIBLE);
                back_3.setVisibility(View.INVISIBLE);
                back_4.setVisibility(View.INVISIBLE);
                back_5.setVisibility(View.INVISIBLE);
            }
        });

        main_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1.setVisibility(View.INVISIBLE);
                back_2.setVisibility(View.INVISIBLE);
                back_3.setVisibility(View.VISIBLE);
                back_4.setVisibility(View.INVISIBLE);
                back_5.setVisibility(View.INVISIBLE);
            }
        });

        main_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1.setVisibility(View.INVISIBLE);
                back_2.setVisibility(View.INVISIBLE);
                back_3.setVisibility(View.INVISIBLE);
                back_4.setVisibility(View.VISIBLE);
                back_5.setVisibility(View.INVISIBLE);
            }
        });

        main_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1.setVisibility(View.INVISIBLE);
                back_2.setVisibility(View.INVISIBLE);
                back_3.setVisibility(View.INVISIBLE);
                back_4.setVisibility(View.INVISIBLE);
                back_5.setVisibility(View.VISIBLE);
            }
        });
    }
}