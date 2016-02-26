package com.rbezliudko.soundtestproject;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    private Button singlePlayerButton;
    private Button multiPlayerButton;
    private Button optionsButton;
    private Button aboutButton;
    private Button quitButton;

    final String LOG_TAG = "myLogs";

    MediaPlayer mediaPlayer;
    AudioManager am;
    MediaPlayer mPlayer;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePlayerButton = (Button) findViewById(R.id.button_single_player);
        multiPlayerButton = (Button) findViewById(R.id.button_multiplayer);
        optionsButton = (Button) findViewById(R.id.button_options);
        aboutButton = (Button) findViewById(R.id.button_about);
        quitButton = (Button) findViewById(R.id.button_quit);

        final int MAX_STREAMS = 5;
        final SoundPool sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);

        mPlayer = MediaPlayer.create(this, R.raw.theme);
        mPlayer.setLooping(true);
        mPlayer.start();

        final Intent singlePlayerIntent = new Intent(MainActivity.this, SinglePlayerActivity.class);

        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                try {
                    int pingSound = sp.load(getAssets().openFd("ping1.mp3"), 1);
                    Log.d(LOG_TAG, "pingSound = " + pingSound);
                    sp.play(pingSound, 1, 1, 0, 0, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MainActivity.this.startActivity(singlePlayerIntent);
            }
        });

        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int pingSound = sp.load(getAssets().openFd("ping1.mp3"), 1);
                    Log.d(LOG_TAG, "pingSound = " + pingSound);
                    sp.play(pingSound, 1, 1, 0, 0, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int pingSound = sp.load(getAssets().openFd("ping1.mp3"), 1);
                    Log.d(LOG_TAG, "pingSound = " + pingSound);
                    sp.play(pingSound, 1, 1, 0, 0, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int pingSound = sp.load(getAssets().openFd("ping1.mp3"), 1);
                    Log.d(LOG_TAG, "pingSound = " + pingSound);
                    sp.play(pingSound, 1, 1, 0, 0, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                try {
                    int pingSound = sp.load(getAssets().openFd("ping1.mp3"), 1);
                    Log.d(LOG_TAG, "pingSound = " + pingSound);
                    sp.play(pingSound, 1, 1, 0, 0, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mPlayer.stop();
                mPlayer = releaseMP(mPlayer);
                finish();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
        mPlayer = releaseMP(mPlayer);
    }

    protected void onStop() {
        super.onStop();
        mPlayer.stop();
        mPlayer = releaseMP(mPlayer);
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
