package restApi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class GetRequestWithParam {

	private RequestSpecification request;

	@BeforeTest
	public void setUp() {

		RestAssured.baseURI = "http://localhost:3000";
		request = RestAssured.given();
		request.param("id", 1);
	}

	@Test

	public void assertStatusCode() {

		Response response = request.get("employees");

		// String responseBody = response.getBody().asString();

		int responseCode = response.getStatusCode();

		Assert.assertEquals(200, responseCode);

		// System.out.println(response.headers().toString());
		// System.out.println(responseBody);

	}

	@Test

	public void shouldContainValidName() {

		Response response = request.get("employees");

		String responseBody = response.getBody().asString();

		Assert.assertTrue(responseBody.contains("Pankaj"));

		// Getting Via Json Path
		JsonPath jpath = response.jsonPath();

		List<String> names = jpath.get("name");

		System.out.println("Name of Employee to Test : " + names.get(0));

		Assert.assertEquals(names.get(0), "Pankaj");

	}

	@Test
	public void testToVerifyURI() {

		String uri = "http://localhost:3000/employees?id=1";
		
		RequestSpecification requestSpec = request.baseUri("http://localhost:3000").basePath("/employees");

		Response response = requestSpec.get();
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(requestSpec);

		// System.out.println(response.getBody().asString());
		// String retrieveURI = queryRequest.getBaseUri();
		// System.out.println("Base URI is : " + retrieveURI);
		String retrievePath = queryRequest.getURI();
		System.out.println("Base PATH is : " + retrievePath);

		Assert.assertEquals(uri, retrievePath);
	}

}
