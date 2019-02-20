package dropfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	
	private long id;
	
	private String name;
	
	private float price;
	
    public Item(){
    	 // Jackson deserialization
    }
	
    public Item(long i, String n, float p){
    	this.id = i;
    	this.name = n;
    	this.price = p;
    }
    
    //Get vairable of object
	@JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
    
    @JsonProperty
    public float getPrice(){
    	return price;
    }
    
    //Set variable of object
	@JsonProperty
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public void setName(String n) {
        this.name = n;
    }
    
    @JsonProperty
    public void setPrice(float p){
    	this.price = p;
    }
}
