import static org.junit.Assert.*;


import org.junit.Test;


public class TestRemoveCape {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("RemoveCape.txt");
		out = Main.outputreader("RemoveCape.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
