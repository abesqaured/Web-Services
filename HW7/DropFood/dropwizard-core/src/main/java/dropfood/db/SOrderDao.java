package dropfood.db;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import dropfood.api.Item;


public interface SOrderDao{

	 @SqlQuery("select id from sorder")
	 List<Long> getAllId();
	 
	 @SqlUpdate("create table :itemsname (name, price)")
	  void createItemsTable(@Bind("itemsname") String itemsname);
	 
	 @SqlUpdate("insert into :itemsname values (:name, :price )")
	  void insertItem(@Bind("itemsname") String itemsname, @Bind("name") String name, @Bind("price") float price);
	 
	  @SqlQuery("select name, price form :items")
	  List<Item> getItems(@Bind("items") String items);
	  
	  @SqlUpdate("insert into SOrder values (:id, :name, :items )")
	  void insert(@Bind("id") long id, @Bind("name") String name, @Bind("items") String Items);
	  

	  @SqlQuery("select username from SOrder where id = :id")
	  String findOrderUserById(@Bind("id") long id);
	  
	  @SqlQuery("select items from SOrder where id = :id")
	  String findOrderListById(@Bind("id") long id);
	  
	 
	  
}
