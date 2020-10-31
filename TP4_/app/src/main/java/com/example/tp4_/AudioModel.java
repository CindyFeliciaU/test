package com.example.tp4_;

public class AudioModel {

    String aName;
    String aArtist;
    long id;

    public AudioModel(long id, String title, String artist) {
        this.id = id;
        this.aName = title;
        this.aArtist = artist;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaArtist() {
        return aArtist;
    }

    public void setaArtist(String aArtist) {
        this.aArtist = aArtist;
    }
}