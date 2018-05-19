package classes;
import java.util.Map;

public class Replace {
	public static String replace(String text, Map<String,String> replacement) {
		for (String k : replacement.keySet()) {				
			text = text.replaceAll("\\{\\{[ ]* " + k + "[ ]*\\}\\}", replacement.get(k));				
		}	
		return text;
	}
}
