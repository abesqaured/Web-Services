package dropfood.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dropfood.api.Order;
import dropfood.db.OrderDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("Order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

	private final OrderDao OrdersDao;
	 
	 public OrderResource(OrderDao OrdersD) {
	        this.OrdersDao = OrdersD;
	    }

	 	@GET
	    @UnitOfWork
	    public Order getOrder(@PathParam("itemId") LongParam orderId) {
	        return findSafely(orderId.get());

	    }
	 	
		@POST
	    public List<Order> addItem(Order o) {
			OrdersDao.create(o);
	        return OrdersDao.findAll(); 
	    }
	
		private Order findSafely(long orderId) {
			 return OrdersDao.findById(orderId).orElseThrow(() -> new NotFoundException("No such user."));
		 }
}
