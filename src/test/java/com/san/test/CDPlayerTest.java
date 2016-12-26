package com.san.test;

import com.san.spring.CDPlayerConfig;
import com.san.spring.aspects.TrackCounter;
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
    @Qualifier("blankDisc")
    private CompactDisc cd;

    @Autowired
    private TrackCounter counter;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }
    @Test
    public void play() {
        player.play();
    }


    @Test
    public void testTrackCounter() {
        cd.playTrack(0);
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(2);
        assertEquals(1, counter.getPlayCount(0));
        assertEquals(1, counter.getPlayCount(1));
        assertEquals(4, counter.getPlayCount(2));
        assertEquals(0, counter.getPlayCount(3));
    }
}
