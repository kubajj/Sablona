import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


public class ReplaceTest {
	@Test
	public void oneReplacement() {
		String text = "Salve {{ who }}, I wanted to send you a letter.\n";
		Map<String, String> replacement= new HashMap<>();
		replacement.put("who", "puer");
		assertEquals("Salve puer, I wanted to send you a letter.\n", Replace.replace(text, replacement));
    }
	
	@Test
	public void complexTest() {
		String text = "Salve {{ who {{ adjective }} }}, I wanted to send you a letter.\n";
		Map<String, String> replacement= new HashMap<>();
		replacement.put("who", "puer");
		replacement.put("adjective", "malus");
		assertEquals("Salve {{ who malus }}, I wanted to send you a letter.\n", Replace.replace(text, replacement));
	}
	
	@Test
	public void nothingToDo() {
		String text = "Salve puer, I wanted to send you a letter.\n";
		Map<String, String> replacement= new HashMap<>();
		assertEquals("Salve puer, I wanted to send you a letter.\n", Replace.replace(text, replacement));
	}
	
	@Test
	public void notingInTheMap() {
		String text = "Salve {{ who }}, I wanted to send you a {{ what }}.\n";
		Map<String, String> replacement= new HashMap<>();
		assertEquals("Salve {{ who }}, I wanted to send you a {{ what }}.\n", Replace.replace(text, replacement));
	}
	
	@Test
	public void multipleReplacements() {
		String text = "Salve {{ who }}, I wanted to send you a {{ what }}.\n";
		Map<String, String> replacement= new HashMap<>();
		replacement.put("who", "puer");
		replacement.put("what", "letter");
		assertEquals("Salve puer, I wanted to send you a letter.\n", Replace.replace(text, replacement));
	}	
}
