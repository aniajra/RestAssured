package restApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test

	public void testCreateEmployee() {

		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification request = RestAssured.given();

		String bodyText = "{\n" + "    \"name\": \"Nancy\",\n" + "    \"salary\": \"30000\"\n" + "}";

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(bodyText)
				.post("employees/create");

		int responseCode = response.getStatusCode();
		System.out.println(response.getBody().asString());

		Assert.assertEquals(201, responseCode);

	}

}
