package TrelloApi;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class TrelloApiPage {
	
    //create board
    public String createBoard(String boardName) {
        String boardJSON = "{\n" +
                "  \"key\": \"b819a69d5dfb11e5d022052fc9e9c1eb\",\n" +
                "  \"token\": \"1f392a14afe4f15b25e78d5233faa01d81be586fa5a6d940863ed65f88c07010\",\n" +
                "  \"name\": \"{boardName}\"\n" +
                "}";
        
    	Response response = 
                given()
                .contentType(ContentType.JSON)
                .body(boardJSON)
                .post("/1/boards/")
                .then()
                .statusCode(200)
                .extract().response();
                
 	String id = response.path("id");  
 	return id;  	
    }
    
    //create card
    public String createCard(String name,String id) {
    	Response response =
    	 given()
        .header("Content-Type", "application/json")
    	.param("key", "b819a69d5dfb11e5d022052fc9e9c1eb")
    	.param("token", "1f392a14afe4f15b25e78d5233faa01d81be586fa5a6d940863ed65f88c07010")
    	.param("idList", id)
    	.param("name", name)
        .post("/1/cards/")
        .then()
        .statusCode(200)
        .extract().response();
    	 
    	 String idCard = response.path("id");
    	 return idCard;
    }
    
    //update card
	public void updateCard(String idCard) {
 
		HttpResponse<JsonNode> response = Unirest.put("https://api.trello.com/1/cards/" + idCard)
				.header("Accept", "application/json")
				.queryString("key", "b819a69d5dfb11e5d022052fc9e9c1eb")
				.queryString("token", "1f392a14afe4f15b25e78d5233faa01d81be586fa5a6d940863ed65f88c07010")
				.asJson();

		response.getBody();
	
	}
}
