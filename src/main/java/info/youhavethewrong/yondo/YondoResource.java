package info.youhavethewrong.yondo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;

@Path("/")
public class YondoResource {
	private final QuoteDAO dao;

	public YondoResource(QuoteDAO dao) {
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
