package com.san.spring;

import com.san.spring.bean.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class CDPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    @Bean
    //@Profile("sgtPeppers")
    CompactDisc compactDisc1() {
        return new SgtPeppers();
    }

    @Bean
    //@Profile("bonjovi")
    @Qualifier("bonjovi")
    CompactDisc compactDisc2() {
        return new Bonjovi();
    }
}
