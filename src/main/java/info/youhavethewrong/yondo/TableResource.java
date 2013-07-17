package info.youhavethewrong.yondo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tables")
public class TableResource {

	private RateOfTravelDAO travelDao;

	public TableResource(RateOfTravelDAO travelDao) {
		this.travelDao = travelDao;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/settlement")
	public String getRandomSettlement() {
		DiceRoll dice = new DiceRoll();
		Integer roll = dice.roll("d100").get(0);
		if (roll < 50) {
			return "Thorp, population: " + dice.roll("2d4*10");
		} else if (roll < 75) {
			return "Hamlet, population: " + dice.roll("1d4*100");
		} else if (roll < 88) {
			return "Village, population: " + dice.roll("1d4+5*100");
		} else if (roll < 96) {
			return "Village, population: " + dice.roll("2d6+1*500");
		} else {
			return "City, population: " + dice.roll("5d6*2000");
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rot")
	public List<RateOfTravel> getAllRatesOfTravel() {
		return travelDao.getAllRates();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/rot/{terrain}")
	public RateOfTravel getRateOfTravel(@PathParam("terrain") String terrain) {
		return travelDao.findRatesByTerrain(terrain);
	}
}
