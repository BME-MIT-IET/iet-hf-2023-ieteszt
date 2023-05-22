import static org.junit.Assert.*;

import org.junit.Test;


public class TestAttackWithStunV_Virologist_has_Glove {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithStunV_Virologist_has_Glove.txt");
		out = Main.outputreader("AttackWithStunV_Virologist_has_Glove.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
