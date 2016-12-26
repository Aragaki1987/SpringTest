package com.san.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
    private String title = null;
    private String artist = null;

    public SgtPeppers(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.print("Playing " + title+" by "+artist);
    }
}
