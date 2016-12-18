package com.san.spring;

import com.san.spring.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CDPlayerConfig {

    @Bean
    public MediaPlayer mediaPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    @Bean
    @Profile("sgtPeppers")
    CompactDisc compactDisc1() {
        return new SgtPeppers();
    }

    @Bean
    @Profile("bonjovi")
    CompactDisc compactDisc2() {
        return new Bonjovi();
    }
}
