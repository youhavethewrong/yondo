package info.youhavethewrong.yondo.util;

import info.youhavethewrong.yondo.RateOfTravel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class RateOfTravelMapper implements ResultSetMapper<RateOfTravel> {

	@Override
	public RateOfTravel map(int index, ResultSet result, StatementContext ctx)
			throws SQLException {
		return new RateOfTravel(result.getString("terrain"),
				result.getString("afoot_unenc"), result.getString("afoot_enc"),
				result.getString("horsed"), result.getString("wagon"),
				result.getString("camel"));
	}

}
