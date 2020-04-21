package com.hackerrank.petstore;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPetServices {
	/* This Function is to test find Pet By ID   */
	@Test
	 public void testFindPetByID() {
			PetServices petServices = new PetServices();
			String ID = "1845563262948981189";
			String Result = petServices.FindPetByID(ID);
			assertNotNull(Result);
		}
    /*This Function is to test Find Pet By Status API */
	@Test
	public void testFindPetByStatus() {
		PetServices petServices = new PetServices();
		String status = "available";
		String Result = petServices.FindPetByStatus(status);
		assertNotNull(Result);
	}
	/* This Function is to test Add New Pet to the Store API */
    @Test
	public void testAddNewPet() {
		PetServices petServices = new PetServices();
		String input = "{ \"id\":0,\"category\": {\"id\":123456123,\"name\":\"PETPETPET3\" },\"name\":\"doggie\", "
				+  "\"photoUrls\": [\"string\"],\"tags\":[{\"id\": 0,\"name\":\"string\"}],\"status\":\"available\"}";;
		String Result = petServices.AddNewPet(input);
		assertNotNull(Result);
	}
    /* This Function is to test update Pet By ID  */
    @Test
	public void testUpdatePetByID() {
			PetServices petServices = new PetServices();
			String ID = "1845563262948981189";
			String name = "NEWPET",status = "pending";
			String Result = petServices.UpdatePetByID(ID,name,status);
			assertNotNull(Result);
		}
}
