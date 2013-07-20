package info.youhavethewrong.yondo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WeatherReportTest {

	private WeatherReport report

	@Before
	public void setUp() throws Exception {
		report = new WeatherReport()
	}

	@Test
	public void shouldDetermineFireseek() {
		assertEquals(TimePeriod.Months.Fireseek, report.determineTimePeriod(14))
	}

	@Test
	public void shouldDetermineBrewfest() {
		assertEquals(TimePeriod.Festivals.Brewfest, report.determineTimePeriod(279))
	}

	@Test
	public void coldevenShouldBeFairlyRainy() {
		assertEquals(0.44, report.getPrecipitationChance(TimePeriod.Months.Coldeven))
	}
}
