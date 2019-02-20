package dropfood;

import dropfood.api.User;
import dropfood.db.ItemDao;
import dropfood.db.OrderDao;
import dropfood.db.UserDao;
import dropfood.api.Item;
import dropfood.api.Order;
import dropfood.resources.ItemResource;
import dropfood.resources.OrderResource;
import dropfood.resources.UserResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dropfoodApplication extends Application<dropfoodConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropfoodApplication().run(args);
      
    }

    @Override
    public String getName() {
        return "dropfood";
    }

    @Override
    public void initialize(final Bootstrap<dropfoodConfiguration> bootstrap) {
			bootstrap.addBundle(hibernate);
			bootstrap.addBundle(hibernateTwo);
			bootstrap.addBundle(hibernateThree);

    }



    @Override
    public void run(final dropfoodConfiguration configuration, final Environment environment) {
    	final UserDao udao = new UserDao(hibernate.getSessionFactory());
    	UserResource userResource = new UserResource(udao);
        environment.jersey().register(userResource);
        
        final ItemDao tdao = new ItemDao(hibernate.getSessionFactory());
        ItemResource itemResource = new ItemResource(tdao);
        environment.jersey().register(itemResource);
        
        final OrderDao odao = new OrderDao(hibernate.getSessionFactory());
        OrderResource orderResource = new OrderResource(odao);
        environment.jersey().register(orderResource);
        
    }
	
	 private final HibernateBundle<dropfoodConfiguration> hibernate = new HibernateBundle<dropfoodConfiguration>(User.class) {
     @Override
     public DataSourceFactory getDataSourceFactory(dropfoodConfiguration configuration) {
         return configuration.getDataSourceFactory();
     }
 };

 	 private final HibernateBundle<dropfoodConfiguration> hibernateTwo = new HibernateBundle<dropfoodConfiguration>(Item.class) {
     @Override
     public DataSourceFactory getDataSourceFactory(dropfoodConfiguration configuration) {
         return configuration.getDataSourceFactory();
     }
 	 };
 
 private final HibernateBundle<dropfoodConfiguration> hibernateThree = new HibernateBundle<dropfoodConfiguration>(Order.class) {
     @Override
     public DataSourceFactory getDataSourceFactory(dropfoodConfiguration configuration) {
         return configuration.getDataSourceFactory();
     }
 };

}
