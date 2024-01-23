//package com.spotify.oauth2.Api;
//
//import static com.spotify.oauth2.Api.Route.BASE_PATH;
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.filter.log.LogDetail;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//
//
//
//public class SpecBuilder {
//
// static String access_token = "BQBhEn9BKBVce_ta-iOqQ7RCK1EbwCTu7z2SKagM_cqKHQtyn-HCLRrHgVLFCn4IJTeH9LscpIjsHsyNNqrSz2ESgKlx6Fyl66XawBHoo-WWDQVVIU9O4-De-vWb7UhWrysR4XVtbcGRHoRkxKP2B90dlVKR8W1UNPIsyVRJoTJXza5u4EP9EimCnxtotgTUSElvkn8p6Pjnz8g6vXG2lGEbysVFgOlh9y6vNHWCnOHckvhBS974MXyygc6lpaTC1HFwplB6mKIUkovE";
//
//	  public static String renewToken;
//
//	
//    public static RequestSpecification getRequestSpec() {
//        // Create Request Specification
//        return new RequestSpecBuilder()
//                .setBaseUri("https://api.spotify.com")
//                .setBasePath(BASE_PATH)
//                
//         //   .addHeader("Authorization", "Bearer " + renewToken)
//                 
//              .addHeader("Authorization", "Bearer " + access_token)
//   
//             .setContentType(ContentType.JSON)
//                .log(LogDetail.ALL)
//                .build();
//    }
//
//    public static ResponseSpecification getResponseSpec() {
//        // Create Response Specification
//        return new ResponseSpecBuilder()
//                .build();
//    }
//    
//    
//}



package com.spotify.oauth2.Api;

import static com.spotify.oauth2.Api.Route.BASE_PATH;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://api.spotify.com")
                .setBasePath(BASE_PATH)
                .addHeader("Authorization", "Bearer " + TokenManager.getAccessToken())
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .build();
    }
}
