package info.youhavethewrong.yondo;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

@Path("/")
public class YondoResource {
	private Random prng;
	private final QuoteDAO dao;

	public YondoResource(QuoteDAO dao) {
		this.dao = dao;
		prng = new Random();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("quote")
	public Quote getRandomQuote(@QueryParam("id") Optional<String> id) {
		int selection = prng.nextInt(dao.countQuotes());
		String result = dao.findContentById(selection);
		return new Quote(selection, result);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("add")
	public String createNewQuote() {
		return "";
	}
}
