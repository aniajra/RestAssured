package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {

	@Test
	public void test1() {

		RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("employees")
		.then()
		.log()
		.all()
		.statusCode(200);

	}

	@Test
	public void test2() {

		RestAssured.given()
		.baseUri("http://localhost:3000")
		.when()
		.get("employees/1")
		.then().log().all()
				.statusCode(200).body("name", Matchers.equalTo("Pankaj"));

	}

	@Test
	public void test3() {

		RestAssured.given()
		.baseUri("http://localhost:3000")
		.when().get("employees")
		.then()
		.log()
		.all()
		.statusCode(200)
		.body("[1].name", Matchers.equalTo("Harsha"));
	}

}
