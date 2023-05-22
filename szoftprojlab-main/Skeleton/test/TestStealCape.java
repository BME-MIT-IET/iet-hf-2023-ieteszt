import static org.junit.Assert.*;

import org.junit.Test;
public class TestStealCape {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("StealCape.txt");
        out = Main.outputreader("StealCape.txt");

        assertTrue(Main.compare(in, out));
	}

}
