import static org.junit.Assert.*;

import org.junit.Test;


public class TestPickUpBackPack {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("PickUpBackPack.txt");
		out = Main.outputreader("PickUpBackPack.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
