package com.spotify.oauth2;

import static com.spotify.oauth2.Api.Route.PLAYLISTS;
import static com.spotify.oauth2.Api.Route.USERS;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import com.spotify.oauth.pojo.Error;
import com.spotify.oauth.pojo.PlayList;
import com.spotify.oauth2.Api.SpecBuilder;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NegativeTestCaseForNotCreatingList {

 @Test
 public void shouldNotAbleToCreatePlaylist() {
		
     PlayList requestPlaylist = new PlayList()
     		
     .setName("")
     .setDescription("Updated playlist description")
     .setPublic(false);
     
     Error error = given(getRequestSpec())
     .body(requestPlaylist)
             .when()
             .post(USERS+ "/312czbr7q2xd5sapdcrnsblixigi"+ PLAYLISTS)
             .then()
             .spec(getResponseSpec())
             .assertThat()
             .statusCode(400)
             .extract()
             .as(Error.class);
     
     assertThat(error.getError().getStatus(), equalTo(400));
     assertThat(error.getError().getMessage(), equalTo("Missing required field: name"));
     
 }

 private ResponseSpecification getResponseSpec() {
		// TODO Auto-generated method stub
		return SpecBuilder.getResponseSpec();
	}


	private RequestSpecification getRequestSpec() {
		// TODO Auto-generated method stub
		return SpecBuilder.getRequestSpec();
	}
	

private void assertThat(String message, Matcher<String> equalTo) {
	// TODO Auto-generated method stub
	
}
private void assertThat(Integer status, Matcher<Integer> equalTo) {
	// TODO Auto-generated method stub
	
}
}
