import static org.junit.Assert.*;

import org.junit.Test;


public class MaciInfectsVirologist {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("MaciInfectsVirologist.txt");
		out = Main.outputreader("MaciInfectsVirologist.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
