import static org.junit.Assert.*;

import org.junit.Test;
public class StealBackPack {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("StealBackPack.txt");
        out = Main.outputreader("StealBackPack.txt");

        assertTrue(Main.compare(in, out));
	}

}
