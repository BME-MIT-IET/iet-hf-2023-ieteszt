import static org.junit.Assert.*;

import org.junit.Test;


public class AttackWithVirusDanceV_Virologist_has_Vacina {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("AttackWithVirusDanceV_Virologist_has_Vacina.txt");
		out = Main.outputreader("AttackWithVirusDanceV_Virologist_has_Vacina.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
