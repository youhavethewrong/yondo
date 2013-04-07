package info.youhavethewrong.yondo;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;

public class YondoServiceTest {
	private final Environment environment = mock(Environment.class);
	private final YondoService service = new YondoService();
	private final YondoConfiguration config = new YondoConfiguration();

	@Before
	public void setup() throws Exception {
		DatabaseConfiguration db = new DatabaseConfiguration();
		db.setUrl("jdbc:sqlite:test.db");
		db.setUser("sqlite");
		db.setDriverClass("org.sqlite.JDBC");
		config.setDatabaseConfiguration(db);
	}

	@Test
	public void buildYondoResource() throws Exception {
		service.run(config, environment);
		verify(environment).addResource(any(YondoResource.class));
	}
}
