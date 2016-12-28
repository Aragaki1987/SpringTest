package com.san.spring.config;

import com.san.spring.aspects.Audience;
import com.san.spring.aspects.EncoreableIntroducer;
import com.san.spring.aspects.TrackCounter;
import com.san.spring.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("context.properties")
public class CDPlayerConfig {

    @Autowired
    Environment env;

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    @Bean("sgtPeppers")
    //@Profile("sgtPeppers")
    //@Qualifier("sgtPeppers")
    CompactDisc compactDisc1() {
        return new SgtPeppers(env.getProperty("disc.title"), env.getProperty("disc.artist"));
    }

    @Bean(name = "bonjovi")
    //@Profile("bonjovi")
    CompactDisc compactDisc2() {
        return new Bonjovi();
    }

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }

    @Bean
    @Primary
    public CompactDisc blankDisc() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        List<String> tracks = new ArrayList<String>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");

        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}
