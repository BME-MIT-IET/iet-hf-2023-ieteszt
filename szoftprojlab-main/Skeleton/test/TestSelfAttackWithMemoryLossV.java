import static org.junit.Assert.*;

import org.junit.Test;


public class TestSelfAttackWithMemoryLossV {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("SelfAttackWithMemoryLossV.txt");
        out = Main.outputreader("SelfAttackWithMemoryLossV.txt");

        assertTrue(Main.compare(in, out));
	}

}
