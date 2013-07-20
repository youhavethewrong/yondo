package info.youhavethewrong.yondo;

public class WeatherReport {

	private final int BASELINE_LATITUDE = 40

	private def period
	private def dayOfYear

	/*
	 private def latitude
	 private def tempHigh
	 private def tempLow
	 private SkyCondition sky
	 private def precipitationChance
	 private def sunrise
	 private def sunset
	 */

	public def getPrecipitationChance(period) {
		if (period == TimePeriod.Festivals.Needfest) {
			return 0.44
		}
		if (period == TimePeriod.Months.Fireseek) {
			return 0.46
		}
		if (period == TimePeriod.Months.Readying) {
			return 0.40
		}
		if (period == TimePeriod.Months.Coldeven) {
			return 0.44
		}
		if (period == TimePeriod.Festivals.Growfest) {
			return 0.43
		}
		if (period == TimePeriod.Months.Planting) {
			return 0.42
		}
		if (period == TimePeriod.Months.Flocktime) {
			return 0.42
		}
		if (period == TimePeriod.Months.Wealsun) {
			return 0.36
		}
		if (period == TimePeriod.Festivals.Richfest) {
			return 0.34
		}
		if (period == TimePeriod.Months.Reaping) {
			return 0.33
		}
		if (period == TimePeriod.Months.Goodmonth) {
			return 0.33
		}
		if (period == TimePeriod.Festivals.Brewfest) {
			return 0.35
		}
		if (period == TimePeriod.Months.Patchwall) {
			return 0.36
		}
		if (period == TimePeriod.Months.Readyreat) {
			return 0.40
		}
		return 0.43
	}

	public def determineTimePeriod(dayOfYear) {
		def festivalLength = 7
		def monthLength = 28

		if(dayOfYear < (festivalLength + 0*monthLength)) {
			return TimePeriod.Festivals.Needfest
		}
		if(dayOfYear < (festivalLength + 1*monthLength)) {
			return TimePeriod.Months.Fireseek
		}
		if(dayOfYear < (festivalLength + 2*monthLength)) {
			return TimePeriod.Months.Readying
		}
		if(dayOfYear < (festivalLength + 3*monthLength)) {
			return TimePeriod.Months.Coldeven
		}

		if(dayOfYear < (2*festivalLength + 3*monthLength)) {
			return TimePeriod.Festivals.Growfest
		}
		if(dayOfYear < (2*festivalLength + 4*monthLength)) {
			return TimePeriod.Months.Planting
		}
		if(dayOfYear < (2*festivalLength + 5*monthLength)) {
			return TimePeriod.Months.Flocktime
		}
		if(dayOfYear < (2*festivalLength + 6*monthLength)) {
			return TimePeriod.Months.Wealsun
		}

		if(dayOfYear < (3*festivalLength + 6*monthLength)) {
			return TimePeriod.Festivals.Richfest
		}
		if(dayOfYear < (3*festivalLength + 7*monthLength)) {
			return TimePeriod.Months.Reaping
		}
		if(dayOfYear < (3*festivalLength + 8*monthLength)) {
			return TimePeriod.Months.Goodmonth
		}
		if(dayOfYear < (3*festivalLength + 9*monthLength)) {
			return TimePeriod.Months.Harvester
		}

		if(dayOfYear < (4*festivalLength + 9*monthLength)) {
			return TimePeriod.Festivals.Brewfest
		}
		if(dayOfYear < (4*festivalLength + 10*monthLength)) {
			return TimePeriod.Months.Patchwall
		}
		if(dayOfYear < (4*festivalLength + 11*monthLength)) {
			return TimePeriod.Months.Readyreat
		}
		return TimePeriod.Months.Sunsebb
	}
}
