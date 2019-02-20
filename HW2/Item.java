package HW2;

import java.util.HashMap;
import java.util.Map;

public class Item {
	private String name;
	private float price;
	private Map<String,String> items; 
	
	public Item(String n, float p){
		name = n;
		price = p;
		items = new HashMap<>();
		startList();
	}
	
	public String getName(){
		return name;
	}
	
	public float getPrice(){
		return price;
	}
	
	private void startList(){
		items.put("Nachos", "3");
		items.put("Taco","2");
		items.put("Pizza", "10");
		items.put("Fries", "1");
	}
	public void checkDB(Item i){
		String check = i.getName();
		float checkPrice = i.getPrice();
		if(Float.parseFloat(items.get(check)) == checkPrice){
			
		}
	}
}
