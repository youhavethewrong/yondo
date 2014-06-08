package info.youhavethewrong.yondo;

import io.dropwizard.Configuration;
import io.dropwizard.db.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YondoConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDatabaseConfiguration() {
	return database;
    }

    protected void setDatabaseConfiguration(DataSourceFactory database) {
	this.database = database;
    }
}
