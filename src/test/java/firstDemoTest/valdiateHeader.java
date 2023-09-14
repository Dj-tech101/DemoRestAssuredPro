package firstDemoTest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class valdiateHeader {
	@Test

	public void validateHeader() {

		RequestSpecification resspeci = RestAssured.given();

		resspeci.baseUri("https://reqres.in");
		resspeci.basePath("/api/unknown");

		Response res = resspeci.when().get();

		System.out.println(res.statusCode());

		String statusLine = res.statusLine();
		
		System.out.println(statusLine);

		if (statusLine.contains("OK")) {

			Assert.assertTrue(true);

		}
		else {
			assertTrue(false);

		}
	}
}