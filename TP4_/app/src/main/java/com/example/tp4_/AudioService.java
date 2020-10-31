package com.example.tp4_;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AudioService extends Service {
    ArrayList<AudioModel> audioList = new ArrayList<>();
    ArrayList<String> audio = new ArrayList<>();
    ArrayList<String> paths = new ArrayList<>();
    HashMap<String,String> path = new HashMap<>();
    int index;
    MediaPlayer player;
    int paused;
    AudioAdapter audioAdapter;
    ListView audioView;
    public String titreson;
    public String titreson2;
    TextView btnEgal;
    Button play;
    MediaPlayer mp;
    boolean isRunning=false;
    double second;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate(){
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        playSound(audioView);
        return START_STICKY;
    }

    public void audioPlayer(String path){
        //set up MediaPlayer
        mp = new MediaPlayer();

        try {
            mp.setDataSource(path);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mp.start();
        isRunning=true;
        second = mp.getDuration();
    }

    public void playSound(View view) {
        Button val = (Button) view.findViewById(R.id.song_title);

        if(mp !=null) {
            if (index != 0 || mp.isPlaying()) {
                titreson = "";
                mp.stop();
            }
        }

        titreson = val.getText().toString();
        Toast.makeText(this,"You've selected "+titreson, Toast.LENGTH_LONG).show();


        String l = paths.get(1);
        int i = 0;

        for (String titre : path.values()) {
            if (titre.equals(titreson)) {
                index = i;
            }
            i++;
        }
        Toast.makeText(this,"You've selected "+titreson, Toast.LENGTH_LONG).show();

        audioPlayer(paths.get(index));

        mp.seekTo(paused);
        mp.start();
        index=0;

        Toast.makeText(this,"Music's playing", Toast.LENGTH_LONG).show();
    }


    public void stopSound(View view) {
        mp.pause();
        paused = mp.getCurrentPosition();
        Toast.makeText(this,"Music has paused", Toast.LENGTH_LONG).show();

    }
    public void resetSound(View view) {
        mp.stop();
        titreson2="";
        isRunning=false;
        Toast.makeText(this,"Music has stopped", Toast.LENGTH_LONG).show();

    }

}


