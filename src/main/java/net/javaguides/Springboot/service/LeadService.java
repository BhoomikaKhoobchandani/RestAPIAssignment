package net.javaguides.Springboot.service;

import net.javaguides.Springboot.exception.ResourceNotFoundException;
import net.javaguides.Springboot.model.Lead;
import net.javaguides.Springboot.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.javaguides.Springboot.utils.Constants.lead_already_present;
import static net.javaguides.Springboot.utils.Constants.lead_created;


@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    @GetMapping
    public List<Lead> getAllLeads(){
        return leadRepository.findAll();
    }
    //post method
    @PostMapping
    public String createLead(@RequestBody Lead lead){
        Lead storedId = leadRepository.findbyLeadId(lead.getLeadId());
        if(storedId!=null)
        {
            return lead_already_present;
        }
        else {
            leadRepository.save(lead);
            return lead_created;
        }

    }

    @GetMapping("{mobileNumber}")
    public List<Lead> findbyMobileNumber(@RequestParam String mobileNumber){
        return leadRepository.findbyMobileNumber(mobileNumber);

    }
}
