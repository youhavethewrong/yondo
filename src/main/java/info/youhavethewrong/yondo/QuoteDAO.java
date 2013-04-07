package info.youhavethewrong.yondo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface QuoteDAO {
	@SqlUpdate("create table quotes (id int, content string)")
	void createSomethingTable();

	@SqlUpdate("insert into quotes (id, content) values (:id, :content)")
	void insert(@Bind("content") String content);

	@SqlUpdate("insert into quotes (content) values (:content)")
	void insertAuto(@Bind("content") String content);
	
	@SqlQuery("select content from quotes where rowid = :id")
	String findContentById(@Bind("id") int id);

	@SqlQuery("select count(*) from quotes")
	int countQuotes();
}
