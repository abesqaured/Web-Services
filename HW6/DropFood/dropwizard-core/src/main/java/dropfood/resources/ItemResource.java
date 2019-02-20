package dropfood.resources;


import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dropfood.api.Item;
import dropfood.db.ItemDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/Items/{itemId}")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

	 private final ItemDao ItemsDao;
	 
	 public ItemResource(ItemDao ItemsD) {
	        this.ItemsDao = ItemsD;
	    }

	 	@GET
	    @UnitOfWork
	    public Item getItem(@PathParam("itemId") LongParam itemId) {
	        return findSafely(itemId.get());

	    }
	 	
		@POST
	    public List<Item> addItem(Item t) {
			ItemsDao.create(t);
	        return ItemsDao.findAll(); 
	    }
	
		 private Item findSafely(long itemId) {
			 return ItemsDao.findById(itemId).orElseThrow(() -> new NotFoundException("No such user."));
		 }
}
