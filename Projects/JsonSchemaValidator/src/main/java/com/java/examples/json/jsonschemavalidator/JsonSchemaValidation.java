package com.java.examples.json.jsonschemavalidator;

import java.io.FileInputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonSchemaValidation {
	
	
	
	public boolean validateJsonDocument(String definition, String payload) throws ValidationException {
		boolean result=true;
		try {
			JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(definition)));
			System.out.println("jsonSchema->"+jsonSchema);
		    JSONObject jsonData = new JSONObject(new JSONTokener(new FileInputStream(payload)));
		    System.out.println("jsonData->"+jsonData);
		    Schema schema = SchemaLoader.load(jsonSchema);
		    schema.validate(jsonData);
		    return result;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	 	
	}


	public static void main(String[] args) {
		String payload="{\r\n"
				+ "    \"name\": \"Kris Fletcher \",\r\n"
				+ "    \"gender\": \"male\",\r\n"
				+ "    \"age\": 30,\r\n"
				+ "    \"joiningDate\": \"2017-11-13\",\r\n"
				//+ "    \"emailId\": \"kris@gmail.com\",\r\n"
				+ "    \"contactNumber\": \"(410)804-4694\",\r\n"
				+ "    \"creditCardNumber\": 9876543210987654,\r\n"
				+ "    \"billingAddress\": {\r\n"
				+ "         \"streetAddress1\": \"394\",\r\n"
				+ "         \"type\": \"office\"\r\n"
				+ "   }\r\n"
				+ "}";
		String definition="{\r\n"
				+ "    \"$schema\": \"http://json-schema.org/draft-07/schema\",\r\n"
				+ "    \"definitions\": {\r\n"
				+ "        \"address\": {\r\n"
				+ "            \"type\": \"object\",\r\n"
				+ "            \"properties\": {\"streetAddress1\": {\"type\": \"string\"}},\r\n"
				+ "           \"required\": [\"streetAddress1\"]\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "},\r\n"
				+ "\"type\": \"object\",\r\n"
				+ "\"properties\": {\r\n"
				+ "	\"name\": {\"type\": \"string\", \"minLength\": 4, \"maxLength\": 64},\r\n"
				+ "    \"gender\": {\"type\": \"string\", \"enum\": [\"male\",\"female\"]},\r\n"
				+ "    \"age\": {\"type\": \"integer\", \"minimum\": 18, \"exclusiveMaximum\": 100},\r\n"
				+ "    \"joiningDate\": {\"type\": \"string\",\"format\": \"date\"},\r\n"
				+ "    \"emailId\": {\r\n"
				+ "                  \"type\": \"string\",\r\n"
				+ "                      \"pattern\": \"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\"\r\n"
				+ "                },\r\n"
				+ "    \"contactNumber\": { \r\n"
				+ "    					\"type\": \"string\",\r\n"
				+ "                        \"pattern\": \"^(\\\\([0-9]{3}\\\\))?[0-9]{3}-[0-9]{4}$\"\r\n"
				+ "                      },\r\n"
				+ "    \"creditCardNumber\": {\"type\": \"integer\"},\r\n"
				+ "    \"billingAddress\": {\r\n"
				+ "   				   \"allOf\": [\r\n"
				+ "                        		{\"$ref\": \"#/definitions/address\"},\r\n"
				+ "                                {\r\n"
				+ "                                   \"properties\": {\"type\": {\"enum\": [\"residential\", \"office\"]}},\r\n"
				+ "                                   \"required\": [\"type\"]\r\n"
				+ "                                }\r\n"
				+ "                   ]\r\n"
				+ "     },\r\n"
				+ "    \"dependencies\": {\r\n"
				+ " 				\"creditCardNumber\": [\"billingAddress\"]\r\n"
				+ "     },\r\n"
				+ "     \"additionalProperties\": false,\r\n"
				+ "     \"required\": [\"name\", \"emailId\"]\r\n"
				+ "} ";
		JsonSchemaValidation data= new JsonSchemaValidation();
		boolean ret=data.validateJsonDocument("F:\\SoapUI\\Schema\\contact.json", "F:\\SoapUI\\Schema\\contactPayload.json");
		System.out.println(ret);
	}
}
