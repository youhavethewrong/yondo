package info.youhavethewrong.yondo;

public class RateOfTravel {

	private final String terrain;
	private final String afoot_unenc;
	private final String afoot_enc;
	private final String horsed;
	private final String wagon;
	private final String camel;

	public RateOfTravel(String terrain, String afoot_unenc, String afoot_enc,
			String horsed, String wagon, String camel) {
		this.terrain = terrain;
		this.afoot_enc = afoot_enc;
		this.afoot_unenc = afoot_unenc;
		this.horsed = horsed;
		this.wagon = wagon;
		this.camel = camel;
	}

	public String getTerrain() {
		return terrain;
	}

	public String getAfoot_unenc() {
		return afoot_unenc;
	}

	public String getAfoot_enc() {
		return afoot_enc;
	}

	public String getHorsed() {
		return horsed;
	}

	public String getWagon() {
		return wagon;
	}

	public String getCamel() {
		return camel;
	}

}
