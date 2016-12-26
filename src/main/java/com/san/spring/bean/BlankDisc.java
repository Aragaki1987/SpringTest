package com.san.spring.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by AnNN1 on 12/26/2016.
 */
@Component
@Qualifier("blankDisc")
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;
    private List<String> tracks;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
    public void play() {
        System.out.println("Playing " + title+"by"+artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

    public void playTrack(int trackNumber) {
        System.out.println("Playing track " + trackNumber + " : " + tracks.get(trackNumber));
    }
}
