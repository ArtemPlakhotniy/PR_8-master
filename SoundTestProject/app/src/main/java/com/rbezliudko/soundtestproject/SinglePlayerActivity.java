package com.rbezliudko.soundtestproject;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SinglePlayerActivity extends AppCompatActivity {

    private Button fiftyFiftyButton;
    private Button answerAButton;
    private Button answerBButton;
    private Button answerCButton;
    private Button answerDButton;

    MediaPlayer mPlayer;

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        fiftyFiftyButton = (Button) findViewById(R.id.button_LF1);
        answerAButton = (Button) findViewById(R.id.button_ansA);
        answerBButton = (Button) findViewById(R.id.button_ansB);
        answerCButton = (Button) findViewById(R.id.button_ansC);
        answerDButton = (Button) findViewById(R.id.button_ansD);

        final int MAX_STREAMS = 5;
        final SoundPool sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);

        fiftyFiftyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int fiftyFiftySound = sp.load(getAssets().openFd("fifty_fifty.mp3"), 1);
                    Log.d(LOG_TAG, "fiftyFiftySound = " + fiftyFiftySound);
                    sp.play(fiftyFiftySound, 1, 1, 0, 0, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        answerAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer = MediaPlayer.create(SinglePlayerActivity.this, R.raw.final_6);
                mPlayer.start();
                answerAButton.setBackgroundColor(Color.YELLOW);
                answerAButton.setEnabled(false);
                answerBButton.setEnabled(false);
                answerCButton.setEnabled(false);
                answerDButton.setEnabled(false);
            }
        });
    }



    private MediaPlayer releaseMP(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mediaPlayer;
    }
}
