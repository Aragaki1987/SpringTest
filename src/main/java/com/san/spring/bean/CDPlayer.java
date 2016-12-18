package com.san.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by AnNN1 on 11/16/2016.
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;
    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }
    public void play() {
        cd.play();
    }
}
