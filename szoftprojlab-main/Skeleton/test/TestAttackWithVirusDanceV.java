import static org.junit.Assert.*;

import org.junit.Test;


public class TestAttackWithVirusDanceV {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithVirusDanceV.txt");
		out = Main.outputreader("AttackWithVirusDanceV.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
