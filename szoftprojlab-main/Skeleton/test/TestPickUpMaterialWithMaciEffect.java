import static org.junit.Assert.*;

import org.junit.Test;


public class TestPickUpMaterialWithMaciEffect {

	@Test
	public void test() {
		String in = new String();
		String out = new String();
		in = Main.inputreader("PickUpMaterialWithMaciEffect.txt");
		out = Main.outputreader("PickUpMaterialWithMaciEffect.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
