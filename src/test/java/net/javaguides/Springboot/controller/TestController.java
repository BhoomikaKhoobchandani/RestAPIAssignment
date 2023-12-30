package net.javaguides.Springboot.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.Springboot.model.Lead;
import net.javaguides.Springboot.service.LeadService;
import net.javaguides.Springboot.utils.ResponseHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LeadController.class)
public class TestController {


    @MockBean
    LeadService leadService1;

    @MockBean
    ResponseHandler responseHandler;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_saveLeads() throws Exception
    {
        Lead lead= new Lead(1234,"Sushma","kumari","jain","k@outlook.com","909087700","male","21/05/200");
        when(leadService1.createLead(lead)).thenReturn("lead_created");
        mockMvc.perform(post("/api/createLead")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(lead)))
                .andExpect(status().isOk());
    }

    @Test
    public void test_getLeadsbyMobileNumber() throws Exception {
        List<Lead> leadList= Arrays.asList(new Lead(1234,"Sushma","kumari","jain","k@outlook.com","909087700","male","21/05/1991"),new Lead(123467,"Sushma","kumari","jain","k@outlook.com","909087700","male","05,10,1991"));
        when(leadService1.findbyMobileNumber("90908770000")).thenReturn(leadList);

        mockMvc.perform(get("/api/fetchMobileNumber?mobileNumber=90908770000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                ;
    }
}
