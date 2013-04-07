package info.youhavethewrong.yondo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface QuoteDAO {

	@SqlQuery("select content from quotes where id = :id")
	String findContentById(@Bind("id") int id);
}
