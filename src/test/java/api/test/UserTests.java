package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	
	Faker faker;
	User userPayload;
	
	public Logger logger;    // for logs
	@BeforeClass
	public void setup() {
		// TODO Auto-generated method stub
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
		
		logger.debug("debugging ...........");
		
	}
	@Test(priority = 1)
	public void tetsPostUser(){
		
		logger.info("******** Creating user **********");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("******** Reading user **********");
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),404);
		
		logger.info("******** user info displayed **********");
		
	}
	@Test(priority = 3)
	public void testUpdateUserByName() {
		logger.info("******** updating user **********");
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body().statusCode(404);
		
		Assert.assertEquals(response.getStatusCode(),404);
		
		logger.info("******** user is upfated**********");
		// checking adat aafter update
		Response responseAfeerUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfeerUpdate.getStatusCode(),404);
		
	}
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("******** Deleting user **********");
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 404);
		
		logger.info("******** user deleted**********");
	}
}
