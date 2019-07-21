package com.victor.simian;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.victor.simian.constants.DnaConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimianDnaApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

//	@Test
//	public void testHome() throws Exception {
//
//		String URL1=DnaConstants.URL_API+DnaConstants.URL_SIMIAN;
//
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.add("Cache-Control", "no-cache");
//
//		System.out.println(this.mvc.perform(get(URL1).headers(headers)).andDo(print()));
//
//		this.mvc.perform(get(URL1).headers(headers)).andExpect(status().isOk());
//	}

//	@Test
//	public void findClientesByNome() throws Exception {
//
//		String URL2="/api/v1/clientes/search/findByNomeAllIgnoringCase?nome=Joao";
//		
//		System.out.println(this.mvc.perform(get(URL2)).andDo(print()));
//		
//		this.mvc.perform(
//				get(URL2))
//				.andExpect(status().isOk())
//				.andExpect((ResultMatcher) jsonPath("endereco", equals("Barueri")));
//	}

//	@Test
//	public void findClientesByNomeContaining() throws Exception {
//
//		String URL3="/api/v1/clientes/search/findByNomeContainingAllIgnoringCase?nome=dro";
//		
//		System.out.println(this.mvc.perform(get(URL3)).andDo(print()));
//		
//		this.mvc.perform(
//				get(URL3))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("_embedded.clientes", hasSize(2)));
//	}
	
}
