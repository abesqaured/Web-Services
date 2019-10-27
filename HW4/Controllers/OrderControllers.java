package Controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.*;
import View.View;
import spark.Request;
import spark.Response;
import spark.Route;

public class OrderControllers {

	private static Order order;
	private static Creation create;
	@JsonProperty("json")

	
	public static Route getSavedOrder = (Request request, Response response) -> {	

		//displays requested user	
		String split[] = request.pathInfo().toString().split("/");
		System.out.println("id is: " + split[1]);
		int id = Integer.parseInt(split[1]);
		System.out.println("Looking for: " + id);
		order = new Order(id);
		
		View.ItemstoJson(order.GetList(), response);
		return response;
		
	};
    
    public static Route addItem = (Request request, Response response) -> {
    	//displays requested user
    	System.out.println("Path is: " + request.pathInfo().toString());
    			
    	String split[] = request.pathInfo().toString().split("/");
    	System.out.println("id is: " + split[1]);
    	int id = Integer.parseInt(split[1]);
    			
    	String getJson = request.body();
    	ObjectMapper input = new ObjectMapper();
    	Item newItem = input.readValue(getJson, Item.class);
    	order.addSavedItem(id, newItem);
    	System.out.println("New Item added to order is: " + newItem.GetName() + ", " + newItem.GetPrice());
    	
    	View.ItemstoJson(create.GetItems(), response);
    	return response;
        
    };

}
