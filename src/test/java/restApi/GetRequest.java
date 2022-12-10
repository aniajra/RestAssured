package restApi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void testGetEmployee() {

		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification request = RestAssured.given();

		Response response = request.get("employees");

		// System.out.println(response.getBody().asString());

		int responseCode = response.getStatusCode();

		Assert.assertEquals(200, responseCode);
		JsonPath jpath = response.jsonPath();
		List<List<String>> allData = jpath.get();
		System.out.println(allData);

	}

}
