package dropfood.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import dropfood.api.Order;
import io.dropwizard.hibernate.AbstractDAO;

public class OrderDao extends AbstractDAO<Order>{

	public OrderDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		
	}

	  public Optional<Order> findById(Long id) {

	        return Optional.ofNullable(get(id));

	    }



	    public Order create(Order o) {

	        return persist(o);

	    }



	    @SuppressWarnings("unchecked")
		public List<Order> findAll() {

	        return list(namedQuery("dropfood.api.Order.findAll"));

	    }
}
