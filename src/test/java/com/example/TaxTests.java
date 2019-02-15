package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaxTests {


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }



    @Test
    public void testTax() throws Exception {

    	mockMvc.perform(
        	get("/taxes/") 
        	.content("{\"code\":\"JJJ\",\"price\":99.00,\"quantity\":2}")
        	.contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
   		.andExpect(jsonPath("$.tax").value("19.8")        		
   		);

    }

    @Test
    public void testTaxFree() throws Exception {

    	// This item is tax free:
    	mockMvc.perform(
        	get("/taxes/") 
        	.content("{\"code\":\"EEE\",\"price\":99.00,\"quantity\":2}")
        	.contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
   		.andExpect(jsonPath("$.tax").value("0")        		
   		);

    }


}
