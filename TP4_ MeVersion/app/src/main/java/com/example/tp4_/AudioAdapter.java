package com.example.tp4_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AudioAdapter extends BaseAdapter {
    private  String artist;
    private  String title;
    private  int id;
    private ArrayList<AudioModel> audioList;

    private Context c;
    private LayoutInflater inflater;

    public AudioAdapter(Context c, ArrayList<AudioModel> audioList) {

        this.audioList=audioList;
        this.inflater=LayoutInflater.from(c);
    }


    @Override
    public int getCount() {
        return audioList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//      //  LayoutInflater v = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View vi = inflater.inflate(R.layout.activity_main,viewGroup,false);
//        TextView title = (TextView)vi.findViewById(R.id.song_title);
//        TextView artist = (TextView)vi.findViewById(R.id.song_artist);
//        AudioModel audio = audioList.get(i);
//        title.setText(audio.getaName());
//        artist.setText(audio.getaArtist());
//       // vi.setTag(i);
//        return vi;
//
        LinearLayout songLay = (LinearLayout)inflater.inflate (R.layout.song, null, false);
        //get title and artist views
        TextView songView = (TextView)songLay.findViewById(R.id.song_title);
        TextView artistView = (TextView)songLay.findViewById(R.id.song_artist);
        //get song using position of the current row
        AudioModel currSong = audioList.get(i);
        //get title and artist strings
        songView.setText(currSong.getaName());
        artistView.setText(currSong.getaArtist());
        //set position as tag
        //songLay.setTag(i);
        return songLay;
  }
}
