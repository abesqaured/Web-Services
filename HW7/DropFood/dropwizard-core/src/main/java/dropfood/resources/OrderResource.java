package dropfood.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dropfood.api.Item;
import dropfood.api.SOrder;
import dropfood.db.SOrderDao;

@Path("Order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

	private final SOrderDao OrdersDao;
	 
	 public OrderResource(SOrderDao OrdersD) {
	        this.OrdersDao = OrdersD;
	    }

	 	@GET
	 	public List<SOrder> getOrders(){
	 		List<SOrder> orders = new ArrayList<SOrder>();
	 		List<Long> ids = OrdersDao.getAllId();
	 		for(int i = 0; i < ids.size(); i++){
	 			orders.add(new SOrder(ids.get(i), OrdersDao.findOrderUserById(ids.get(i))));
	 		}
	 		return orders;
	 	}
	 	
	 	@GET
	 	@Path("{orderId}")	
	    public SOrder getOrder(@PathParam("orderId") long orderId) {
	 		String username = OrdersDao.findOrderUserById(orderId);
	 		SOrder found = new SOrder(orderId, username); 				
			found.setItems(OrdersDao.getItems(OrdersDao.findOrderListById(orderId)));
			return found;
	       
	    }
	 	
	 	@POST
	 	public void addOrder(SOrder o){
	 		String orderList = o.getUsername() + "list";
	 		OrdersDao.createItemsTable(orderList);
	 		
//	 		/*View SavedOrders*/
//	 		List<SOrder> orders = new ArrayList<SOrder>();
//	 		List<Long> ids = OrdersDao.getAllId();
//	 		for(int i = 0; i < ids.size(); i++){
//	 			orders.add(new SOrder(ids.get(i), OrdersDao.findOrderUserById(ids.get(i))));
//	 		}
//	 		return orders;	 		
	 	}
	 	
		@PUT
		@Path("{orderId}")
	    public SOrder addItem(@PathParam("orderId") long orderId, Item t) {
			String orderList = OrdersDao.findOrderListById(orderId);
			OrdersDao.insertItem(orderList, t.getName(), t.getPrice());
			String username = OrdersDao.findOrderUserById(orderId);
	 		SOrder found = new SOrder(orderId, username); 				
			found.setItems(OrdersDao.getItems(orderList));
			return found;
			
			
	    }
	
}
