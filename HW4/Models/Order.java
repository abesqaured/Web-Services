package Models;


import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	private Database db;
	
	@JsonProperty("items")
	private ArrayList<Item> items;
	
	@JsonProperty("total")
	private float total;
	
	private float pretax;
	private final float tax =  (float) .08;
	
	public Order(){
		db = new Database();
		items = new ArrayList<Item>();
		pretax = 0;
		total = 0;
	}
	
	public void addItem(Item t){
		items.add(t);
		pretax = pretax + t.GetPrice();
		float getTax = pretax * tax;
		total = pretax + getTax;

	}

	
	public Order(int id){
		db = new Database();
		items = this.GetSavedOrder(id);
		pretax = 0;
		total = 0;
	}
	
	public void addSavedItem(int id, Item t){
		items.add(t);
		pretax = pretax + t.GetPrice();
		float getTax = pretax * tax;
		total = pretax + getTax;
		db.AddToSaveOrder(id, t);
	}
	
	public float GetTotal(){
		return total;
	}
	
	
	public ArrayList<Item> GetList(){
		if(items.isEmpty()){
			 ArrayList<Item> empty = new ArrayList<Item>();
			 empty.add(new Item("none",(float)0));
			 return empty;
		}else{
			return items;
		}
		
		
	}
	
	public void SetList(ArrayList<Item> t){
		items = t;
	}
	
	public ArrayList<Item> GetSavedOrder(int id){
		
		return db.SavedOrder(id);
	}
	
}
