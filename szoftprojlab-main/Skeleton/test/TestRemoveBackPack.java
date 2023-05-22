import static org.junit.Assert.*;

import org.junit.Test;


public class TestRemoveBackPack {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("RemoveBackPack.txt");
		out = Main.outputreader("RemoveBackPack.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
