package info.youhavethewrong.yondo;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface QuoteDAO {
	@SqlUpdate("create table quotes (id int, content string)")
	void createSomethingTable();

	@SqlUpdate("insert into quotes (id, content) values (:id, :content)")
	void insert(@Bind("id") int id, @Bind("content") String content);

	@SqlQuery("select content from quotes where id = :id")
	String findContentById(@Bind("id") int id);
}
