package com.san.spring;

import com.san.spring.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
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
    @Primary
    CompactDisc compactDisc1() {
        return new SgtPeppers(env.getProperty("disc.title"), env.getProperty("disc.artist"));
    }

    @Bean(name = "bonjovi")
    //@Profile("bonjovi")
    CompactDisc compactDisc2() {
        return new Bonjovi();
    }
}
