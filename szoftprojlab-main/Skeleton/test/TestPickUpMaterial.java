import static org.junit.Assert.*;

import org.junit.Test;


public class TestPickUpMaterial {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("PickUpMaterial.txt");
		out = Main.outputreader("PickUpMaterial.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
