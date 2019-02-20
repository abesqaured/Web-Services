package dropfood.db;


import java.util.List;


import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import dropfood.api.User;


public interface UserDao{
	@SqlUpdate("delete  user values (:id, :username, :password)")
	  void deleteUser(@Bind("id") long id, @Bind("username") String name, @Bind("password") String password);

	  @SqlUpdate("insert into user values (:id, :username, :password)")
	  void insertUser(@Bind("id") long id, @Bind("username") String name, @Bind("password") String password);
	 
	  @SqlQuery("select name, password from user where id = :id")
	  User findUserById(@Bind("id") long id);
	  
	  @SqlQuery("select name, password form user")
	  List<User> allUsers();
	


}
