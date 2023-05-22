import static org.junit.Assert.*;

import org.junit.Test;

public class TestSelfAttackWithVirusDanceV {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("SelfAttackWithVirusDanceV.txt");
        out = Main.outputreader("SelfAttackWithVirusDanceV.txt");

        assertTrue(Main.compare(in, out));
	}

}
