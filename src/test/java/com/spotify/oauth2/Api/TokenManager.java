//package com.spotify.oauth2.Api;
//
//import java.util.HashMap;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.ResponseSpecification;
//
//import static io.restassured.RestAssured.given;
//
//
//import static com.spotify.oauth2.Api.Route.API;
//import static com.spotify.oauth2.Api.Route.TOKEN;
//
//
//public class TokenManager {
//
//	public static String renewToken() {
//		
//		HashMap<String,String> formParams = new HashMap<String,String>();
//		
//		formParams.put("client_id", "d8d853f86bf44d43b74c26dbf54eb143");
//		formParams.put("client_secret", "20ff2be7b70346538da20746018adb3d");
//		formParams.put("refresh_token", "AQARS46ZSul7PFl2WqssH7FwRJMJCP9QXCPNpkFxFy6NwdkNBm6UGzgg4hiF0ZN9Hv3bpHOIwGrjzgUiRqQNn7ovCTH93QXhZWWbDoOHT_ooeZ9aljTM0toJzBzLkVQJiBI");
//		formParams.put("grant_type", "refresh_token");
//		
//		Response response = given()
//			.baseUri("https://accounts.spotify.com")
//			.contentType(ContentType.URLENC)
//			.formParams(formParams)
//			.when().post(API+TOKEN)
//			.then().spec(getResponseSpec())
//			.extract()
//			.response();
//
//	if(response.statusCode()!=200) {
//		throw new RuntimeException("Abort!!! Renew Token Failed");
//	}
//	return response.path("access_token");
//	
//}	
//	private static ResponseSpecification getResponseSpec() {
//		// TODO Auto-generated method stub
//		return SpecBuilder.getResponseSpec();
//	}
//}




package com.spotify.oauth2.Api;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import static com.spotify.oauth2.Api.Route.API;
import static com.spotify.oauth2.Api.Route.TOKEN;

public class TokenManager {

    private static String accessToken; // Store the access token

    public static String getAccessToken() {
        if (accessToken == null || isTokenExpired()) {
            renewToken();
        }
        return accessToken;
    }

    private static boolean isTokenExpired() {
        // Implement logic to check if the token is expired
      
        return false; 
    }

    private static void renewToken() {
        HashMap<String, String> formParams = new HashMap<String, String>();

        formParams.put("client_id", "d8d853f86bf44d43b74c26dbf54eb143");
        formParams.put("client_secret", "20ff2be7b70346538da20746018adb3d");
        formParams.put("refresh_token", "AQARS46ZSul7PFl2WqssH7FwRJMJCP9QXCPNpkFxFy6NwdkNBm6UGzgg4hiF0ZN9Hv3bpHOIwGrjzgUiRqQNn7ovCTH93QXhZWWbDoOHT_ooeZ9aljTM0toJzBzLkVQJiBI");
        formParams.put("grant_type", "refresh_token");

        Response response = given()
                .baseUri("https://accounts.spotify.com")
                .contentType(ContentType.URLENC)
                .formParams(formParams)
                .when().post(API + TOKEN)
                .then().spec(getResponseSpec())
                .extract()
                .response();

        if (response.statusCode() != 200) {
            throw new RuntimeException("Abort!!! Renew Token Failed");
        }

        accessToken = response.path("access_token");
    }

    private static ResponseSpecification getResponseSpec() {
        return SpecBuilder.getResponseSpec();
    }
}
