package com.habuma.guestbook;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.server.setup.MockMvcBuilders.*;

import java.util.ArrayList;

import org.junit.Test;

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
