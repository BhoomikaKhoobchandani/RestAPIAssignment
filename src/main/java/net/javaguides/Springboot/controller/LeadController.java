package net.javaguides.Springboot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.javaguides.Springboot.model.Lead;
import net.javaguides.Springboot.service.LeadService;
import net.javaguides.Springboot.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.javaguides.Springboot.utils.Constants.lead_created;

@RestController
@RequestMapping("/api")
public class LeadController {
    @Autowired
    private LeadService LeadService;

    @Autowired
    ResponseHandler responseHandler;

    @GetMapping("/getLeads")
    public List<Lead> getAllLeads(){
        return LeadService.getAllLeads();
    }

    @PostMapping("/createLead")
    public ResponseEntity<JsonNode> createLead(@RequestBody Lead lead){
        String e= LeadService.createLead(lead);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode=mapper.createObjectNode();
        if(e.equals(lead_created))
        {
            responseNode.put("status","success");
            responseNode.put("data","Created Leads Successfully");
            return new ResponseEntity<JsonNode>(responseNode,HttpStatus.CREATED);
        }
        JsonNode errorResponseNode= responseHandler.createErrorResponseForLeadPresent();
        return new ResponseEntity<JsonNode>(errorResponseNode,HttpStatus.OK);


    }

    @GetMapping("/fetchMobileNumber")
    public ResponseEntity<JsonNode> findbyMobileNumber(@RequestParam("mobileNumber") String mobileNumber){
        List<Lead> leadList=LeadService.findbyMobileNumber(mobileNumber);
        if(leadList.isEmpty())
        {
            JsonNode errorResponseNode= responseHandler.createErrorResponseForLeadNotPresent();
            return new ResponseEntity<JsonNode>(errorResponseNode,HttpStatus.OK);
        }
        JsonNode successResponseNode= responseHandler.createSucessResponseForLead(leadList);
        return new ResponseEntity<JsonNode>(successResponseNode,HttpStatus.OK);
    }
}
