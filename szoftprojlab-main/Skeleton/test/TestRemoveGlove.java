import static org.junit.Assert.*;

import org.junit.Test;


public class TestRemoveGlove {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("RemoveGlove.txt");
		out = Main.outputreader("RemoveGlove.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
