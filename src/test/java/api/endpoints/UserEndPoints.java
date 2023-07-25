package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


// user endpoints.java 
// created for perform crud operations to the user api

public class UserEndPoints {
	
	public static Response createUser(User Payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Payload)
		.when()
			.post(Routes.post_url);
		
		return res;
	}
	public static Response readUser(String username){
		Response res = given()
			.pathParam("username", username)
		.when()
			.get(Routes.get_url);
		
		return res;
	}
	public static Response UpdateUser(String username,User Payload){
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(Payload)
		.when()
			.put(Routes.update_url);
		
		return res;
	}
	public static Response deleteUser(String username){
		Response res = given()
			.pathParam("username", username)
		.when()
			.delete(Routes.delete_url);
		
		return res;
	}
	
}
