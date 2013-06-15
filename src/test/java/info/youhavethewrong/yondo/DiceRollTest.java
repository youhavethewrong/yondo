package info.youhavethewrong.yondo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class DiceRollTest {

	private DiceRoll roll;

	@Before
	public void setUp() {
		roll = new DiceRoll();
	}

	@Test
	public void shouldRollD6() {
		Integer result = (Integer) roll.roll("d6");
		System.out.println("Got " + result + " from a d6");
		assertNotNull(result);
		assertTrue(result < 7);
		assertTrue(result > 0);
	}

	@Test
	public void shouldRollDpercent() {
		Integer result = (Integer) roll.roll("d%");
		System.out.println("Got " + result + " from a d%");
		assertNotNull(result);
		assertTrue(result < 101);
		assertTrue(result > 0);
	}

	@Test
	public void shouldRoll3D6() {
		Integer result = (Integer) roll.roll("3d6");
		System.out.println("Got " + result + " from a 3d6");
		assertNotNull(result);
		assertTrue(result < 19);
		assertTrue(result > 2);
	}
}
