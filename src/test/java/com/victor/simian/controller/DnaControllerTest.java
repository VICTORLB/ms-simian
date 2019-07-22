package com.victor.simian.controller;

import com.victor.simian.constants.SimianConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DnaControllerTest {


    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getList() throws Exception{

        String URL= SimianConstants.URL_LIST;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cache-Control", "no-cache");

        System.out.println(this.mvc.perform(get(URL).headers(headers)).andDo(print()));

        this.mvc.perform(get(URL).headers(headers)).andExpect(status().isOk());
    }

    @Test
    public void getStats() throws Exception{
        String URL= SimianConstants.URL_STATS;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cache-Control", "no-cache");

        System.out.println(this.mvc.perform(get(URL).headers(headers)).andDo(print()));

        this.mvc.perform(get(URL).headers(headers)).andExpect(status().isOk());
    }

}