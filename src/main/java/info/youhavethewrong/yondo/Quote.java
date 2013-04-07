package info.youhavethewrong.yondo;

public class Quote {

	private final long id;
	private final String content;

	public Quote(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
