package Models;

import java.util.ArrayList;

public class Creation {
	private Database db;
	
	//This class sole purpose is to create new accounts and items.
	public Creation(Account a){
		db  = new Database();
		db.addAccount(a);
	}
	
	public Creation(Item t){
		db = new Database();
		db.addItem(t);
	}
	
	public ArrayList<Item> GetItems(){
		return db.getItems();
	}
	
	
	public  ArrayList<Account> GetUsers(){
		return db.getUsers();
		
	}
	
	
}
