package com.spotify.oauth2;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import com.spotify.oauth.pojo.PlayList;
import com.spotify.oauth2.Api.SpecBuilder;
import static io.restassured.RestAssured.given;
import static com.spotify.oauth2.Api.Route.PLAYLISTS;

public class AutomateUpdatePlayListAPI {
 @Test
 public void updatePlaylist() {
		
     PlayList requestPlaylist = new PlayList()
     		
     .setName("Updated Playlist Name")
     .setDescription("Updated playlist description")
     .setPublic(false);
     
     given(getRequestSpec())
	          .body(requestPlaylist)
             .when()
             .put(PLAYLISTS+ "/1n1Hfom46pTHZTgfyMSUjn")
             .then()
             .spec(getResponseSpec())
             .assertThat()
             .statusCode(200);             
 }

 private ResponseSpecification getResponseSpec() {
		// TODO Auto-generated method stub
		return SpecBuilder.getResponseSpec();
	}


	private RequestSpecification getRequestSpec() {
		// TODO Auto-generated method stub
		return SpecBuilder.getRequestSpec();
	}
	
}
