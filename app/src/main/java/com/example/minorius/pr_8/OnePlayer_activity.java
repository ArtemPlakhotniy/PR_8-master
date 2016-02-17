package com.example.minorius.pr_8;

import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.example.minorius.pr_8.Fragment.Single_player;
import com.firebase.client.Firebase;


import java.util.ArrayList;
import java.util.Random;

public class OnePlayer_activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    private GS gs;
    private Single_player sp;
    private Firebase fb;

    public static String answer;
    public static String ans_a;
    public static String ans_b;
    public static String ans_c;
    public static String ans_d;

    private ImageView btn_answer_a;
    private ImageView btn_answer_b;
    private ImageView btn_answer_c;
    private ImageView btn_answer_d;

    private ImageView back_1_v;
    private ImageView back_1_true;
    private ImageView back_2_v;
    private ImageView back_2_true;
    private ImageView back_3_v;
    private ImageView back_3_true;
    private ImageView back_4_v;
    private ImageView back_4_true;

    private String PATH = "https://minorius.firebaseio.com";
    public static String CATEGORY = "/math/";


    Bundle b;
    Loader<String> ls;
    public static final int LOADER_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        btn_answer_a = (ImageView) findViewById(R.id.btn_answer_a);
        btn_answer_b = (ImageView) findViewById(R.id.btn_answer_b);
        btn_answer_c = (ImageView) findViewById(R.id.btn_answer_c);
        btn_answer_d = (ImageView) findViewById(R.id.btn_answer_d);

        back_1_v = (ImageView) findViewById(R.id.back_1_v);
        back_1_true = (ImageView) findViewById(R.id.back_1_true);
        back_2_v = (ImageView) findViewById(R.id.back_2_v);
        back_2_true = (ImageView) findViewById(R.id.back_2_true);
        back_3_v = (ImageView) findViewById(R.id.back_3_v);
        back_3_true = (ImageView) findViewById(R.id.back_3_true);
        back_4_v = (ImageView) findViewById(R.id.back_4_v);
        back_4_true = (ImageView) findViewById(R.id.back_4_true);

        Firebase.setAndroidContext(getApplicationContext());
        fb = new Firebase(PATH+CATEGORY);

        Random r = new Random();
        sp = new Single_player(PATH, CATEGORY, r.nextInt(4));

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.buffer_fragment, sp).commit();



//        btn_answer_a.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                back_1_v.setVisibility(View.VISIBLE);
//                if (answer == ans_a) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_b) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_c) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//
//
//            }
//        });
//        btn_answer_b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                back_2_v.setVisibility(View.VISIBLE);
//                if (answer == ans_a) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_b) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_c) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        btn_answer_c.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                back_3_v.setVisibility(View.VISIBLE);
//                if (answer == ans_a) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_b) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_c) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        btn_answer_d.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                back_4_v.setVisibility(View.VISIBLE);
//                if (answer == ans_a) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_b) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (answer == ans_c) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//            }
//        });

        b = new Bundle();
        ls = getSupportLoaderManager().initLoader(LOADER_ID, b, this);

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        ls = new Loader_fb(this, args);
        return ls;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }


}

