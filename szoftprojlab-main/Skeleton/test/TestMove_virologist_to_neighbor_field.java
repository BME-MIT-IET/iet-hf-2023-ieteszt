import static org.junit.Assert.*;

import org.junit.Test;


public class TestMove_virologist_to_neighbor_field {

	@Test
	public void test() {
		String in = "";
		String out = "";
		in = Main.inputreader("Move_virologist_to_neighbor_field.txt");
		out = Main.outputreader("Move_virologist_to_neighbor_field.txt");
		
		assertTrue(Main.compare(in, out));
	}

}
