package info.youhavethewrong.yondo;

import org.skife.jdbi.v2.DBI;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;

public class YondoService extends Service<YondoConfiguration> {

	public static void main(String[] args) throws Exception {
		new YondoService().run(args);
	}

	@Override
	public void initialize(Bootstrap<YondoConfiguration> bootstrap) {
		bootstrap.setName("yondo");
	}

	@Override
	public void run(YondoConfiguration config, Environment env)
			throws Exception {
		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, config.getDatabaseConfiguration(),
				"sqlite");
		final QuoteDAO dao = jdbi.onDemand(QuoteDAO.class);

		env.addResource(new YondoResource(dao));
	}

}