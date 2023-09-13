package firstDemoTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class first_getrequest {

	public static void main(String[] args) {

		RequestSpecification resqspeci = RestAssured.given();

		resqspeci.baseUri("https://reqres.in");
		resqspeci.pathParam("path", "/api/users/2");

		Response res = resqspeci.when().get("{path}");

		System.out.println("the status code of the api is  " + res.statusCode());

	}
}
