package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void test1() {
		
	Map<String,Object> MapObj = new HashMap<String,Object>();
		
		MapObj.put("name", "Andri");
		MapObj.put("salary", "7500");
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.when()
					.post("employees/create")
					.then()
					.log()
					.all()
					.statusCode(201)
					.body("name", Matchers.equalTo("Andri"));
			
		
	}

}
