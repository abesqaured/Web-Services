package dropfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

public class User {
	private long id;
	
	@Length(max = 25)
	private String username;
	
	@Length(max = 25)
	private String password;
	
    public User(){
    	 // Jackson deserialization
    }
	
    public User(long i, String u, String p){
    	this.id = i;
    	this.username = u;
    	this.password = p;
    }
    
    //Getting variables in objects
	@JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }
    
    @JsonProperty
    public String getPassword(){
    	return password;
    }
    
    //Setting variables in objects
	@JsonProperty
    public void setId(long i) {
        this.id = i;
    }

    @JsonProperty
    public void setUsername(String u) {
        this.username = u;
    }
    
    @JsonProperty
    public void setPassword(String p){
    	this.password = p;
    }
}
