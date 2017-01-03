package com.san.test;

import com.san.spring.bean.Spitter;
import com.san.spring.controller.SpitterController;
import com.san.spring.repository.SpitterRepository;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by AnNN1 on 1/3/2017.
 */
public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository =
                mock(SpitterRepository.class);
        Spitter unsaved =
                new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved =
                new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller =
                new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        //verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}
