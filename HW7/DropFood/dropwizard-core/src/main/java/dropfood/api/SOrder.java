package dropfood.api;

import java.util.List;

//import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SOrder {

	private long id;
	

	private String username;
	
	private List<Item> items;
	
    public SOrder(){
    	 // Jackson deserialization
    }
	
    public SOrder(long i, String u){
    	this.id = i;
    	this.username = u;
    	
    }
    
	@JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }
    
    @JsonProperty
    public List<Item> getItems(){
    	return items;
    }
    
    
	@JsonProperty
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public void setUsername(String u) {
        this.username = u;
    }
    
    @JsonProperty
    public void addItem(Item t){	
    	this.items.add(t);
    }

	public void setItems(List<Item> newItems) {
		this.items = newItems;
		
	}
}
