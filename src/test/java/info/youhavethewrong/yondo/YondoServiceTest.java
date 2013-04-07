package info.youhavethewrong.yondo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;

public class YondoServiceTest {
	private final Environment environment = mock(Environment.class);
	private final YondoService service = new YondoService();
	private final YondoConfiguration config = new YondoConfiguration();

	@Before
	public void setup() throws Exception {
		DatabaseConfiguration db = new DatabaseConfiguration();
		db.setDriverClass("org.sqlite.JDBC");
		db.setUrl("jdbc:sqlite:test.db");
	}

	@Ignore
	@Test
	public void buildYondoResource() throws Exception {
		service.run(config, environment);
		verify(environment).addResource(any(YondoResource.class));
	}
}
