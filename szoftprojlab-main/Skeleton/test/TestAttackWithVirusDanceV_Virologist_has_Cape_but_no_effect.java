import static org.junit.Assert.*;

import org.junit.Test;


public class TestAttackWithVirusDanceV_Virologist_has_Cape_but_no_effect {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithVirusDanceV_Virologist_has_Cape_but_no_effect.txt");
		out = Main.outputreader("AttackWithVirusDanceV_Virologist_has_Cape_but_no_effect.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
