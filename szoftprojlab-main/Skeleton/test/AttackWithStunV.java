import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithStunV {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithStunV.txt");
		out = Main.outputreader("AttackWithStunV.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
