package info.youhavethewrong.yondo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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
		Integer result = ((ArrayList<Integer>) roll.roll("d6")).get(0);
		System.out.println("Got " + result + " from a d6");
		assertNotNull(result);
		assertTrue(result < 7);
		assertTrue(result > 0);
	}

	@Test
	public void shouldRollDpercent() {
		Integer result = ((ArrayList<Integer>) roll.roll("d%")).get(0);
		System.out.println("Got " + result + " from a d%");
		assertNotNull(result);
		assertTrue(result < 101);
		assertTrue(result > 0);
	}

	@Test
	public void shouldRoll3D6() {
		Integer result = ((ArrayList<Integer>) roll.roll("3d6")).get(0);
		System.out.println("Got " + result + " from a 3d6");
		assertNotNull(result);
		assertTrue(result < 19);
		assertTrue(result > 2);
	}

	@Test
	public void shouldRoll4D6DropLowest() {
		Integer result = ((ArrayList<Integer>) roll.roll("4d6s1")).get(0);
		System.out.println("Got " + result + " from a 4d6s1");
		assertNotNull(result);
		assertTrue(result < 19);
		assertTrue(result > 2);
	}

	@Test
	public void shouldRollSix4D6DropLowest() {
		List<Integer> result = (ArrayList<Integer>) roll.roll("6x4d6s1");
		System.out.println("Got " + result + " from 6x4d6s1");
		assertNotNull(result);
		for (int group : result) {
			assertTrue(group < 19);
			assertTrue(group > 2);
		}
	}

	@Test
	public void shouldRollDpercentTimes100() {
		Integer result = ((ArrayList<Integer>) roll.roll("d%*100")).get(0);
		System.out.println("Got " + result + " from d%*100");
		assertNotNull(result);
		assertTrue(result < 10001);
		assertTrue(result > 100);
	}

	@Test
	public void shouldRollD4Plus1() {
		Integer result = ((ArrayList<Integer>) roll.roll("d4+1")).get(0);
		System.out.println("Got " + result + " from d4+1");
		assertNotNull(result);
		assertTrue(result < 6);
		assertTrue(result > 1);
	}
}
