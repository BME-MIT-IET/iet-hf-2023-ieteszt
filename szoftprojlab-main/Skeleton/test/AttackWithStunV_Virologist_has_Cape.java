import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithStunV_Virologist_has_Cape {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithStunV_Virologist_has_Cape.txt");
		out = Main.outputreader("AttackWithStunV_Virologist_has_Cape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
