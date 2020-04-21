package com.hackerrank.petstore;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PetServices {
	String OUTPUT;
	public String FindPetByID(String ID){
		try {
			String API_URL = "https://petstore.swagger.io/v2/pet/"+ID;
			Client client = Client.create();

			WebResource webResource = client
					.resource(API_URL);
			ClientResponse clientResponse = webResource.accept("application/json")
					.get(ClientResponse.class);
			if (clientResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ clientResponse.getStatus());
			}
			 OUTPUT = clientResponse.getEntity(String.class);
			 JSONObject jsonObj = new JSONObject(OUTPUT);
			        
			System.out.println("Output from Server For FindPetByID service.... \n"+jsonObj);
			System.out.println(OUTPUT + "\n");
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OUTPUT;
	}
	public String FindPetByStatus(String Status){
		try {
			String API_URL = "https://petstore.swagger.io/v2/pet/findByStatus?status="+Status;
			Client client = Client.create();

			WebResource webResource = client
					.resource(API_URL);
			ClientResponse clientResponse = webResource.accept("application/json")
					.get(ClientResponse.class);
			if (clientResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ clientResponse.getStatus());
			}
			 OUTPUT = clientResponse.getEntity(String.class);
			 JSONArray jsonArray = new JSONArray(OUTPUT);
			        
			System.out.println("Output from Server .... \n"+jsonArray);
			System.out.println(OUTPUT + "\n");
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OUTPUT;
	}
	public String AddNewPet(String Input){
		try {
			String API_URL = "https://petstore.swagger.io/v2/pet";
			Client client = Client.create();
			
			WebResource webResource = client
					.resource(API_URL);
			
			ClientResponse clientResponse = webResource.type("application/json")
					.post(ClientResponse.class,Input);			
			if (clientResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ clientResponse.getStatus());
			}
			 OUTPUT = clientResponse.getEntity(String.class);
			 JSONObject jsonObj = new JSONObject(OUTPUT);
			        
			System.out.println("Output from server for AddNewPet service  .... \n"+jsonObj);
			System.out.println(OUTPUT + "\n");
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OUTPUT;
	}
	public String UpdatePetByID(String ID,String name,String status){
		try {
			String API_URL = "https://petstore.swagger.io/v2/pet/"+ID;
			Client client = Client.create();
			
			WebResource webResource = client
					.resource(API_URL);
			
			String urlParameters  = "name="+name+"&status="+status;
			
			ClientResponse clientResponse = webResource.type("application/x-www-form-urlencoded")
					.post(ClientResponse.class,urlParameters);			
			if (clientResponse.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ clientResponse.getStatus());
			}
			 OUTPUT = clientResponse.getEntity(String.class);
			 JSONObject jsonObj = new JSONObject(OUTPUT);
			        
			System.out.println("Output from server for UpdatePetByID .... \n"+jsonObj);
			System.out.println(OUTPUT + "\n");
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OUTPUT;
	}
}
