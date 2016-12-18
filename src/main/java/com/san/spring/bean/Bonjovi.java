package com.san.spring.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by AnNN1 on 11/17/2016.
 */
@Component
@Qualifier("bonjovi")
public class Bonjovi implements CompactDisc {
    public void play() {
        System.out.println("Bonjovi is best");
    }
}
