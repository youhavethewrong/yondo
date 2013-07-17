package info.youhavethewrong.yondo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/dice")
public class DiceResource {

	public DiceResource() {
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/roll")
	public List<Integer> rollDice(@QueryParam("diespec") String diespec) {
		DiceRoll dr = new DiceRoll();
		return dr.roll(diespec);
	}

}
