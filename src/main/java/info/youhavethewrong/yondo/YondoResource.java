package info.youhavethewrong.yondo;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

@Path("/")
public class YondoResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	private final QuoteDAO dao;

	public YondoResource(String template, String defaultName, QuoteDAO dao) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
		this.dao = dao;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("quote")
	public Quote getRandomQuote(@QueryParam("id") Optional<String> id) {
		String result = dao.findContentById(0);
		return new Quote(0, result);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("add")
	public String createNewQuote() {
		return "";
	}
}
