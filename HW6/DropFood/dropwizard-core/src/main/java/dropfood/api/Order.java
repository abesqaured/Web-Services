package dropfood.api;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Orders")
@NamedQueries(

    {
    	
        @NamedQuery(
            name = "dropfood.api.Order.findAll",
            query = "SELECT o FROM Order p"
        )
    })

public class Order {
	private long id;
	
	@Length(max = 25)
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "items", nullable = false)
	private ArrayList<Item> items;
	
    public Order(){
    	 // Jackson deserialization
    }
	
    public Order(long i, String u){
    	this.id = i;
    	this.username = u;
    	this.items = new ArrayList<Item>();
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
    public ArrayList<Item> getItems(){
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
}
