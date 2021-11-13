package com.java.examples.JsonSchemaValidator2;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class customjsonschemavalidator {

	private static InputStream inputStreamFromClasspath(String path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    public static void main(String[] args) throws Exception {
    	
    	customjsonschemavalidator schemadata= new customjsonschemavalidator();
    	
    	schemadata.validationJsonSchema("F:\\SoapUI\\Schema\\example.json", "F:\\SoapUI\\Schema\\example-schema.json");
    }
    
    public Set<ValidationMessage> validationJsonSchema(String jsonfile, String jsonSchema) throws IOException{
    	ObjectMapper objectMapper = new ObjectMapper();
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V201909);

        InputStream jsonStream=null;
        InputStream schemaStream=null;
        Set<ValidationMessage> validationResult;
        try {
               // InputStream jsonStream = inputStreamFromClasspath("example.json");
                //InputStream schemaStream = inputStreamFromClasspath("example-schema.json");
        		jsonStream= new FileInputStream(jsonfile);
        		 schemaStream = new FileInputStream(jsonSchema);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        {
            JsonNode json = objectMapper.readTree(jsonStream);
            JsonSchema schema = schemaFactory.getSchema(schemaStream);
            validationResult = schema.validate(json);

            // print validation errors
            if (validationResult.isEmpty()) {
                System.out.println("no validation errors :-)");
            } else {
                validationResult.forEach(vm -> System.out.println(vm.getMessage()));
            }
        }
		return validationResult;
    	
    }
    }
    
