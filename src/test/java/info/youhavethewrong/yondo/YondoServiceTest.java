package info.youhavethewrong.yondo;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import io.dropwizard.db.*;
import io.dropwizard.setup.Environment;

import org.junit.*;

public class YondoServiceTest {
    private final Environment environment = mock(Environment.class);
    private final YondoService service = new YondoService();
    private final YondoConfiguration config = new YondoConfiguration();

    public void setup() throws Exception {
	DataSourceFactory db = new DataSourceFactory();
	db.setUrl("jdbc:sqlite:test.db");
	db.setUser("sqlite");
	db.setDriverClass("org.sqlite.JDBC");
	config.setDatabaseConfiguration(db);
    }

    public void buildYondoResource() throws Exception {
	service.run(config, environment);
	verify(environment, times(3)).jersey().register(any(Object.class));
    }
}
