package dropfood;


import dropfood.db.ItemDao;
import dropfood.db.SOrderDao;
import dropfood.db.UserDao;
import org.skife.jdbi.v2.DBI;
import dropfood.resources.ItemResource;
import dropfood.resources.OrderResource;
import dropfood.resources.UserResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class dropfoodApplication extends Application<dropfoodConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropfoodApplication().run(args);
      
    }

    @Override
    public void initialize(final Bootstrap<dropfoodConfiguration> bootstrap) {
    	

    }



    @Override
    public void run(final dropfoodConfiguration configuration, final Environment environment) {
    	final DBIFactory factory = new DBIFactory();
    	final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "jdbc:mysql://localhost:3306/dropfood");
    	final UserDao udao = jdbi.onDemand(UserDao.class);
    	UserResource userResource = new UserResource(udao);
        environment.jersey().register(userResource);
        
        final ItemDao tdao =  jdbi.onDemand(ItemDao.class);
        ItemResource itemResource = new ItemResource(tdao);
        environment.jersey().register(itemResource);
        
        final SOrderDao odao = jdbi.onDemand(SOrderDao.class);
        OrderResource orderResource = new OrderResource(odao);
        environment.jersey().register(orderResource);
        
    }
	


}
