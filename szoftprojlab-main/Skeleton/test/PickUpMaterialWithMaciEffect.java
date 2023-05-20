import static org.junit.Assert.*;

import org.junit.Test;


public class PickUpMaterialWithMaciEffect {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("PickUpMaterialWithMaciEffect.txt");
		out = Main.outputreader("PickUpMaterialWithMaciEffect.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
