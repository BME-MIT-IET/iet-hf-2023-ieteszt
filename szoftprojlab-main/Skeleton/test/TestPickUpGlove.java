import static org.junit.Assert.*;

import org.junit.Test;


public class TestPickUpGlove {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("PickUpGlove.txt");
		out = Main.outputreader("PickUpGlove.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
