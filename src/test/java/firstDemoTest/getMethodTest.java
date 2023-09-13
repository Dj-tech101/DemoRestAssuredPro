package firstDemoTest;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getMethodTest {

	@Test
	public void getMethodTest() {
			
		RequestSpecification specify=RestAssured.given();
		specify.baseUri("https://reqres.in");
		specify.queryParam("page", 2);
		specify.pathParam("usermodule", "users");
		
		
		
		
		Response res=specify.when().get("/api/{usermodule}");
		
	
		//RestAssured.baseURI="https://reqres.in";
		
		//io.restassured.response.Response res=RestAssured.get("/api/users?page=2");
		
		System.out.println(res.statusCode());
		
	}
}
