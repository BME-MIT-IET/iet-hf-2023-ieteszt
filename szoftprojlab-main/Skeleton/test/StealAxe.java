import static org.junit.Assert.*;

import org.junit.Test;

public class StealAxe {

	@Test
	public void test() {
        String in = "";
		String out = "";
        in = Main.inputreader("StealAxe.txt");
        out = Main.outputreader("StealAxe.txt");

        assertTrue(Main.compare(in, out));
	}

}
