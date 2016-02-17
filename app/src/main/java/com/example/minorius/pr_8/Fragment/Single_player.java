package com.example.minorius.pr_8.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minorius.pr_8.GS;
import com.example.minorius.pr_8.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Single_player extends Fragment {

    private TextView txt_question;
    private TextView txt_answer_a;
    private TextView txt_answer_b;
    private TextView txt_answer_c;
    private TextView txt_answer_d;

    private GS gs;
    private Firebase fb;

    private String PATH;
    private String CATEGORY;
    private int key_r;

    public Single_player(String PATH, String CATEGORY, int key_r) {
        this.PATH = PATH;
        this.CATEGORY = CATEGORY;
        this.key_r = key_r;
    }

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

        Firebase.setAndroidContext(getActivity().getApplicationContext());
        fb = new Firebase(PATH+CATEGORY+key_r);

        fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                gs = new GS();

                for(DataSnapshot ds : dataSnapshot.getChildren()){

                    switch (ds.getKey()){
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
}
