package net.javaguides.Springboot.service;

import net.javaguides.Springboot.model.Lead;
import net.javaguides.Springboot.repository.LeadRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest

public class TestService {
    @MockBean
    LeadRepository leadRepository;

    @Autowired
    LeadService leadService1;;


    @Test
    public void test_createLead(){
        Lead lead= new Lead(1234,"Sushma","kumari","jain","k@outlook.com","909087700","male","31/10/2003");
        when(leadRepository.save(lead)).thenReturn(lead);
        assertEquals("lead created successfully", leadService1.createLead(lead));
    }

    @Test
    public void test_getLeadsbyMobile(){
        List<Lead> leadList= Arrays.asList(new Lead(1234,"Sushma","kumari","jain","k@outlook.com","909087700","male","21/05/1991"),new Lead(123467,"Sushma","kumari","jain","k@outlook.com","909087700","male","05,10,1991"));
        when(leadRepository.findbyMobileNumber("909087700")).thenReturn(leadList);
        assertEquals(leadList,leadService1.findbyMobileNumber("909087700"));

    }


}

