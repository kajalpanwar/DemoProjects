package com.demo.pet.store.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.pet.store.pages.HeaderConfig;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
	HeaderConfig header = new HeaderConfig();
	
	@BeforeTest
	void intialStep()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
	}
	
	@Test(priority=1)
	void getDemoPetStore()
	{
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.queryParam("status", "available").get("/findByStatus");
		
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();

		System.out.println("Status code for GET request is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(responseBody.contains("available"), true);
	}
	
	@Test(priority=2)
	void addAndUpdateAvailablePet()
	{

		String jsonBody = "{\r\n"
				+ "  \"id\": 13,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 13,\r\n"
				+ "    \"name\": \"newPet\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 13,\r\n"
				+ "      \"name\": \"Doggy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		Response resp = RestAssured.given().contentType(ContentType.JSON)
				.body(jsonBody).post("https://petstore.swagger.io/v2/pet");
		String responseBody = resp.getBody().asString();
		System.out.println("Status code for POST request is "+resp.getStatusCode());
		System.out.println(resp.asString());
		Assert.assertEquals(responseBody.contains("newPet"), true);
		
		String jsonBody1 = "{\r\n"
				+ "  \"id\": 13,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 13,\r\n"
				+ "    \"name\": \"newPet\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 13,\r\n"
				+ "      \"name\": \"Doggy\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"sold\"\r\n"
				+ "}";
		
		resp = RestAssured.given().contentType(ContentType.JSON)
				.body(jsonBody1).put("https://petstore.swagger.io/v2/pet");
		String responseBody1 = resp.getBody().asString();
		System.out.println(resp.asString());
		System.out.println("Status code for PUT request is "+resp.getStatusCode());
		Assert.assertEquals(responseBody1.contains("sold"), true);
		
	
	}
	
	@Test(priority=3)
	void deleteDemoPet()
	{
		int petId=13;
		RequestSpecification request = RestAssured.given();
		request.headers(header.defaultHeaders());
		
		Response response = request.delete("/"+ petId);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code for DELETE request is "+response.getStatusCode());
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
		
	}

}
