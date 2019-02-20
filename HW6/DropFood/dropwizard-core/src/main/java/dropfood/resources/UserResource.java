package dropfood.resources;

import dropfood.api.User;
import dropfood.db.UserDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Users/{userId}")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	 private final UserDao UsersDao;
	 
	 public UserResource(UserDao UsersD) {
	        this.UsersDao = UsersD;
	    }

	 	@GET
	    @UnitOfWork
	    public User getUser(@PathParam("userId") LongParam userId) {
	        return findSafely(userId.get());

	    }
	 	
		@POST
	    public List<User> addUser(User u) {
			UsersDao.create(u);
	        return UsersDao.findAll(); 
	    }
	
		 private User findSafely(long userId) {
			 return UsersDao.findById(userId).orElseThrow(() -> new NotFoundException("No such user."));
		 }
		
}
