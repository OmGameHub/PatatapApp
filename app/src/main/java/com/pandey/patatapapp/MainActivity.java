package com.pandey.patatapapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer[] mediaPlayer;
    private int currentMedia = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer[6];
        currentMedia = 0;
    }

    public void onNumberTapped(View view)
    {
        int buttonId = view.getId();
        String musicNameID = view.getResources().getResourceEntryName(buttonId);
        int musicId = getResources().getIdentifier(musicNameID, "raw", "com.pandey.patatapapp");

        stopPlaying();
        mediaPlayer[currentMedia] = MediaPlayer.create(this, musicId);
        mediaPlayer[currentMedia].start();

        currentMedia++;
        if (currentMedia >= mediaPlayer.length) {
            currentMedia = 0;
        }

        Log.i("INDEX", "currentMedia: "+currentMedia);
    }

    // stop media player if playing
    private void stopPlaying() {
        Log.i("INDEX", "currentMedia: "+mediaPlayer[currentMedia]);
        if (mediaPlayer[currentMedia] != null) {
            mediaPlayer[currentMedia].stop();
            mediaPlayer[currentMedia].release();
            mediaPlayer[currentMedia] = null;
        }
    }
}
