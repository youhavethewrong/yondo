package info.youhavethewrong.yondo;

import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.auth.Auth;

@Path("/yondo")
public class YondoResource {
	private Random prng;
	private final QuoteDAO dao;

	public YondoResource(QuoteDAO dao) {
		this.dao = dao;
		prng = new Random();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/quote")
	public Quote getRandomQuote() {
		int selection = prng.nextInt(dao.countQuotes()) + 1;
		String result = dao.findContentById(selection);
		return new Quote(selection, result);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/quote/add")
	public void createNewQuote(@FormParam("content") String content,
			@Auth String user) {
		if (user != null) {
			dao.insertAuto(content);
		} else {
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}
}
