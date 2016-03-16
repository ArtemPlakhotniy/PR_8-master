package com.rbezliudko.soundtestproject;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class GlobalAudioManager {

    public static MediaPlayer mPlayer = new MediaPlayer();
    public static MediaPlayer sPlayer = new MediaPlayer();
    public static String soundPack;
    public static int qNumber;

    public static void playMusic(AssetFileDescriptor descriptor) {
        GlobalAudioManager.releaseMP(mPlayer);
        try {
            mPlayer = new MediaPlayer();
            mPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            mPlayer.prepare();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        mPlayer.setVolume(1f, 1f);
        mPlayer.setLooping(true);
        mPlayer.start();
    }

    public static void playSound(AssetFileDescriptor descriptor) {
        GlobalAudioManager.releaseMP(sPlayer);
        try {
            sPlayer = new MediaPlayer();
            sPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();
            sPlayer.prepare();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        sPlayer.setVolume(1f, 1f);
        sPlayer.setLooping(false);
        sPlayer.start();
    }

    public static MediaPlayer releaseMP(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mediaPlayer;
    }

    public static void releaseAll() {
        if (mPlayer != null) {
            try {
                mPlayer.stop();
                mPlayer.release();
                mPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sPlayer != null) {
            try {
                sPlayer.stop();
                sPlayer.release();
                sPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
