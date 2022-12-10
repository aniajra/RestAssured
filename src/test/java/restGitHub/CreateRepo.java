package restGitHub;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepo {
	
	
	@Test
	public void test1() {
		
		File datafile = new File("data_repo.json");
		
		RestAssured.given()
				.auth()
				.oauth2("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")
				.baseUri("https://api.github.com")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(datafile)
				.when()
				.post("user/repos")
				.then()
				.log()
				.all()
				.statusCode(201);
		
	}

}

