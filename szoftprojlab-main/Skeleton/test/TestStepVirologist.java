import static org.junit.Assert.*;

import org.junit.Test;
public class TestStepVirologist {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("StepVirologist.txt");
        out = Main.outputreader("StepVirologist.txt");

        assertTrue(Main.compare(in, out));
	}

}
