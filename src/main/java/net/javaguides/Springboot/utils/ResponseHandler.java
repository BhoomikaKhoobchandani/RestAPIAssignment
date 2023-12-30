package net.javaguides.Springboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.javaguides.Springboot.model.Lead;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static net.javaguides.Springboot.utils.Constants.*;

@Component
public class ResponseHandler {
    public ObjectNode createErrorResponseForLeadPresent()
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode errorResponseNode=mapper.createObjectNode();

        errorResponseNode.put("status","error");
        ObjectNode childErrorResponseNode=mapper.createObjectNode();
        childErrorResponseNode.put("code",lead_already_present_errorcode);
        childErrorResponseNode.putPOJO("message", Arrays.asList(lead_already_present_errormessage));
        errorResponseNode.putPOJO("errorResponse",childErrorResponseNode);
        return errorResponseNode;
    }

    public ObjectNode createErrorResponseForLeadNotPresent()
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode errorResponseNode=mapper.createObjectNode();
        errorResponseNode.put("status","error");
        ObjectNode childErrorResponseNode=mapper.createObjectNode();
        childErrorResponseNode.put("code",no_lead_found_with_mobileNumber_code);
        childErrorResponseNode.putPOJO("message", Arrays.asList(no_lead_found_errormessage));
        errorResponseNode.putPOJO("errorResponse",childErrorResponseNode);
        return errorResponseNode;
    }

    public ObjectNode createSucessResponseForLead(List<Lead> empList)
    {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode successResponseNode=mapper.createObjectNode();
        successResponseNode.put("status","success");
        successResponseNode.putPOJO("data",empList);
        return successResponseNode;
    }
}
