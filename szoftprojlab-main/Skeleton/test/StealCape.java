import static org.junit.Assert.*;

import org.junit.Test;
public class StealCape {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("StealCape.txt");
        out = Main.outputreader("StealCape.txt");

        assertTrue(Main.compare(in, out));
	}

}
