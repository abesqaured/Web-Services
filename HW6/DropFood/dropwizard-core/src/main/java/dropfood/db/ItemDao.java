package dropfood.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import dropfood.api.Item;
import io.dropwizard.hibernate.AbstractDAO;

public class ItemDao extends AbstractDAO<Item>{

	public ItemDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		
	}
	
	  public Optional<Item> findById(Long id) {

	        return Optional.ofNullable(get(id));

	    }

	    public Item create(Item t) {
	        return persist(t);

	    }

	    @SuppressWarnings("unchecked")
		public List<Item> findAll() {

	        return list(namedQuery("dropfood.api.Item.findAll"));

	    }

}
