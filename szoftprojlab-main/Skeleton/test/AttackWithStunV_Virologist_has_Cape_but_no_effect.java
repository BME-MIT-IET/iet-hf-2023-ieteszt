import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithStunV_Virologist_has_Cape_but_no_effect {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithStunV_Virologist_has_Cape_but_no_effect.txt");
		out = Main.outputreader("AttackWithStunV_Virologist_has_Cape_but_no_effect.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
