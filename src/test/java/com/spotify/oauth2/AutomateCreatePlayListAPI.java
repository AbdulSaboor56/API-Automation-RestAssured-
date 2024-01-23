package com.spotify.oauth2;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import com.spotify.oauth.pojo.PlayList;
import com.spotify.oauth2.Api.SpecBuilder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static com.spotify.oauth2.Api.Route.USERS;
import static com.spotify.oauth2.Api.Route.PLAYLISTS;


public class AutomateCreatePlayListAPI {

   	@Test
    public void shouldBeAbleToCreatePlaylist() {
        PlayList requestPlaylist = new PlayList()
                .setName("Updated Playlist Name")
                .setDescription("Updated playlist description")
                .setPublic(false);

        PlayList responsePlaylist = given(getRequestSpec())
                .body(requestPlaylist)
                .log().all()
                .when()
                .post( USERS +"/312czbr7q2xd5sapdcrnsblixigi" + PLAYLISTS)
                .then()
                .spec(getResponseSpec())
                .assertThat()
                .statusCode(201)
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
	
	private void assertThat(Boolean public1, org.hamcrest.Matcher<Boolean> equalTo) {
        // TODO: Implement assertion logic
    }

    private void assertThat(String name, org.hamcrest.Matcher<String> equalTo) {
        // TODO: Implement assertion logic
    }
}
