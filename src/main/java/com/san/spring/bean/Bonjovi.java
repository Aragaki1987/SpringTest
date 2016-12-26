package com.san.spring.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by AnNN1 on 11/17/2016.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class Bonjovi implements CompactDisc {
    public void play() {
        System.out.println("Bonjovi is best");
    }

    public void playTrack(int track) {

    }
}
