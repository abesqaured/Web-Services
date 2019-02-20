package Controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.Item;
import Models.Creation;
import View.View;
import spark.Request;
import spark.Response;
import spark.Route;

public class ItemsController {
	
	private static Item db = new Item();
	private static Creation create;
	@JsonProperty("json")
	
	public static Route getItem = (Request request, Response response) -> {	
		String path = request.pathInfo().toString();
		if(path.equals("/")){
			System.out.println("Getting Items...");
			View.ItemstoJson(db.GetItems(), response);
			
		}else if(!path.equals("/")){
			System.out.println("Getting Users...");
			String split[] = path.split("/");
			int id = Integer.parseInt(split[1]);
			System.out.println("id is: " + split[1]);
			View.ItemtoJson(db.CheckDB(id), response);
		}
		
		//was not able to return view in if statements so had to do this
		return response;
		
	};
    
    public static Route addItem = (Request request, Response response) -> {
		String getJson = request.body();
		ObjectMapper input = new ObjectMapper();
		Item newItem = input.readValue(getJson, Item.class);
    	create = new Creation(newItem);
    	View.ItemstoJson(create.GetItems(), response);
		
    	return response;
        
    };

}
