import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import classes.Replace;

public class ReplaceTest {
	@Test
	public void OneReplacement() {
		String text = "Salve {{ who }}, I wanted to send you a letter.\n";
		Map<String, String> replacement= new HashMap<>();
		replacement.put("who", "puer");
		assertEquals("Salve puer, I wanted to send you a letter.\n", Replace.replace(text, replacement));
    }
	
	@Test
	public void ComplexTest() {
		String text = "Salve {{ who {{ adjective }} }}, I wanted to send you a letter.\n";
		Map<String, String> replacement= new HashMap<>();
		replacement.put("who", "puer");
		replacement.put("adjective", "malus");
		assertEquals("Salve {{ who malus }}, I wanted to send you a letter.\n", Replace.replace(text, replacement));
	}
	
	@Test
	public void NothingToDo() {
		String text = "Salve puer, I wanted to send you a letter.\n";
		Map<String, String> replacement= new HashMap<>();
		assertEquals("Salve puer, I wanted to send you a letter.\n", Replace.replace(text, replacement));
	}
	
	@Test
	public void NotingInTheMap() {
		String text = "Salve {{ who }}, I wanted to send you a {{ what }}.\n";
		Map<String, String> replacement= new HashMap<>();
		assertEquals("Salve {{ who }}, I wanted to send you a {{ what }}.\n", Replace.replace(text, replacement));
	}
	
	@Test
	public void MultipleReplacements() {
		String text = "Salve {{ who }}, I wanted to send you a {{ what }}.\n";
		Map<String, String> replacement= new HashMap<>();
		replacement.put("who", "puer");
		replacement.put("what", "letter");
		assertEquals("Salve puer, I wanted to send you a letter.\n", Replace.replace(text, replacement));
	}	
}
