import static org.junit.Assert.*;

import org.junit.Test;

public class TestUseAxe {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("UseAxe.txt");
        out = Main.outputreader("UseAxe.txt");

        assertTrue(Main.compare(in, out));
	}

}
