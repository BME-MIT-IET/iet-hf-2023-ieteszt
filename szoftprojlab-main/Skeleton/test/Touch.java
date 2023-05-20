import static org.junit.Assert.*;

import org.junit.Test;

public class Touch {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("Touch.txt");
        out = Main.outputreader("Touch.txt");

        assertTrue(Main.compare(in, out));
	}

}
