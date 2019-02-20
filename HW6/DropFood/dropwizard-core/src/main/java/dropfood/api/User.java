package dropfood.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity

@Table(name = "Users")

@NamedQueries(

    {

        @NamedQuery(

            name = "dropfood.api.User.findAll",

            query = "SELECT u FROM User u"

        )

    })

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Length(max = 25)
	@Column(name = "username", nullable = false)
	private String username;
	
	@Length(max = 25)
	@Column(name = "password", nullable = false)
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
