package com.spotify.oauth2;

import static com.spotify.oauth2.Api.Route.USERS;
import static com.spotify.oauth2.Api.Route.PLAYLISTS;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.spotify.oauth.pojo.Error;
import com.spotify.oauth.pojo.PlayList;
import com.spotify.oauth2.Api.SpecBuilder;

import io.restassured.specification.ResponseSpecification;



public class NegativeTestCaseWithWrongToken {

 @Test
 public void shouldBeAbleToCreatePlaylist() {
		
     PlayList requestPlaylist = new PlayList()
     		
     .setName("Updated Playlist Name")
     .setDescription("Updated playlist description")
     .setPublic(false);
     

     Error error = given()
     
     .baseUri("https://api.spotify.com")
     .basePath("/v1")
     .header("Authorization", "Bearer " + "12345")
             .body(requestPlaylist)
             .when()
             .post(USERS+ "/312czbr7q2xd5sapdcrnsblixigi" + PLAYLISTS)
             .then()
             .spec(getResponseSpec())
             .assertThat()
             .statusCode(401)
             .extract()
             .as(Error.class);
 }
     private ResponseSpecification getResponseSpec() {
 		// TODO Auto-generated method stub
 		return SpecBuilder.getResponseSpec();
 	}

 }
