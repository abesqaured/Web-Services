package dropfood.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;



public interface ItemDao{

	  @SqlUpdate("insert into item values (:id, :name, :price)")
	  void insert(@Bind("id") long id, @Bind("name") String name, @Bind("price") float price);

	  @SqlQuery("select name from item where id = :id")
	  String findItemNameById(@Bind("id") long id);
	  
	  @SqlQuery("select price from item where id = :id")
	  float findItemPriceById(@Bind("id") long id);
	  
	  @SqlQuery("select id from item")
	  List<Long> allIds();
	  
	  @SqlUpdate("delete from item where id = :id")
	  void deleteItem(@Bind("id") long id);
	  

}
