package View;


import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import Models.Account;
import Models.Item;
import spark.Response;

public class View {

	@JsonProperty("json")
	
	public static void AccountstoJson(ArrayList<Account> users, Response response) throws JsonProcessingException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(users);
		response.status(200);
        response.type("application/json");
        response.body(json);

	}
	
	public static void ItemstoJson(ArrayList<Item> items, Response response) throws JsonProcessingException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(items);
		response.status(200);
        response.type("application/json");
        response.body(json);

	}
	

	public static void AccounttoJson(Account user, Response response) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(user);
		response.status(200);
        response.type("application/json");
        response.body(json);
		
	}
	
	public static void ItemtoJson(Item item, Response response) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(item);
		response.status(200);
        response.type("application/json");
        response.body(json);
		
	}
}
