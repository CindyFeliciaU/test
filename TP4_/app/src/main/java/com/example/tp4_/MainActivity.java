package com.example.tp4_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
    TextView songTitle;
    Button song_Title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioView = (ListView) this.findViewById(R.id.list);
        getSongList();
        song_Title = findViewById(R.id.song_title);
    }

  public void start(View v){
              Intent i = new Intent(MainActivity.this, AudioService.class);
              startService(i);
          }



       public void getSongList() {
       ContentResolver musicResolver = getContentResolver();
           Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
         Cursor    musicCursor =  musicResolver.query(musicUri,new String[] {MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA,MediaStore.Audio.Media.DISPLAY_NAME} ,null, null, null);
           if (musicCursor.moveToFirst()) {
               do {
                   if (musicCursor.getString(0)!=null)
                   {
                       //String songPath= cursor.getString(0); //data return path
                       //String songName= cursor.getString(1); //data return name
                       paths.add(musicCursor.getString(0));
                       String artist =(musicCursor.getString(1));
                       String title =(musicCursor.getString(2));
                       int id =(musicCursor.getInt(3));
                       audioList.add(new AudioModel(id, title, artist));
                       path.put(musicCursor.getString(0),musicCursor.getString(2));
                   }

               } while (musicCursor.moveToNext());
           }

                musicCursor.close();

           AudioAdapter songAdt = new AudioAdapter(this, audioList);
           audioView.setAdapter(songAdt);
       }


       }

