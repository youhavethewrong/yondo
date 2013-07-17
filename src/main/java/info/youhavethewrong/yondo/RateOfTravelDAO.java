package info.youhavethewrong.yondo;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

public interface RateOfTravelDAO {
	@SqlUpdate("create table if not exists travel (terrain string, afoot_unenc string, afoot_enc string, horsed string, wagon string, camel string)")
	void createRatesOfTravelTable();

	@SqlUpdate("drop table if exists travel")
	void wipeRatesOfTravelTable();

	@SqlUpdate("insert into travel (terrain, afoot_unenc, afoot_enc, horsed, wagon, camel) values (:terrain, :afoot_unenc, :afoot_enc, :horsed, :wagon, :camel)")
	void addRatesOfTravel(@Bind("terrain") String terrain,
			@Bind("afoot_unenc") String afoot_unenc,
			@Bind("afoot_enc") String afoot_enc, @Bind("horsed") String horsed,
			@Bind("wagon") String wagon, @Bind("camel") String camel);

	@RegisterMapper(RateOfTravelMapper.class)
	@SqlQuery("select * from travel where terrain = :terrain")
	RateOfTravel findRatesByTerrain(@Bind("terrain") String terrain);

	@RegisterMapper(RateOfTravelMapper.class)
	@SqlQuery("select * from travel")
	List<RateOfTravel> getAllRates();
}
