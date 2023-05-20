import static org.junit.Assert.*;

import org.junit.Test;


public class SelfAttackWithVacina {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("SelfAttackWithVacina.txt");
        out = Main.outputreader("SelfAttackWithVacina.txt");

        assertTrue(Main.compare(in, out));
		
		
		
	}

}
