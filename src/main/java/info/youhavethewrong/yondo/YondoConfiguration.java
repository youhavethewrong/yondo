package info.youhavethewrong.yondo;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

public class YondoConfiguration extends Configuration {

	@NotEmpty
	@JsonProperty
	private String template;

	@NotEmpty
	@JsonProperty
	private String defaultName = "Stranger";

	@Valid
	@NotEmpty
	@JsonProperty
	private DatabaseConfiguration database;

	public String getTemplate() {
		return template;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public DatabaseConfiguration getDatabase() {
		return database;
	}

}
