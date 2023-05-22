import static org.junit.Assert.*;

import org.junit.Test;

public class TestStepVitusDanceEffect {

	@Test
	public void test() {
		String in = "";
		String out = "";
        in = Main.inputreader("StepVitusDanceEffect.txt");
        out = Main.outputreader("StepVitusDanceEffect.txt");

        assertTrue(Main.compare(in, out));
	}

}
