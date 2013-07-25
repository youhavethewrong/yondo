package info.youhavethewrong.yondo;

public class WeatherReport {

	private final int BASELINE_LATITUDE = 35

	private def period
	private def periodDay
	private def precipitationChance
	private def sky
	private def tempLow
	private def tempHigh

	/*
	 private def sunrise
	 private def sunset
	 */

	public String produceReport(dayOfYear) {
		period = determineTimePeriod(dayOfYear)
		sky = skyCondition()
		setPeriodData()

		def report = ""
		report += "Today is ${periodDay} ${period}.\n"
		report += "There is a ${precipitationChance}% chance of precipitation.\n"
		report += "The sky is ${sky}.\n"
		report += "High: ${tempHigh} F, Low: ${tempLow} F.\n"
		return report
	}

	public def skyCondition() {
		def roll = new DiceRoll().roll("1d3")[0]

		if (roll < 2) {
			return SkyCondition.CLEAR
		}
		else if (roll < 3) {
			return SkyCondition.PARTLY_CLOUDY
		}
		else {
			return SkyCondition.CLOUDY
		}
	}

	public def setPeriodData() {
		def dice = new DiceRoll()

		if (period == TimePeriod.Festivals.Needfest) {
			precipitationChance =  44
			def baseTemp = 31
			tempHigh = baseTemp + dice.roll("d8")[0]
			tempLow = baseTemp - dice.roll("d20+1")[0]
		}
		else if (period == TimePeriod.Months.Fireseek) {
			precipitationChance = 46
			def baseTemp = 32
			tempHigh = baseTemp + dice.roll("d10")[0]
			tempLow = baseTemp - dice.roll("d20")[0]
		}
		else if (period == TimePeriod.Months.Readying) {
			precipitationChance = 40
			def baseTemp = 34
			tempHigh = baseTemp + dice.roll("d6+4")[0]
			tempLow = baseTemp - dice.roll("d10+4")[0]
		}
		else if (period == TimePeriod.Months.Coldeven) {
			precipitationChance = 44
			def baseTemp = 42
			tempHigh = baseTemp + dice.roll("d8+4")[0]
			tempLow = baseTemp - dice.roll("d10+4")[0]
		}
		else if (period == TimePeriod.Festivals.Growfest) {
			precipitationChance = 43
			def baseTemp = 46
			tempHigh = baseTemp + dice.roll("d10")[0]
			tempLow = baseTemp - dice.roll("d10")[0]
		}
		else if (period == TimePeriod.Months.Planting) {
			precipitationChance = 42
			def baseTemp = 52
			tempHigh = baseTemp + dice.roll("d10+6")[0]
			tempLow = baseTemp - dice.roll("d8+4")[0]
		}
		else if (period == TimePeriod.Months.Flocktime) {
			precipitationChance = 42
			def baseTemp = 63
			tempHigh = baseTemp + dice.roll("d10+6")[0]
			tempLow = baseTemp - dice.roll("d10+6")[0]
		}
		else if (period == TimePeriod.Months.Wealsun) {
			precipitationChance = 36
			def baseTemp = 71
			tempHigh = baseTemp + dice.roll("d8+8")[0]
			tempLow = baseTemp - dice.roll("d6+6")[0]
		}
		else if (period == TimePeriod.Festivals.Richfest) {
			precipitationChance = 34
			def baseTemp = 74
			tempHigh = baseTemp + dice.roll("d6+8")[0]
			tempLow = baseTemp - dice.roll("d8+6")[0]
		}
		else if (period == TimePeriod.Months.Reaping) {
			precipitationChance = 33
			def baseTemp = 77
			tempHigh = baseTemp + dice.roll("d6+4")[0]
			tempLow = baseTemp - dice.roll("d6+6")[0]
		}
		else if (period == TimePeriod.Months.Goodmonth) {
			precipitationChance = 33
			def baseTemp = 75
			tempHigh = baseTemp + dice.roll("d4+6")[0]
			tempLow = baseTemp - dice.roll("d6+6")[0]
		}
		else if (period == TimePeriod.Months.Harvester) {
			precipitationChance = 33
			def baseTemp = 68
			tempHigh = baseTemp + dice.roll("d8+6")[0]
			tempLow = baseTemp - dice.roll("d8+6")[0]
		}
		else if (period == TimePeriod.Festivals.Brewfest) {
			precipitationChance = 35
			def baseTemp = 62
			tempHigh = baseTemp + dice.roll("d10+3")[0]
			tempLow = baseTemp - dice.roll("d10+3")[0]
		}
		else if (period == TimePeriod.Months.Patchwall) {
			precipitationChance = 36
			def baseTemp = 57
			tempHigh = baseTemp + dice.roll("d10+5")[0]
			tempLow = baseTemp - dice.roll("d10+5")[0]
		}
		else if (period == TimePeriod.Months.Readyreat) {
			precipitationChance = 40
			def baseTemp = 46
			tempHigh = baseTemp + dice.roll("d10+6")[0]
			tempLow = baseTemp - dice.roll("d10+4")[0]
		}
		else {
			precipitationChance = 43
			def baseTemp = 33
			tempHigh = baseTemp + dice.roll("d8+5")[0]
			tempLow = baseTemp - dice.roll("d20")[0]
		}
	}

	public def determineTimePeriod(dayOfYear) {
		def festivalLength = 7
		def monthLength = 28

		if(dayOfYear <= (festivalLength + 0*monthLength)) {
			periodDay = dayOfYear
			return TimePeriod.Festivals.Needfest
		}
		if(dayOfYear <= (festivalLength + 1*monthLength)) {
			periodDay = (dayOfYear - (festivalLength + 0*monthLength))
			return TimePeriod.Months.Fireseek
		}
		if(dayOfYear <= (festivalLength + 2*monthLength)) {
			periodDay = (dayOfYear - (festivalLength + 1*monthLength))
			return TimePeriod.Months.Readying
		}
		if(dayOfYear <= (festivalLength + 3*monthLength)) {
			periodDay = (dayOfYear - (festivalLength + 2*monthLength))
			return TimePeriod.Months.Coldeven
		}

		if(dayOfYear <= (2*festivalLength + 3*monthLength)) {
			periodDay = (dayOfYear - (2*festivalLength + 2*monthLength))
			return TimePeriod.Festivals.Growfest
		}
		if(dayOfYear <= (2*festivalLength + 4*monthLength)) {
			periodDay = (dayOfYear - (2*festivalLength + 3*monthLength))
			return TimePeriod.Months.Planting
		}
		if(dayOfYear <= (2*festivalLength + 5*monthLength)) {
			periodDay = (dayOfYear - (2*festivalLength + 4*monthLength))
			return TimePeriod.Months.Flocktime
		}
		if(dayOfYear <= (2*festivalLength + 6*monthLength)) {
			periodDay = (dayOfYear - (2*festivalLength + 5*monthLength))
			return TimePeriod.Months.Wealsun
		}

		if(dayOfYear <= (3*festivalLength + 6*monthLength)) {
			periodDay = (dayOfYear - (3*festivalLength + 5*monthLength))
			return TimePeriod.Festivals.Richfest
		}
		if(dayOfYear <= (3*festivalLength + 7*monthLength)) {
			periodDay = (dayOfYear - (3*festivalLength + 6*monthLength))
			return TimePeriod.Months.Reaping
		}
		if(dayOfYear <= (3*festivalLength + 8*monthLength)) {
			periodDay = (dayOfYear - (3*festivalLength + 7*monthLength))
			return TimePeriod.Months.Goodmonth
		}
		if(dayOfYear <= (3*festivalLength + 9*monthLength)) {
			periodDay = (dayOfYear - (3*festivalLength + 8*monthLength))
			return TimePeriod.Months.Harvester
		}

		if(dayOfYear <= (4*festivalLength + 9*monthLength)) {
			periodDay = (dayOfYear - (4*festivalLength + 8*monthLength))
			return TimePeriod.Festivals.Brewfest
		}
		if(dayOfYear <= (4*festivalLength + 10*monthLength)) {
			periodDay = (dayOfYear - (4*festivalLength + 9*monthLength))
			return TimePeriod.Months.Patchwall
		}
		if(dayOfYear <= (4*festivalLength + 11*monthLength)) {
			periodDay = (dayOfYear - (4*festivalLength + 10*monthLength))
			return TimePeriod.Months.Readyreat
		}
		periodDay = (dayOfYear - (4*festivalLength + 11*monthLength))
		return TimePeriod.Months.Sunsebb
	}
}
