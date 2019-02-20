package Models;

import java.sql.*;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Database {
	private String savedorder;
	private ArrayList<Account> userList;
	private ArrayList<Item> itemsList;
	private Account notAccount;
	private Account foundAccount;
	private Item notFound;
	private Item foundItem;
	
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private float price;

	
	
	public  ArrayList<Account> getUsers(){
		try{
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			userList = new ArrayList<Account>();
			Statement stmt =  conn.createStatement();
			
			String strSelect = "select * from users;";
			ResultSet rset = stmt.executeQuery(strSelect);
			
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        	userName = rset.getString("username");
	            password = rset.getString("password");
	            userList.add(new Account(userName,password));
	         }
	         return userList;

			
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("The gag is something went wrong with sql.");
			return userList;
		}
		
	
	}
	
	public ArrayList<Item> getItems(){
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			itemsList = new ArrayList<Item>();
			java.sql.Statement stmt = conn.createStatement();
			
			String strSelect = "select * from items;";

	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            name = rset.getString("name");
	            price = rset.getFloat("price");
	            itemsList.add(new Item(name,price));
	         }
	         return itemsList;

			
		}catch(SQLException ex){
			System.out.println("The gag is something went wrong with sql.");
			ex.printStackTrace();
			return itemsList;
		}
	}


	
	public Account FindAccount(int id){

		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt = conn.createStatement();
			
			String strSelect = "select * from users where id = " + id +";";

	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        	 userName = rset.getString("username");
	        	 password = rset.getString("password");
	        	 foundAccount = new Account(userName,password);
	   
	            System.out.println("Account is : " + userName + " " + password );
	         }
	         return foundAccount; 

			
		}catch(SQLException ex){
			System.out.println("The gag is something went wrong with sql.");
			ex.printStackTrace();
				notAccount = new Account("none","none");
				return notAccount;
			
		
		}
	}


	public Item FindItem(int id){
	try{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
		Statement stmt = conn.createStatement();
		
		String strSelect = "select * from items where id = " + id +";";
		
        ResultSet rset = stmt.executeQuery(strSelect);
        
        
         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
        	  name = rset.getString("name");
        	  price = rset.getFloat("price");
        	 foundItem = new Item(name,price);
            System.out.println("Item Found: " + name + " for $" + price);
         }
         return foundItem; 

		
	}catch(SQLException ex){
		ex.printStackTrace();
		System.out.println("The gag is something went wrong with sql.");
			notFound = new Item("none",(float) 0);
			return notFound;
		
	}
	}

	public void addItem (Item t){
		try{
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt =  conn.createStatement();
			String strSelect = "select * from users;";
			ResultSet rset = stmt.executeQuery(strSelect);
			int newId = 100;
			
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            int id = rset.getInt("id");
	            if(newId == id){
	            	newId++;
	            }
	            
	         }

	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
	         Statement stmtTwo =  conn.createStatement();
	         strSelect = "INSERT INTO items VALUES ("+ newId + ", '" + t.GetName() + "', " + t.GetPrice() +")";
	         stmtTwo.execute(strSelect);
	         
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Oh no, something happened. I could not add the new item.");
		}
	}
	
	public void addAccount(Account a){
		try{
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt =  conn.createStatement();
			
			String strSelect = "select * from users;";
			ResultSet rset = stmt.executeQuery(strSelect);
			int newId = 100;
			
			System.out.println("Determing the new id.");
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            int id = rset.getInt("id");
	            if(newId == id){
	            	newId++;
	            }
	         }
	         

	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
	         Statement stmtTwo =  conn.createStatement();
	         strSelect = "INSERT INTO users VALUES ("+ newId + ",'" + a.GetName() + "', '" + a.GetPassword() +"')";
	         stmtTwo.execute(strSelect);
	         System.out.println(" Account made");
	         
		}catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Oh no, something happened. I could not add the new account.");
		}
	}

	
	public int FindId(Account a){

		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt = conn.createStatement();
			int id = 0;
			String strSelect = "select * from users where username = '" + a.GetName() +"' AND password = '" + a.GetPassword() + "' ;";

	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        	 id = rset.getInt("id");
	         }
	         return id; 

			
		}catch(SQLException ex){
			System.out.println("The gag is something went wrong with sql.");
			ex.printStackTrace();
				int id  = 0;
				return id;
			
		
		}
	}

	public int FindItemId(Item it){

		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt = conn.createStatement();
			int id = 0;
			String strSelect = "select * from items where name = '" + it.GetName() +"' AND price = '" + it.GetPrice() + "' ;";

	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        	 id = rset.getInt("id");
	         }
	         return id; 

			
		}catch(SQLException ex){
			System.out.println("The gag is something went wrong with sql.");
			ex.printStackTrace();
				int id  = 0;
				return id;
			
		
		}
	}

	public ArrayList<Item> SavedOrder(int id) {
		ArrayList<Item> foundOrder = new ArrayList<Item>();
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt = conn.createStatement();
			
			String strSelect = "select * from savedorders where userid = " + id +";";
			System.out.println(strSelect);
	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {  
	        	 savedorder = rset.getString("ordername");
	        	 System.out.println(savedorder + "is found.");
	         }
	         
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
	         Statement stmtTwo = conn.createStatement();
	         strSelect = "select * from " + savedorder + ";";
	         System.out.println(strSelect);
	         ResultSet rsetTwo = stmtTwo.executeQuery(strSelect);
	         while(rsetTwo.next()) {  
	        	 name = rsetTwo.getString("name");
	        	 price = rsetTwo.getFloat("price");
	        	 foundOrder.add(new Item(name,price));
	        	 System.out.println(foundOrder.toString());
	         }
	         return foundOrder; 

			
		}catch(SQLException ex){
			System.out.println("The gag is something went wrong with sql.");
			ex.printStackTrace();
			foundOrder.add(new Item("none",(float) 0.0));
			return foundOrder;
		}catch(NullPointerException en){
			en.printStackTrace();
			System.out.println("Oh No, It was not found");
			foundOrder.add(new Item("none",(float) 0.0));
			return foundOrder;
		}
	}

	public void AddToSaveOrder(int id, Item t){
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
			Statement stmt = conn.createStatement();
			String savedorder = null;
			String strSelect = "select * from savedorders where userid = " + id +";";

	         ResultSet rset = stmt.executeQuery(strSelect);
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	        	 savedorder = rset.getString("ordername");
	         }
	         
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakefood?useSSL=false", "abeabe", "shadow");
	         Statement stmtTwo = conn.createStatement();
	         strSelect = "INSERT INTO "+ savedorder +" VALUES ('" + t.GetName() + "', " + t.GetPrice() +")";
	         stmtTwo.execute(strSelect);

	       
			
		}catch(SQLException ex){
			System.out.println("The gag is something went wrong with sql.");
			ex.printStackTrace();
		}catch(NullPointerException e){
			System.out.println("The id doesn't exist.");
		}
	}
}
