import static org.junit.Assert.*;

import org.junit.Test;


public class PickUpCape {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("PickUpCape.txt");
		out = Main.outputreader("PickUpCape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
