package dropfood.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import dropfood.api.User;
import io.dropwizard.hibernate.AbstractDAO;

public class UserDao extends AbstractDAO<User>{

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	
	}

	  public Optional<User> findById(Long id) {

	        return Optional.ofNullable(get(id));

	    }



	    public User create(User person) {

	        return persist(person);

	    }



	    @SuppressWarnings("unchecked")
		public List<User> findAll() {

	        return list(namedQuery("dropfood.api.User.findAll"));

	    }
	
}
