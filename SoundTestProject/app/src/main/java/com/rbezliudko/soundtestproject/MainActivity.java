package com.rbezliudko.soundtestproject;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    private Button singlePlayerButton;
    private Button multiPlayerButton;
    private Button optionsButton;
    private Button aboutButton;
    private Button quitButton;
    private AssetFileDescriptor descriptor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singlePlayerButton = (Button) findViewById(R.id.button_single_player);
        multiPlayerButton = (Button) findViewById(R.id.button_multiplayer);
        optionsButton = (Button) findViewById(R.id.button_options);
        aboutButton = (Button) findViewById(R.id.button_about);
        quitButton = (Button) findViewById(R.id.button_quit);

        final String soundPack = getString(R.string.sound_pack);
        GlobalAudioManager.soundPack = soundPack;
        final int questionNumber = Integer.parseInt(getString(R.string.question_number));
        GlobalAudioManager.qNumber = questionNumber;

        try {
            descriptor = getAssets().openFd(soundPack + "/theme.mp3");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        GlobalAudioManager.playMusic(descriptor);

        final Intent singlePlayerIntent = new Intent(MainActivity.this, SinglePlayerActivity.class);

        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                try {
                    descriptor = getAssets().openFd(soundPack + "/ping1.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playSound(descriptor);
                /*try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                  e.printStackTrace();
                }*/
                GlobalAudioManager.releaseAll();
                MainActivity.this.startActivity(singlePlayerIntent);
            }
        });

        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    descriptor = getAssets().openFd(soundPack + "/ping1.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playSound(descriptor);
            }
        });

        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    descriptor = getAssets().openFd(soundPack + "/ping1.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playSound(descriptor);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    descriptor = getAssets().openFd(soundPack + "/ping1.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playSound(descriptor);
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w){
                try {
                    descriptor = getAssets().openFd(soundPack + "/ping1.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playSound(descriptor);
                GlobalAudioManager.releaseAll();
                finish();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        GlobalAudioManager.releaseAll();
    }

    protected void onStop() {
        super.onStop();
        GlobalAudioManager.releaseAll();
    }
}
