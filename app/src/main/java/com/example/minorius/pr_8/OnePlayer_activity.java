package com.example.minorius.pr_8;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minorius.pr_8.Fragment.Single_player;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


import java.util.ArrayList;
import java.util.Random;

public class OnePlayer_activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>, Communicator{

    private GS gs;
    private Single_player sp;
    private Firebase fb;

    private ImageView btn_answer_a;
    private ImageView btn_answer_b;
    private ImageView btn_answer_c;
    private ImageView btn_answer_d;

    private String PATH = "https://minorius.firebaseio.com";
    public static String CATEGORY = "/math/";





    Bundle b;
    Loader<String> ls;
    public static final int LOADER_ID = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        Random r = new Random();
        sp = new Single_player();
        sp.PATH = PATH;
        sp.CATEGORY = CATEGORY;
        sp.key_r  = r.nextInt(4);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.buffer_fragment, sp).commit();

//        btn_answer_a.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gs = new GS();
//
//                back_1_v.setVisibility(View.VISIBLE);
//
//                if (gs.getAnswer() == gs.getA()) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getB()) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getC()) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });
//
//        btn_answer_b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gs = new GS();
//
//                back_2_v.setVisibility(View.VISIBLE);
//                if (gs.getAnswer() == gs.getA()) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getB()) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getC()) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });
//
//        btn_answer_c.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gs = new GS();
//
//                back_3_v.setVisibility(View.VISIBLE);
//                if (gs.getAnswer() == gs.getA()) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getB()) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getC()) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });
//
//        btn_answer_d.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gs = new GS();
//
//                back_4_v.setVisibility(View.VISIBLE);
//                if (gs.getAnswer() == gs.getA()) {
//                    back_1_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getB()) {
//                    back_2_true.setVisibility(View.VISIBLE);
//                } else if (gs.getAnswer() == gs.getC()) {
//                    back_3_true.setVisibility(View.VISIBLE);
//                } else {
//                    back_4_true.setVisibility(View.VISIBLE);
//                }
//
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

    @Override
    public void fragmentCallBack(String a) {

        Random r = new Random();
        sp = new Single_player();
        sp.PATH = PATH;
        sp.CATEGORY = CATEGORY;
        sp.key_r  = r.nextInt(4);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.buffer_fragment, sp).commit();
    }
}

