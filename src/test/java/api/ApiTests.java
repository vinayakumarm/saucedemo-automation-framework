package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {
	
	@Test
	public void listUsers() {
		baseURI = "https://reqres.in/api";
		
		get("/users?page=2").
		then()
		     .statusCode(200)
		     .body("data[2].id", equalTo(9));
}

	@Test
	public void singleUser() {
		baseURI = "https://reqres.in/api";
		
		get("/users/2").
		 then().
		  statusCode(200).
		  log().
		  all();
	}
	
	@Test
	public void userNotFound() {
		baseURI = "https://reqres.in/api";
		
		get("/users/23").then().statusCode(404).log().all();
		}
	
	
	@Test
	public void testPost() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "Spiderman");
		obj.put("role", "Avenger");
		
		baseURI = "https://reqres.in/api";
		
		given().
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(obj.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).
		 body("name", equalTo("Spiderman")).
		 log().
		 all();
	}
}
