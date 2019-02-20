package dropfood;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;



public class dropfoodConfiguration extends Configuration {
	
	//@Valid
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
    
    @JsonProperty("database")
    public void setDatabase(DataSourceFactory database){
     this.database = database;
    }

}
