package Models;


import java.util.ArrayList;
import com.fasterxml.jackson.annotation.*;

public class Item {
	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private Float price;	
	private Database db;	
	
	public Item(){
		db = new Database();
	}

	public Item(String n, Float p){
		name = n;
		price = p;
		db = new Database();
	}
	
	public String GetName(){
		return name;
	}
	
	public float GetPrice(){
		return price;
	}
	
	public Item CheckDB(int id){
		
		return db.FindItem(id);
	}
	
	public ArrayList<Item> GetItems(){
		return db.getItems();
	}
	
}
