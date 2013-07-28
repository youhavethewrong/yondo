package info.youhavethewrong.yondo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public class WeatherResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{dayOfYear}/{latitude}")
	public WeatherReport forecastWeather(
			@PathParam("dayOfYear") String dayOfYear,
			@PathParam("latitude") String latitude) {
		return new WeatherReport();
	}
}
