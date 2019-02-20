
import static spark.Spark.*;

import Controllers.ItemsController;
import Controllers.OrderControllers;
import Controllers.UsersController;

public class Main {

	public static void main(String[] args) {
		//rest for users
		get("/private/users/*", (req, res) -> UsersController.getUser);
		
		post("/private/users/*", (req, res) -> UsersController.addUser);
		
		//rest for items
		get("/private/items/*", (req, res) -> ItemsController.getItem);
		
		post("/private/items/*", (req, res) -> ItemsController.addItem);
		
		//rest for savedorders of users
		get("/savedorders/*", (req, res) -> OrderControllers.getSavedOrder);
		
		post("/savedorders/*", (req, res) -> OrderControllers.addItem);
	}

}
