package Controllers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.Account;
import Models.Creation;
import View.View;
import spark.*;


public class UsersController {
	
	private static Account db = new Account();
	private static Creation create;
	@JsonProperty("json")
	
	public static Route getUser = (Request request, Response response) -> {	
		String path = request.pathInfo().toString();
		if(path.equals("/")){
			System.out.println("Getting Users...");
			View.AccountstoJson(db.GetUsers(), response);
			
		}else if(!path.equals("/")){
			String split[] = path.split("/");
			int id = Integer.parseInt(split[1]);
			System.out.println("id is: " + split[1]);
			View.AccounttoJson(db.CheckDB(id), response);
		}
		
		//was not able to return view in if statements so had to do this
		return response;
		
	};
    
    public static Route addUser = (Request request, Response response) -> {
		String getJson = request.body();
		ObjectMapper input = new ObjectMapper();
		Account newAccount = input.readValue(getJson, Account.class);
    	create = new Creation(newAccount);
    	System.out.println("Getting Users...");
    	View.AccountstoJson(create.GetUsers(), response);
		return response;
        
    };

}
