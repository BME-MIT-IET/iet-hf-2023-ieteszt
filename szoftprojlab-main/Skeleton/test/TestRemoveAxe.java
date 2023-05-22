import static org.junit.Assert.*;

import org.junit.Test;


public class TestRemoveAxe {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("RemoveAxe.txt");
		out = Main.outputreader("RemoveAxe.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
