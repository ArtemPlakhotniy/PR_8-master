package com.example.minorius.pr_8.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minorius.pr_8.Communicator;
import com.example.minorius.pr_8.GS;
import com.example.minorius.pr_8.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;

public class Single_player extends Fragment{

    private GS gs;
    private Firebase fb;

    private TextView txt_question;
    private TextView txt_answer_a;
    private TextView txt_answer_b;
    private TextView txt_answer_c;
    private TextView txt_answer_d;

    private ImageView btn_answer_a;
    private ImageView btn_answer_b;
    private ImageView btn_answer_c;
    private ImageView btn_answer_d;

//    private ImageView back_1_v;
//    private ImageView back_1_true;
//    private ImageView back_2_v;
//    private ImageView back_2_true;
//    private ImageView back_3_v;
//    private ImageView back_3_true;
//    private ImageView back_4_v;
//    private ImageView back_4_true;

    public static String PATH;
    public static String CATEGORY;
    public static int key_r;

    Communicator comm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.prototype, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        txt_question = (TextView) getActivity().findViewById(R.id.txt_question);
        txt_answer_a = (TextView) getActivity().findViewById(R.id.txt_answer_a);
        txt_answer_b = (TextView) getActivity().findViewById(R.id.txt_answer_b);
        txt_answer_c = (TextView) getActivity().findViewById(R.id.txt_answer_c);
        txt_answer_d = (TextView) getActivity().findViewById(R.id.txt_answer_d);

//        back_1_v = (ImageView) getActivity().findViewById(R.id.back_1_v);
//        back_1_true = (ImageView) getActivity().findViewById(R.id.back_1_true);
//        back_2_v = (ImageView) getActivity().findViewById(R.id.back_2_v);
//        back_2_true = (ImageView) getActivity().findViewById(R.id.back_2_true);
//        back_3_v = (ImageView) getActivity().findViewById(R.id.back_3_v);
//        back_3_true = (ImageView) getActivity().findViewById(R.id.back_3_true);
//        back_4_v = (ImageView) getActivity().findViewById(R.id.back_4_v);
//        back_4_true = (ImageView) getActivity().findViewById(R.id.back_4_true);

        Firebase.setAndroidContext(getActivity().getApplicationContext());
        fb = new Firebase(PATH+CATEGORY+key_r);

        fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gs = new GS();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    switch (ds.getKey()) {
                        case "a":
                            gs.setA(ds.getValue().toString());
                            break;
                        case "b":
                            gs.setB(ds.getValue().toString());
                            break;
                        case "c":
                            gs.setC(ds.getValue().toString());
                            break;
                        case "d":
                            gs.setD(ds.getValue().toString());
                            break;
                        case "answer":
                            gs.setAnswer(ds.getValue().toString());
                            break;
                        case "question":
                            gs.setQuestion(ds.getValue().toString());
                            break;

                    }
                }

                txt_question.setText(gs.getQuestion());
                txt_answer_a.setText(gs.getA());
                txt_answer_b.setText(gs.getB());
                txt_answer_c.setText(gs.getC());
                txt_answer_d.setText(gs.getD());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
            }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        comm = (Communicator) getActivity();

        btn_answer_a = (ImageView) getActivity().findViewById(R.id.btn_answer_a);
        btn_answer_b = (ImageView) getActivity().findViewById(R.id.btn_answer_b);
        btn_answer_c = (ImageView) getActivity().findViewById(R.id.btn_answer_c);
        btn_answer_d = (ImageView) getActivity().findViewById(R.id.btn_answer_d);

        btn_answer_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.fragmentCallBack("Click a");
            }
        });

        btn_answer_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.fragmentCallBack("Click b");
            }
        });

        btn_answer_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.fragmentCallBack("Click c");
            }
        });

        btn_answer_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comm.fragmentCallBack("Click d");
            }
        });
    }
}
