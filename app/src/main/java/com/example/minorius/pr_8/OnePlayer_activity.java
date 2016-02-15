package com.example.minorius.pr_8;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class OnePlayer_activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{


    private TextView txt_question;
    private TextView txt_answer_a;
    private TextView txt_answer_b;
    private TextView txt_answer_c;
    private TextView txt_answer_d;

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

    public static String PATH = "https://minorius.firebaseio.com";
    public static String CATEGORY = "/math/";

    public static String answer;
    public static String ans_a;
    public static String ans_b;
    public static String ans_c;
    public static String ans_d;

    Firebase fb;

    public static int key_r;

    Bundle b;
    Loader<String> ls;

    public static final int LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        txt_question = (TextView) findViewById(R.id.txt_question);

        txt_answer_a = (TextView) findViewById(R.id.txt_answer_a);
        txt_answer_b = (TextView) findViewById(R.id.txt_answer_b);
        txt_answer_c = (TextView) findViewById(R.id.txt_answer_c);
        txt_answer_d = (TextView) findViewById(R.id.txt_answer_d);

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

        Random r = new Random();
        key_r = r.nextInt(4);
        
        Firebase.setAndroidContext(getApplicationContext());
        fb = new Firebase(PATH+CATEGORY+""+key_r);

        fb.child("question").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txt_question.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        fb.child("answer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                answer = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        fb.child("a").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ans_a = dataSnapshot.getValue().toString();
                txt_answer_a.setText(ans_a);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        fb.child("b").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ans_b = dataSnapshot.getValue().toString();
                txt_answer_b.setText(ans_b);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        fb.child("c").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ans_c = dataSnapshot.getValue().toString();
                txt_answer_c.setText(ans_c);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        fb.child("d").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ans_d = dataSnapshot.getValue().toString();
                txt_answer_d.setText(ans_d);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        btn_answer_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_1_v.setVisibility(View.VISIBLE);
                if(answer == ans_a){
                    back_1_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_b) {
                    back_2_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_c) {
                    back_3_true.setVisibility(View.VISIBLE);
                }else {
                    back_4_true.setVisibility(View.VISIBLE);
                }

                Random r = new Random();
                key_r = r.nextInt(4);
            }
        });
        btn_answer_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_2_v.setVisibility(View.VISIBLE);
                if(answer == ans_a){
                    back_1_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_b) {
                    back_2_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_c) {
                    back_3_true.setVisibility(View.VISIBLE);
                }else {
                    back_4_true.setVisibility(View.VISIBLE);
                }
                Random r = new Random();
                key_r = r.nextInt(4);
            }
        });
        btn_answer_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_3_v.setVisibility(View.VISIBLE);
                if(answer == ans_a){
                    back_1_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_b) {
                    back_2_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_c) {
                    back_3_true.setVisibility(View.VISIBLE);
                }else {
                    back_4_true.setVisibility(View.VISIBLE);
                }
                Random r = new Random();
                key_r = r.nextInt(4);
            }
        });
        btn_answer_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_4_v.setVisibility(View.VISIBLE);
                if(answer == ans_a){
                    back_1_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_b) {
                    back_2_true.setVisibility(View.VISIBLE);
                }else if (answer == ans_c) {
                    back_3_true.setVisibility(View.VISIBLE);
                }else {
                    back_4_true.setVisibility(View.VISIBLE);
                }
                Random r = new Random();
                key_r = r.nextInt(4);
            }
        });



        b = new Bundle();
        ls = getSupportLoaderManager().initLoader(LOADER_ID, b, this);

    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        ls = new Loader_fb(this);
        return ls;
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}

