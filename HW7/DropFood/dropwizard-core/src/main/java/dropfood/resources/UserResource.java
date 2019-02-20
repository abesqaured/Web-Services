package dropfood.resources;

import dropfood.api.User;
import dropfood.db.UserDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Users/{userId}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	 private final UserDao UsersDao;
	 
	 public UserResource(UserDao UsersD) {
	        this.UsersDao = UsersD;
	    }

	 	@GET
	 	@Path("{userId}")
	    public User getUser(@PathParam("userId") long userId) {
	        return UsersDao.findUserById(userId);

	    }
	 	
	 	
	 	
		@POST
	    public List<User> addUser(User u) {
			UsersDao.insertUser(u.getId(), u.getUsername(), u.getPassword());
			return UsersDao.allUsers();
	    }
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<User> allUser(){
			return UsersDao.allUsers();
		}
	
		
}
