package com.example.tp4_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.ContentResolver;
import android.content.Context;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         audioView = (ListView) findViewById(R.id.list);
         getSongList();

    }
       /* String url ="https://file-examples-com.github.io/uploads/2017/11/file_example_MP3_700KB.mp3";
        this.mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
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
    public void findSound(View view) {

        TextView val = (TextView) findViewById(R.id.song_title);
        if(index!=0){
            titreson="";
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

    }


    public void playSound(View view) {
        Button val = (Button) findViewById(R.id.song_title);

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

           //if(mp.isPlaying()==false && titreson!=titreson2){
               audioPlayer(paths.get(index));
             //  titreson2=titreson;
        //   }
          // else{
               mp.seekTo(paused);
               mp.start();
               index=0;
           //}
        Toast.makeText(this,"Music's playing", Toast.LENGTH_LONG).show();
    }

        /*final TextView songNme =  (TextView) findViewById(R.id.song_title);

        final ListView displayList = (ListView) findViewById(R.id.list);
        final String musicOnly = MediaStore.Audio.Media.IS_MUSIC + " != 0 ";

        displayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String path = paths.get(position);
                MediaPlayer currentClass = new MediaPlayer();
            });
        }
                player = MediaPlayer.create(this, Uri.parse(path));

                // songNme.setText(songList..get(position));
                //here is where to play


                   // ((MainActivity)getActivity()).getComAgent().playSong(path,songTimer.getProgress());
                    player.start();
*/

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
       public void getSongList() {
       ContentResolver musicResolver = getContentResolver();
           Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //  Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
          // Cursor    musicCursor =  musicResolver.query(musicUri,new String[] {MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media._ID} ,null, null, null);
           Cursor    musicCursor =  musicResolver.query(musicUri,new String[] {MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.ARTIST,MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA,MediaStore.Audio.Media.DISPLAY_NAME} ,null, null, null);

//
          /* if(musicCursor!=null && musicCursor.moveToFirst()){
               //get columns
               int titleColumn = musicCursor.getColumnIndex
                       (MediaStore.Audio.Media.TITLE);
               int idColumn = musicCursor.getColumnIndex
                       (MediaStore.Audio.Media._ID);
               int artistColumn = musicCursor.getColumnIndex
                       (MediaStore.Audio.Media.ARTIST);
               //add songs to list
               do {
                   long thisId = musicCursor.getLong(idColumn);
                   String thisTitle = musicCursor.getString(titleColumn);
                   String thisArtist = musicCursor.getString(artistColumn);
                   audioList.add(new AudioModel(thisId, thisTitle, thisArtist));
               }
               while (musicCursor.moveToNext());*/
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

          /* if (musicCursor.moveToFirst()) {
               do {
                   if (musicCursor.getString(0)!=null)
                   {
                       //String songPath= cursor.getString(0); //data return path
                       //String songName= cursor.getString(1); //data return name
                       paths.add(musicCursor.getString(0));
                       audio.add(musicCursor.getString(1));

                       audioList.add(new AudioModel(musicCursor.getColumnIndex
                               (MediaStore.Audio.Media._ID),getString(musicCursor.getColumnIndex
                               (MediaStore.Audio.Media.TITLE)),getString(musicCursor.getColumnIndex
                               (MediaStore.Audio.Media.ARTIST))) );
                   }

               } while (musicCursor.moveToNext());
           }*/
           musicCursor.close();

           AudioAdapter songAdt = new AudioAdapter(this, audioList);
           audioView.setAdapter(songAdt);
       }


       }

