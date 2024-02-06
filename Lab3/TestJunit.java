import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
	String message = "Hello World";
	Message messageUtil = new Message(message);
	String messageEx1 = "Goodbye World";
	@Test
	public void testPrintMessage() {
	assertEquals(messageEx1,messageUtil.printMessage());
	}
}