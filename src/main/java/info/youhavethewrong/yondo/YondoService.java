package info.youhavethewrong.yondo;

import info.youhavethewrong.yondo.util.SimpleAuthenticator;
import io.dropwizard.Application;
import io.dropwizard.auth.basic.BasicAuthProvider;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.*;

import org.skife.jdbi.v2.DBI;

public class YondoService extends Application<YondoConfiguration> {

    public static void main(String[] args) throws Exception {
	new YondoService().run(args);
    }

    @Override
    public void initialize(Bootstrap<YondoConfiguration> bootstrap) {
    }

    @Override
    public void run(YondoConfiguration config, Environment env) throws Exception {

	final DBIFactory factory = new DBIFactory();
	final DBI jdbi = factory.build(env, config.getDatabaseConfiguration(), "sqlite");

	final QuoteDAO quotes = jdbi.onDemand(QuoteDAO.class);
	populateQuotes(quotes);

	final RateOfTravelDAO travel = jdbi.onDemand(RateOfTravelDAO.class);
	populateTravelTable(travel);

	env.jersey().register(new YondoResource(quotes));
	env.jersey().register(new TableResource(travel));
	env.jersey().register(new DiceResource());
	env.jersey().register(new BasicAuthProvider<String>(new SimpleAuthenticator(), "user"));
    }

    private void populateQuotes(QuoteDAO dao) {
	dao.wipeQuotesTable();
	dao.createQuotesTable();
	dao.insert("Blade with whom I have lived, blade with whom now I die." + "Serve right and justice one last time."
		+ "Seek one last heart of evil, still one last life of pain." + "Cut well old friend, and then farewell."
		+ "-- Sir Orrin Neville-Smythe, from The Flight of Dragons", 1);
	dao.insert(
		"Malygris the magician sat in the topmost room of his tower that was builded on a conicall hill above the heart of Susran, capital of Poseidonis. "
			+ "Wrought of a dark stone mined from deep in the earth, perdurable and hard as the fabled adamant, this tower loomed above all others, "
			+ "and flung its shadow far on the roofs and domes of the city, even as the sinister power of Malygris had thrown its darkness on the minds of men.",
		2);
    }

    private void populateTravelTable(RateOfTravelDAO dao) {
	dao.wipeRatesOfTravelTable();
	dao.createRatesOfTravelTable();
	dao.addRatesOfTravel("road", "30", "15", "60", "30", "45");
	dao.addRatesOfTravel("track", "30", "15", "45", "15", "30");
	dao.addRatesOfTravel("grasslands", "30", "15", "45", "15", "45");
	dao.addRatesOfTravel("hills", "20", "10", "45", "10", "30");
	dao.addRatesOfTravel("forest", "20", "10", "30", "--", "--");
	dao.addRatesOfTravel("barrens", "15", "05", "20", "--", "--");
	dao.addRatesOfTravel("mountains", "15", "05", "20", "--", "--");
	dao.addRatesOfTravel("desert", "20", "10", "45", "05", "30");
	dao.addRatesOfTravel("dust", "10", "05", "05", "--", "20");
	dao.addRatesOfTravel("swamp", "10", "05", "05", "--", "--");
	dao.addRatesOfTravel("jungle", "10", "05", "--", "--", "--");
    }

}
