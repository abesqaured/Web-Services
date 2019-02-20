package HW2;

import java.util.HashMap;
import java.util.Map;

public class Account {
	private String user;
	private String password;
	private Map<String,String> users;
	private Account notFound = new Account("none","none");
	
	public Account(){
		users = new HashMap<>();
		startList();
	}
	
	public Account(String u, String p){
		user = u;
		password = p;
		users = new HashMap<>();
		startList();
		users.put(user, password);
	}
	
	public String getName(){
		return user;
	}
	
	public String getPassword(){
		return password;
	}
	
	private void startList(){
		users.put("shadow", "sonic");
		users.put("arabdude","password");
		users.put("sonic", "pika");
	}
	
	public Account checkDB(Account i){
		String check = i.getName();
		String checkPassword = i.getPassword();
		if(users.get(check).contains(checkPassword)){
			return i;
		}else{
			return notFound;
		}
	}
	
	public Map<String,String> getUsers(){
		return users;
	}
}
