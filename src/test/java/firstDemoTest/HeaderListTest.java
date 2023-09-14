package firstDemoTest;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class HeaderListTest {
	@Test

	public void headerTEST() {
		
		
		String username="mahesh@sstsoftwareservices.com";
		String password="Admin@123";
		

		
		String  encodededCrendential=Base64.getEncoder().encodeToString((username + ":" +password).getBytes());
		
		
		String accessTocken = "64f5a167fd84313b196bb56b";

		Map<String, Object> headerdata = new HashMap<String, Object>();

		headerdata.put("Accept", "application/json");

		headerdata.put("Accept-Encoding", "gzip, deflate, br");

		headerdata.put("Content-Type", "application/json");
		headerdata.put("Authorization", "Basic" + encodededCrendential);

		RequestSpecification reqSpecification = RestAssured.given().baseUri("https://test.dockproductsordercenter.com")
				.headers(headerdata);

		Response res = reqSpecification.get("/api/retrieve/user?app=order-center");

		Headers headerBox = res.headers();

		// ResponseBody body = res.getBody();
		
		System.out.println(res.body().asString());

		JsonPath js = res.jsonPath();

		List<String> firstname = js.getList("data.first_name");
		List<String> lastname = js.getList("data.last_name");

		List<String> email = js.getList("data.email");
		
		
		//System.out.println("firstname value is   "+firstname);

	}

}
