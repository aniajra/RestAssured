package restApi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {

	@Test
	public void testCreateEmployee() throws IOException {

		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification request = RestAssured.given();

		//byte[] datafile = Files.readAllBytes(Paths.get("data.json"));

		File datafile = new File("data.json");
		// String bodyText = "{\n" + " \"name\": \"Nancy\",\n" + " \"salary\":
		// \"30000\"\n" + "}";

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datafile)
				.post("employees/create");

		int responseCode = response.getStatusCode();
		System.out.println(response.getBody().asString());

		Assert.assertEquals(201, responseCode);

	}

}
