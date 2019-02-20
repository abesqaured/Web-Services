package dropfood.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

@Table(name = "Items")

@NamedQueries(

    {

        @NamedQuery(

            name = "dropfood.api.Item.findAll",

            query = "SELECT t FROM Item t"

        )

    })

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Length(max = 25)
	@Column(name = "username", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
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
