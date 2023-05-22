import static org.junit.Assert.*;

import org.junit.Test;


public class TestMoveMaci {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("MoveMaci.txt");
		out = Main.outputreader("MoveMaci.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
