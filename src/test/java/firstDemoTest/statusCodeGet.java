package firstDemoTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class statusCodeGet {
	
	@Test
	public void testStatusCode() {
		
		
		
		Response res=RestAssured.given().get("https://reqres.in/api/users/2");
		
		
		System.out.println("the response code is "+res.statusCode());
	}
	
	

}
