package com.rbezliudko.soundtestproject;

import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SinglePlayerActivity extends AppCompatActivity {

    private Button fiftyFiftyButton;
    private Button answerAButton;
    private Button answerBButton;
    private Button answerCButton;
    private Button answerDButton;
    private AssetFileDescriptor descriptor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        fiftyFiftyButton = (Button) findViewById(R.id.button_LF1);
        answerAButton = (Button) findViewById(R.id.button_ansA);
        answerBButton = (Button) findViewById(R.id.button_ansB);
        answerCButton = (Button) findViewById(R.id.button_ansC);
        answerDButton = (Button) findViewById(R.id.button_ansD);

        try {
            if (GlobalAudioManager.qNumber < 6) {
                descriptor = getAssets().openFd(GlobalAudioManager.soundPack + "/question_1.mp3");
            } else {
                descriptor = getAssets().openFd(GlobalAudioManager.soundPack + "/question_"
                        + GlobalAudioManager.qNumber + ".mp3");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalAudioManager.playMusic(descriptor);

        fiftyFiftyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    descriptor = getAssets().openFd(GlobalAudioManager.soundPack + "/fifty_fifty.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playSound(descriptor);
            }
        });

        answerAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (GlobalAudioManager.qNumber < 6) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_1.mp3");
                    } else if (GlobalAudioManager.qNumber < 11) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + GlobalAudioManager.qNumber + ".mp3");
                    } else {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + (GlobalAudioManager.qNumber - 5) + ".mp3");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playMusic(descriptor);
                answerAButton.setBackgroundColor(Color.YELLOW);
                answerAButton.refreshDrawableState();
                answerAButton.setEnabled(false);
                answerBButton.setEnabled(false);
                answerCButton.setEnabled(false);
                answerDButton.setEnabled(false);
                try {
                    Thread.sleep(5000);
                    if (GlobalAudioManager.qNumber < 5) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/correct_1.mp3");
                    } else {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/correct_" + GlobalAudioManager.qNumber + ".mp3");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                answerAButton.setBackgroundColor(Color.GREEN);
                GlobalAudioManager.playMusic(descriptor);
            }
        });

        answerBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (GlobalAudioManager.qNumber == 1) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_1.mp3");
                    } else if (GlobalAudioManager.qNumber < 11) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + GlobalAudioManager.qNumber + ".mp3");
                    } else {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + (GlobalAudioManager.qNumber - 5) + ".mp3");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playMusic(descriptor);
                answerBButton.setBackgroundColor(Color.YELLOW);
                answerAButton.setEnabled(false);
                answerBButton.setEnabled(false);
                answerCButton.setEnabled(false);
                answerDButton.setEnabled(false);
            }
        });

        answerCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (GlobalAudioManager.qNumber < 11) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + GlobalAudioManager.qNumber + ".mp3");
                    } else {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + (GlobalAudioManager.qNumber - 5) + ".mp3");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playMusic(descriptor);
                answerCButton.setBackgroundColor(Color.YELLOW);
                answerAButton.setEnabled(false);
                answerBButton.setEnabled(false);
                answerCButton.setEnabled(false);
                answerDButton.setEnabled(false);
            }
        });

        answerDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (GlobalAudioManager.qNumber == 1) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_1.mp3");
                    } else if (GlobalAudioManager.qNumber < 11) {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + GlobalAudioManager.qNumber + ".mp3");
                    } else {
                        descriptor = getAssets().openFd(GlobalAudioManager.soundPack
                                + "/final_" + (GlobalAudioManager.qNumber - 5) + ".mp3");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                GlobalAudioManager.playMusic(descriptor);
                answerDButton.setBackgroundColor(Color.YELLOW);
                answerAButton.setEnabled(false);
                answerBButton.setEnabled(false);
                answerCButton.setEnabled(false);
                answerDButton.setEnabled(false);
            }
        });
    }
}
