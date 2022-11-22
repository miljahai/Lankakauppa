package harjoitustyo.lankakauppa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

class APITests {

	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void checkStatus() throws Exception {
		this.mockMvc.perform(get("/patterns")).andExpect(status().isOk());
	}
	
	@Test
	public void apiStatusIsOk() throws Exception {

		this.mockMvc.perform(get("/api/patterns")).andExpect(status().isOk());
	}
}
