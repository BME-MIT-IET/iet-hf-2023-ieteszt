import static org.junit.Assert.*;

import org.junit.Test;


public class TestPickUpCape {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("PickUpCape.txt");
		out = Main.outputreader("PickUpCape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
