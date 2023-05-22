import static org.junit.Assert.*;

import org.junit.Test;

public class TestSelfAttackWithStunV {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("SelfAttackWithStunV.txt");
        out = Main.outputreader("SelfAttackWithStunV.txt");

        assertTrue(Main.compare(in, out));
	}

}
