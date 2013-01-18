package com.habuma.guestbook;

import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class GuestbookControllerTest {

    @Test
    public void listGuests() throws Exception {
        GuestRepository guestRepository = mock(GuestRepository.class);
        when(guestRepository.getAllGuests()).thenReturn(new ArrayList<Guest>());
        standaloneSetup(new GuestbookController(guestRepository))
                .build()
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("guest", "guests"))
                .andExpect(model().attribute("guests", new ArrayList<Guest>()));
    }

}
