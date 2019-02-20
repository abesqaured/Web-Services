package dropfood.resources;


import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dropfood.api.Item;
import dropfood.db.ItemDao;


@Path("Items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

	 private final ItemDao ItemsDao;
	 
	 public ItemResource(ItemDao ItemsD) {
	        this.ItemsDao = ItemsD;
	    }

	 	@GET
	 	public List<Item> allItems(){
	 		List<Item> items = new ArrayList<Item>();
	 		List<Long> ids = ItemsDao.allIds();
	 		for(int i = 0; i < ids.size(); i++){
	 			Item t = new Item(ids.get(i), ItemsDao.findItemNameById(ids.get(i)), ItemsDao.findItemPriceById(ids.get(i)));
	 			items.add(t);
	 		}
	 		return items;
	 	}
	 	@GET
	 	@Path("/{itemId}")
	    public Item getItem(@PathParam("itemId") long itemId) {
	 		Item t = new Item(itemId, ItemsDao.findItemNameById(itemId), ItemsDao.findItemPriceById(itemId));
	 		return t;

	 		
	    }
	 	
		@POST
	    public List<Item> addItem(Item t) {
			ItemsDao.insert(t.getId(), t.getName(), t.getPrice());
			List<Item> items = new ArrayList<Item>();
	 		List<Long> ids = ItemsDao.allIds();
	 		for(int i = 0; i < ids.size(); i++){
	 			Item each = new Item(ids.get(i), ItemsDao.findItemNameById(ids.get(i)), ItemsDao.findItemPriceById(ids.get(i)));
	 			items.add(each);
	 		}
	 		return items;
	    }
	
		
}
