package Models;


import java.util.ArrayList;
import com.fasterxml.jackson.annotation.*;


public class Account {	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("password")
	private String password;
	
	private Database db;
	
	public Account(){
		db = new Database();
	}
	
	public Account(String u, String p){
		username = u;
		password = p;
		db = new Database();
		
	}
	
	public String GetName(){
		return username;
	}
	
	public String GetPassword(){
		return password;
	}
	

	public Account CheckDB(int id){

		return db.FindAccount(id);
	}
	
	public int FindId(Account a){
		return db.FindId(a);
	}
	

	public  ArrayList<Account> GetUsers(){
		return db.getUsers();
		
	}
	
}
