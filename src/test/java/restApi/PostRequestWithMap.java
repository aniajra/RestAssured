package restApi;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	
	@Test
	public void testCreateEmployee() {

		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("name", "anitha");
		mapObj.put("salary", 7500);
		

		//String bodyText = "{\n" + "    \"name\": \"Nancy\",\n" + "    \"salary\": \"30000\"\n" + "}";

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(mapObj)
				.post("employees/create");

		int responseCode = response.getStatusCode();
		System.out.println(response.getBody().asString());

		Assert.assertEquals(201, responseCode);

	}

}
