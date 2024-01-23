package com.spotify.oauth2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import com.spotify.oauth.pojo.PlayList;
import com.spotify.oauth2.Api.SpecBuilder;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static com.spotify.oauth2.Api.Route.PLAYLISTS;


public class AutomateGetPlayListAPI {

 @Test
 public void shouldBeAbleToGPlaylist() {
		
     PlayList requestPlaylist = new PlayList()
     		
     .setName("Updated Playlist Name")
     .setDescription("Updated playlist description")
     .setPublic(false);
     
	 
	 PlayList responsePlaylist = given(getRequestSpec())
             .when()
             .get(PLAYLISTS+ "/1n1Hfom46pTHZTgfyMSUjn")
             .then()
             .spec(getResponseSpec())
             .assertThat()
             .statusCode(200)
             .extract()
             .response()
             .as(PlayList.class);
             
             
             assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
     assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
     assertThat(responsePlaylist.getPublic(), equalTo(requestPlaylist.getPublic()));
     
     
 }
 private ResponseSpecification getResponseSpec() {
		// TODO Auto-generated method stub
		return SpecBuilder.getResponseSpec();
	}


	private RequestSpecification getRequestSpec() {
		// TODO Auto-generated method stub
		return SpecBuilder.getRequestSpec();
	}

private void assertThat(String name, Matcher<String> equalTo) {
	// TODO Auto-generated method stub
	
}
private void assertThat(Boolean boolean1, Matcher<Boolean> matcher) {
	// TODO Auto-generated method stub
	
}
}
