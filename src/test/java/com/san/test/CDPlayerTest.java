package com.san.test;

import com.san.spring.CDPlayerConfig;
import com.san.spring.bean.CompactDisc;
import com.san.spring.bean.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by AnNN1 on 11/16/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
//@ActiveProfiles("sgtPeppers")
public class CDPlayerTest {

    @Rule
    public final SystemOutRule log =
            new SystemOutRule().enableLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    @Qualifier("bonjovi")
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }
    @Test
    public void play() {
        player.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band" +
                        " by The Beatles",
                log.getLog());
    }
}
