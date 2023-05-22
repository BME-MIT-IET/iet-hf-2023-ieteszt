import static org.junit.Assert.*;

import org.junit.Test;

public class TestUseAxe {

	@Test
	public void test() {
		String in = new String();
        String out = new String();
        in = Main.inputreader("UseAxe.txt");
        out = Main.outputreader("UseAxe.txt");

        assertTrue(Main.compare(in, out));
	}

}
